package com.energybackend.jwt.repositories;

import com.energybackend.jwt.entities.AppRole;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AppRoleRepository extends MongoRepository<AppRole,String> {
    public AppRole findByRoleName(String roleName);
}
