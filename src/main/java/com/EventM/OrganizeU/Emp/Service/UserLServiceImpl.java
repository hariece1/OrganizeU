package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.UserL;
import com.EventM.OrganizeU.Emp.Repository.UserLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLServiceImpl implements UserLServiceL{

    @Autowired
    private UserLRepository userlrepo;

    @Override
    public UserL save(UserL user) {
        return userlrepo.save(user);
    }
}
