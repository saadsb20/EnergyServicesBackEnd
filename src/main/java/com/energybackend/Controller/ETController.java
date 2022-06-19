package com.energybackend.Controller;

import com.energybackend.Entity.Service;
import com.energybackend.Services.ETServices;
import com.energybackend.Services.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ETController {

    @Autowired
    ETServices ETServices;


    @GetMapping("/getAdmin")
    public String getAdmin() throws Exception {
        return ETServices.getAdmin();
    }
}
