package com.energybackend.Services;


import Contract.EnergyToken;
import com.energybackend.EnergyBackEndApplication;
import com.energybackend.LoadedContract;
import com.energybackend.dtos.GiveReward;
import com.energybackend.dtos.TransferET;
import com.energybackend.dtos.TransferETFrom;
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
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
@Transactional
public class ETServicesImpl implements ETServices{
    private final static String PRIVATE_KEY = "9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final static String CONTRACT_ADDRESS = "0xba9e5d6638c70d18a49d15033f01687679d2e452";
    private static final Logger log = LoggerFactory.getLogger(EnergyBackEndApplication.class);

    @Autowired
    AccountService accountService;
    @Autowired
    ServiceServices serviceServices;

    @Override
    public void Transfer(TransferET transferET) throws Exception {
        EnergyToken energyToken = loadContract("9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25");
        //get authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserExistDto userExistDto = new UserExistDto();
        userExistDto.setUsername((String) auth.getPrincipal());
        UserResp userResp = accountService.getUser(userExistDto.getUsername());
        // transfering ET
        energyToken.transfer(userResp.getAddress(),BigInteger.valueOf(transferET.getAmount())).send();
        // transeferring Ether after buying ET
        System.out.println("Transeferring Ether after buying ET");
        String node = "HTTP://127.0.0.1:7545";
        Web3j web3 = Web3j.build(new HttpService(node));
        TransactionManager transactionManager = new RawTransactionManager(
                web3,
                getCredentials(transferET.getPrivateKey())
        );
        // 1 ET = 0.000000012 ETH
        double amount  = transferET.getAmount() * 0.000000012;
        Transfer transfer = new Transfer(web3,transactionManager);
        TransactionReceipt transactionReceipt = transfer.sendFunds(
                "0xC54689c6fb6331c58427438eBB94b342FC747724",
                BigDecimal.valueOf(amount),
                Convert.Unit.ETHER,
                GAS_PRICE,
                GAS_LIMIT
        ).send();
    }

    @Override
    public void GiveReward(GiveReward giveReward) throws Exception {
        EnergyToken energyToken = loadContract("9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25");
        energyToken.transfer(giveReward.getAddress(),BigInteger.valueOf(giveReward.getAmount())).send();
    }


    @Override
    public void TransferFrom(TransferETFrom transferETfrom) {

    }

    @Override
    public String getTokenName() {
        return null;
    }

    @Override
    public String getTokenSymbol() {
        return null;
    }

    @Override
    public BigInteger getTotalSupply() throws Exception {
        EnergyToken energyToken = loadContract(PRIVATE_KEY);
        return energyToken.totalSupply().send();
    }

    @Override
    public BigInteger getBalanceOf() throws Exception {
        EnergyToken energyToken = loadContract("9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserExistDto userExistDto = new UserExistDto();
        userExistDto.setUsername((String) auth.getPrincipal());
        UserResp userResp = accountService.getUser(userExistDto.getUsername());
        BigInteger Balance = energyToken.balanceOf(userResp.getAddress()).send();
        return Balance;
    }

    @Override
    public String getAdmin() throws Exception {
        EnergyToken energyToken = loadContract("9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25");
        return energyToken.admin().send();
    }

    @Override
    public void Burn() {

    }

    @Override
    public void mint() {

    }

    private Credentials getCredentials(String Privkey){
        BigInteger privkey = new BigInteger(Privkey, 16);
        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
        Credentials credentials = Credentials.create(ecKeyPair);
        return credentials;
    }

    private EnergyToken loadContract(String privateKey) throws Exception {
        String node = "HTTP://127.0.0.1:7545";
        System.out.println("Connecting to Ethereum …");
        Web3j web3 = Web3j.build(new HttpService(node));
        System.out.println("Ethereum connected ");
        Credentials credentials = getCredentials(privateKey);
        EnergyToken contract = EnergyToken.load(CONTRACT_ADDRESS, web3, credentials, GAS_PRICE, GAS_LIMIT);
        LoadedContract.setLoadedContarct2(contract);
        String  address_ = LoadedContract.getLoadedContarct2().getContractAddress();
        log.info("Smart contract deployed to address "+address_ );
        return contract;
    }
}
