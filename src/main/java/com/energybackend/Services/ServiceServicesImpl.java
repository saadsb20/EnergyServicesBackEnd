package com.energybackend.Services;

import Contract.EnergyServicesContract;
import com.energybackend.EnergyBackEndApplication;
import com.energybackend.LoadedContract;
import com.energybackend.Repository.ServiceRepository;
import com.energybackend.dtos.ServiceInput;
import com.energybackend.jwt.dtos.UserExistDto;
import com.energybackend.jwt.dtos.UserResp;
import com.energybackend.jwt.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class ServiceServicesImpl implements ServiceServices{
    private final static String PRIVATE_KEY = "9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final static String CONTRACT_ADDRESS = "0x46f29a581fd8e0e4096ec8f0a92d61309e025e6d";
    private static final Logger log = LoggerFactory.getLogger(EnergyBackEndApplication.class);


    @Autowired
    ServiceRepository ServiceRepository;
    @Autowired
    AccountService accountService;

    @Override
    public List<com.energybackend.Entity.Service> MyServices() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserExistDto userExistDto = new UserExistDto();
        userExistDto.setUsername((String) auth.getPrincipal());
        UserResp userResp = accountService.getUser(userExistDto.getUsername());
        return ServiceRepository.findAllByBeneficiary(userResp.getAddress());
    }

    @Override
    public List<com.energybackend.Entity.Service> AllServices() {
            return ServiceRepository.findAll();
    }

    @Override
    public List<com.energybackend.Entity.Service> AllServicesByDate(LocalDate date) {
        return ServiceRepository.findAllByDate(date);
    }

    @Override
    public com.energybackend.Entity.Service GetService(String serviceId) throws Exception {
        EnergyServicesContract EnergyContract = loadContract(PRIVATE_KEY);
        Tuple4<String, String, BigInteger, String> res= EnergyContract.getServiceDetails(serviceId).send();
        System.out.println(res.component1());
        System.out.println(res.component2());
        System.out.println(res.component3());
        System.out.println(res.component4());
        com.energybackend.Entity.Service service = new com.energybackend.Entity.Service();
        service.setServiceId(serviceId);
        service.setStation(res.component1());
        service.setCable(res.component2());
        service.setValue(Long.parseLong(res.component3().toString()));
        service.setBeneficiary(res.component4());
        return service;
    }

    @Override
    public com.energybackend.Entity.Service CreateService(ServiceInput serviceInput) throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserExistDto userExistDto = new UserExistDto();
        userExistDto.setUsername((String) auth.getPrincipal());
        UserResp userResp = accountService.getUser(userExistDto.getUsername());
        EnergyServicesContract energyServicesContract = loadContract(serviceInput.getPrivateKey());
        System.out.println("saving ....."+energyServicesContract.toString());
        com.energybackend.Entity.Service service = new com.energybackend.Entity.Service(null,
                serviceInput.getStation(),serviceInput.getCable(), serviceInput.getValue(), userResp.getAddress(),LocalDate.now());
        System.out.println("saving .....------------------------------");
        com.energybackend.Entity.Service savedService= ServiceRepository.save(service);
        System.out.println("-------------------"+savedService.getServiceId()+"------------------");
        System.out.println("------- add Service to the blockchain ");
        energyServicesContract.BuyService(
                savedService.getServiceId(),
                savedService.getStation(),
                savedService.getCable(),
                BigInteger.valueOf(savedService.getValue()),
                savedService.getBeneficiary()).send();

        String node = "HTTP://127.0.0.1:7545";
        Web3j web3 = Web3j.build(new HttpService(node));
        TransactionManager transactionManager = new RawTransactionManager(
                web3,
                getCredentials(serviceInput.getPrivateKey())
        );

        // 50 USD  = 0.04801090807831539 ETH = 1000 KWH
        double amount  = (serviceInput.getValue()/1000) * 0.04801090807831539;
        Transfer transfer = new Transfer(web3,transactionManager);
        TransactionReceipt transactionReceipt = transfer.sendFunds(
                "0xC54689c6fb6331c58427438eBB94b342FC747724",
                BigDecimal.valueOf(amount),
                Convert.Unit.ETHER,
                GAS_PRICE,
                GAS_LIMIT
        ).send();
        System.out.println("------- Service Added to the blockchain Successfully ");
        return savedService;
    }

    public BigInteger getEthBalance() throws ExecutionException, InterruptedException {
        String node = "HTTP://127.0.0.1:7545";
        Web3j web3 = Web3j.build(new HttpService(node));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserExistDto userExistDto = new UserExistDto();
        userExistDto.setUsername((String) auth.getPrincipal());
        UserResp userResp = accountService.getUser(userExistDto.getUsername());
        EthGetBalance balance = web3
                .ethGetBalance(userResp.getAddress(), DefaultBlockParameterName.LATEST)
                .sendAsync()
                .get();
        return balance.getBalance();
    }

    private Credentials getCredentials(String Privkey){
        BigInteger privkey = new BigInteger(Privkey, 16);
        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
        Credentials credentials = Credentials.create(ecKeyPair);
        return credentials;
    }

    private EnergyServicesContract loadContract(String privateKey) throws Exception {
        String node = "HTTP://127.0.0.1:7545";
        System.out.println("Connecting to Ethereum …");
        Web3j web3 = Web3j.build(new HttpService(node));
        System.out.println("Ethereum connected ");
        Credentials credentials = getCredentials(privateKey);
        EnergyServicesContract contract = EnergyServicesContract.load(CONTRACT_ADDRESS, web3, credentials, GAS_PRICE, GAS_LIMIT);
        LoadedContract.setLoadedContarct1(contract);
        String  address_ = LoadedContract.getLoadedContarct1().getContractAddress();
        log.info("Smart contract deployed to address "+address_ );
        log.info("Creator  address "+ contract.creatorAdmin().send() );
        return contract;
    }
}
