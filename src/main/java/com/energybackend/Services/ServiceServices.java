package com.energybackend.Services;

import com.energybackend.Entity.Service;
import com.energybackend.dtos.ServiceInput;

import java.util.List;

public interface ServiceServices {
    public List<Service> MyServices();
    public List<Service> AllServices();
    public Service GetService(String serviceId) throws Exception;
    public Service CreateService(ServiceInput serviceInput) throws Exception;
}
