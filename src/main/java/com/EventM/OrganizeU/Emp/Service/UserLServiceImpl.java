package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.UserL;
import com.EventM.OrganizeU.Emp.Repository.UserLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLServiceImpl implements UserLServiceL{

    @Autowired
    private UserLRepository userlrepo;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    public UserL save(UserL user) {
        String rawPassword = user.getPassword();
//        String hashedPassword = passwordEncoder().encode(rawPassword);
        user.setPassword(rawPassword);
        return userlrepo.save(user);
    }
}
