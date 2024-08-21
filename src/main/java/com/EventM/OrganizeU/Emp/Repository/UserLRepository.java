package com.EventM.OrganizeU.Emp.Repository;

import com.EventM.OrganizeU.Emp.Entity.UserL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLRepository extends JpaRepository<UserL,Long> {
    @Query("SELECT u FROM UserL u WHERE u.email = ?1")
    UserL findByEmail(String email);
}
