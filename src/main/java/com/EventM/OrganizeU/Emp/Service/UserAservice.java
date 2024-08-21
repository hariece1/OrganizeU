package com.EventM.OrganizeU.Emp.Service;


import com.EventM.OrganizeU.Emp.Entity.UserL;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserAservice implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    private UserL user;

    public UserAservice(UserL user) {
        this.user = user;
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getPassword();
    }
}
