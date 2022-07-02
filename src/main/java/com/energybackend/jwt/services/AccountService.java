package com.energybackend.jwt.services;


import com.energybackend.jwt.dtos.*;
import com.energybackend.jwt.entities.AppRole;
import com.energybackend.jwt.entities.AppUser;

import java.util.ArrayList;


public interface AccountService {
    public AppUser addUser(String username , String password , String comfirmPassword, String address);
    public AppUser addAdmin(ArrayList<AppRole> roles, String username, String password, String comfirmPassword , String address);
    public UserActive getUserActive(String username , String password);
    public AppRole saveRole(AppRole appRole);
    public AppUser loadUserbyUsername(String username);
    public void addRoleToUser(String username,String role);
    public AccountResponse activeAccount(ActiveAccount activeAccount) throws Exception;
    public AccountResponse resetPassword(ResetPassword resetPassword);
    public UserResp getUser(String username);
    UserResp getUserByAddress(String address);
}
