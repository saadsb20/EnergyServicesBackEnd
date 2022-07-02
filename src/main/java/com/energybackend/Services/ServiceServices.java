package com.energybackend.Services;

import com.energybackend.Entity.Service;
import com.energybackend.dtos.ServiceInput;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ServiceServices {
    public List<Service> MyServices();
    public List<Service> AllServices();
    public List<Service> AllServicesByDate(LocalDate date);
    public Service GetService(String serviceId) throws Exception;
    public Service CreateService(ServiceInput serviceInput) throws Exception;
    public BigInteger getEthBalance() throws ExecutionException, InterruptedException;
}
