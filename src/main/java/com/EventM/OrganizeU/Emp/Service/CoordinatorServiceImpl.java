package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.Coordinator;
import com.EventM.OrganizeU.Emp.Repository.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinatorServiceImpl implements CoordinatorService{
    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Override
    public List<Coordinator> fetchcoordinator() {
        System.out.println("Service Implemented");
        return coordinatorRepository.findAll();
    }

    @Override
    public Coordinator save(Coordinator user) {
        return coordinatorRepository.save(user);
    }
}
