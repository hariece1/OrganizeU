package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.UserL;
import com.EventM.OrganizeU.Emp.Repository.UserLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserAseriveD implements UserDetailsService {

    @Autowired
    private UserLRepository userrepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserL user = userrepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserAservice(user);
    }
}
