package com.EventM.OrganizeU.Emp.Repository;

import com.EventM.OrganizeU.Emp.Entity.Participants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ParticipantsRepo extends JpaRepository<Participants,Long> {
    @Query(
            value = "SELECT COUNT(*) FROM participants;",
            nativeQuery = true
    )
    int gettotalpart();
    @Query(
            value = "SELECT COUNT(*) FROM participants WHERE status = 1",
            nativeQuery = true
    )
    int getpending();
    @Query(
            value = "SELECT COUNT(*) FROM participants WHERE status = 2",
            nativeQuery = true
    )
    int getcompleted();
    @Query(
            value = "SELECT COUNT(*) FROM participants WHERE status = 3",
            nativeQuery = true
    )
    int getintiated();

}
