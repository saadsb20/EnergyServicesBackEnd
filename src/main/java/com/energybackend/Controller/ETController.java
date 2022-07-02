package com.energybackend.Controller;


import com.energybackend.Services.ETServices;
import com.energybackend.dtos.TransferET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class ETController {

    @Autowired
    ETServices ETServices;

    @GetMapping("/getAdmin")
    public String getAdmin() throws Exception {
        return ETServices.getAdmin();
    }
    @PostMapping("/transferTo")
    public void transferTo(@RequestBody TransferET transferET) throws Exception {
        System.out.println("amount : " + transferET.getAmount());
        System.out.println("Private Key : " + transferET.getPrivateKey());
         ETServices.Transfer(transferET);
    }
    @GetMapping("/getTotalSupply")
    public BigInteger getTotalSupply() throws Exception {
        return ETServices.getTotalSupply();
    }

    @GetMapping("/accountBalance")
    public BigInteger getBalanceOf() throws Exception {
        return ETServices.getBalanceOf();
    }

}
