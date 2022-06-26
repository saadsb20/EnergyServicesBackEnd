package com.energybackend;

import com.energybackend.jwt.entities.AppRole;
import com.energybackend.jwt.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigInteger;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAsync
public class EnergyBackEndApplication {

    private final static String PRIVATE_KEY = "9524238a6036506951bb659a3479f4765730027852f55f79bdb63a94b8d49b25";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    //private final static String CONTRACT_ADDRESS = "0xe4092726cad5e6c26d56354fb4ec8eba44b4cc9d";

    public static void main(String[] args) {
        SpringApplication.run(EnergyBackEndApplication.class, args);
    }


//    public EnergyBackEndApplication() throws Exception {
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
//
//         System.out.println("Smart contract deployed to address "+ contract.getContractAddress());
//
//
//    }
        @Bean
        public BCryptPasswordEncoder bCryptPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

//     @Bean
//     CommandLineRunner start(AccountService accountService){
//        return args -> {
//            accountService.saveRole(new AppRole(null,"USER"));
//            accountService.saveRole(new AppRole(null,"ADMIN"));
//            Stream.of("admin@gmail.com").forEach(un->{
//                accountService.addUser(un,"Admin123456","Admin123456","0xC54689c6fb6331c58427438eBB94b342FC747724");
//            });
//           accountService.addRoleToUser("admin@gmail.com","ADMIN");
//
//        };
//    }
}
