package com.energybackend.Controller;

import com.energybackend.Entity.Service;
import com.energybackend.Services.ServiceServices;
import com.energybackend.dtos.ServiceInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
