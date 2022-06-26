package com.energybackend.jwt.web;

import com.energybackend.jwt.dtos.*;
import com.energybackend.jwt.entities.AppUser;
import com.energybackend.jwt.security.MailService;
import com.energybackend.jwt.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private MailService mailService;

    public UserController(AccountService accountService ,MailService mailService) {
        this.mailService=mailService;
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
        return accountService.addUser(
                userForm.getUsername(),
                userForm.getPassword(),
                userForm.getConfirmedPassword(),
                userForm.getAddress());
    }

    @PostMapping("/active")
    public UserActive getActiveUser(@RequestBody LoginReq loginReq){
        return accountService.getUserActive(loginReq.getUsername(),loginReq.getPassword());
    }
    @PostMapping("/actived")
    public AccountResponse activeAccount(@RequestBody ActiveAccount activeAccount){
        System.out.println("...................."+activeAccount.getCode()+ activeAccount.getUsername());
        return accountService.activeAccount(activeAccount);
    }
    @PostMapping("/checkEmail")
    public AccountResponse checkEmail(@RequestBody ResetPassword resetPassword){
        return accountService.resetPassword(resetPassword);
    }

    @PostMapping("/getUser")
    public UserResp getUser(@RequestBody UserExistDto userExistDto){
        return accountService.getUser(userExistDto.getUsername());
    }

    @PostMapping("/getUserByAddress")
    public UserResp getUser(@RequestBody UserByAddressDto userByAddressDto){
        return accountService.getUserByAddress(userByAddressDto.getAddress());
    }

}

