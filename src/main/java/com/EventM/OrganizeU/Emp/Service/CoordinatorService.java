package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.Coordinator;
import com.EventM.OrganizeU.Emp.Entity.Participants;

import java.util.List;

public interface CoordinatorService {
    public List<Coordinator> fetchcoordinator();
    public Coordinator updateView(Long id);
    public Coordinator save(Coordinator user);
}
