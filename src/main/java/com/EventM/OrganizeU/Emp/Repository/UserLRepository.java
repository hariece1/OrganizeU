package com.EventM.OrganizeU.Emp.Repository;

import com.EventM.OrganizeU.Emp.Entity.UserL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLRepository extends JpaRepository<UserL,Long> {

      UserL findByName(String name);
}
