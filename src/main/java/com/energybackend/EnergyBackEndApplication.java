package com.energybackend;

import Contract.EnergyToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@SpringBootApplication
public class EnergyBackEndApplication {

    private final static String PRIVATE_KEY = "9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    //private final static String CONTRACT_ADDRESS = "0xe4092726cad5e6c26d56354fb4ec8eba44b4cc9d";

    public static void main(String[] args) {
        SpringApplication.run(EnergyBackEndApplication.class, args);
    }


    public EnergyBackEndApplication() throws Exception {
//        String node = "HTTP://127.0.0.1:7545";
//        System.out.println("Connecting to Ethereum …");
//        Web3j web3 = Web3j.build(new HttpService(node));
//        System.out.println("Ethereum connected ");
//        // String privatekey = "";
//        BigInteger privkey = new BigInteger(PRIVATE_KEY, 16);
//        ECKeyPair ecKeyPair = ECKeyPair.create(privkey);
//        Credentials credentials = Credentials.create(ecKeyPair);
//
//        EnergyToken contract = EnergyToken.deploy(web3, credentials, GAS_PRICE, GAS_LIMIT).send();
//
////        ImmobillierContract contract = loadContract(CONTRACT_ADDRESS,web3,credentials);
////        LoadedContarct.setLoadedContarct(contract);
////       String  address2_ = LoadedContarct.getLoadedContarct().getContractAddress();
//
//         System.out.println("Smart contract deployed to address "+ contract.getContractAddress());
//

    }
}
