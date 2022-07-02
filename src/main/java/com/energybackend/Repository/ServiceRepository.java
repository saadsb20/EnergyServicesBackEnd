package com.energybackend.Repository;

import com.energybackend.Entity.Service;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ServiceRepository extends MongoRepository<Service,String> {
    Service findServiceByServiceId(String id);
    List<Service> findAllByBeneficiary(String beneficiary);
    List<Service> findAllByDate(LocalDate date);
}
