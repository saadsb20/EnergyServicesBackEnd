package com.energybackend.Services;


import Contract.EnergyToken;
import com.energybackend.EnergyBackEndApplication;
import com.energybackend.LoadedContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Service
@Transactional
public class ETServicesImpl implements ETServices{
    private final static String PRIVATE_KEY = "9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private final static String CONTRACT_ADDRESS = "0xba9e5d6638c70d18a49d15033f01687679d2e452";
    private static final Logger log = LoggerFactory.getLogger(EnergyBackEndApplication.class);
    @Override
    public void Transfer(String To, BigInteger Amount) {

    }

    @Override
    public void TransferFrom(String From, String To, BigInteger Amount) {

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
    public BigInteger getTotalSupply() {
        return null;
    }

    @Override
    public String getAdmin() throws Exception {
        EnergyToken energyToken = loadContract("9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25");
        return energyToken.admin().send();
    }

    @Override
    public void Burn() {

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
