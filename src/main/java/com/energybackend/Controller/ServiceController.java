package com.energybackend.Controller;

import com.energybackend.Entity.Service;
import com.energybackend.Services.ServiceServices;
import com.energybackend.dtos.ServiceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class ServiceController {

    @Autowired
    ServiceServices ServiceServices;

    @PostMapping("/addService")
    public Service addService(@RequestBody ServiceInput serviceInput) throws Exception {
        return ServiceServices.CreateService(serviceInput);
    }
    @GetMapping("/allServices")
    public List<Service> allServices() throws Exception {
        return ServiceServices.AllServices();
    }
    @GetMapping("/getService/{s}")
    public Service getService(@PathVariable String s) throws Exception {
        return ServiceServices.GetService(s);
    }

    @GetMapping("/getServiceByDate")
    public List<Service> getServiceByDate(){
        return ServiceServices.AllServicesByDate(LocalDate.now());
    }

    @GetMapping("/getEthBalance")
    public BigInteger getEthBalance() throws ExecutionException, InterruptedException {
        BigInteger value = Convert.fromWei(ServiceServices.getEthBalance().toString(), Convert.Unit.ETHER).toBigInteger();
        return value;
    }
    @GetMapping("/getWeiBalance")
    public BigInteger getWeiBalance() throws ExecutionException, InterruptedException {
        return ServiceServices.getEthBalance();
    }

    @GetMapping("/myServices")
    public List<Service> myServices(){
        return ServiceServices.MyServices();
    }



    }
