package com.EventM.OrganizeU.Emp.Repository;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import com.EventM.OrganizeU.Emp.Entity.UserL;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class UserLRepositoryTest {
    @Mock
    private UserLRepository userl;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Test
    public void savecourse(){
        UserL course = UserL.builder()
                .email("velraj@123")
                .name("nameis")
                .password("123hari")
                .build();
        String rawPassword = course.getPassword();
        String hashedPassword = passwordEncoder().encode(rawPassword);
        course.setPassword(hashedPassword);
        System.out.println(course);
    }

}