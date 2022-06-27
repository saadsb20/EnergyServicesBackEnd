package com.energybackend.jwt.security;


import com.energybackend.jwt.entities.AppUser;
import com.energybackend.jwt.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    //how we can get the user (when and validation)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser appUser=accountService.loadUserbyUsername(username);
      if(appUser==null) throw new UsernameNotFoundException("invalid user!");
      if(appUser.getActived()==0) throw new UsernameNotFoundException("account not activated!!!");
        Collection<GrantedAuthority>    authorities = new ArrayList<>();
        appUser.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
}
