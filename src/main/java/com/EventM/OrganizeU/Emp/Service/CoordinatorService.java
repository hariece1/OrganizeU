package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.Coordinator;

import java.util.List;

public interface CoordinatorService {
    public List<Coordinator> fetchcoordinator();

    public Coordinator save(Coordinator user);
}
