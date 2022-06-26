package com.energybackend.jwt.repositories;

import com.energybackend.jwt.entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AppUserRepository extends MongoRepository<AppUser,String> {
    public AppUser findAppUserByUsername(String username);
    public AppUser findAppUserByAddress(String address);
    public boolean existsAppUserByUsername(String username);



//    @Query("select u.code from Code u where AppUser.username=?1")
//    public int getActive(String email);
////
////    @Query("select u.password from AppUser u where AppUser.username=?1")
////    public String getPassword(String username);
}
