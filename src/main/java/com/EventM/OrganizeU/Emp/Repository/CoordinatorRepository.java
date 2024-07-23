package com.EventM.OrganizeU.Emp.Repository;

import com.EventM.OrganizeU.Emp.Entity.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator,Long> {
}
