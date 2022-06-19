package com.energybackend.Repository;

import com.energybackend.Entity.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface ServiceRepository extends MongoRepository<Service,String> {
    Service findServiceByServiceId(String id);
    List<Service> findAllByBeneficiary(String address);
}
