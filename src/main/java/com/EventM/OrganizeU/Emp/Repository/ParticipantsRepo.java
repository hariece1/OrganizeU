package com.EventM.OrganizeU.Emp.Repository;

import com.EventM.OrganizeU.Emp.Entity.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantsRepo extends JpaRepository<Participants,Long> {
}
