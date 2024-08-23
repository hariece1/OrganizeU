package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.UserL;
import com.EventM.OrganizeU.Emp.Repository.UserLRepository;
import com.EventM.OrganizeU.Emp.Websecurity.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLServiceImpl implements UserLServiceL{


    @Autowired
    private UserLRepository userlrepo;
//


    @Override
    public UserL save(UserL user) {
        String rawPassword = user.getPassword();
        BCryptPasswordEncoder Pass = new BCryptPasswordEncoder();
        String hashedPassword = Pass.encode(rawPassword);
        user.setPassword(hashedPassword);
        return userlrepo.save(user);
    }
}
