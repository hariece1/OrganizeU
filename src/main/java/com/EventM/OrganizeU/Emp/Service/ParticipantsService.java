package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.Participants;

import java.util.List;
import java.util.Optional;

public interface ParticipantsService {
    public Participants save(Participants user);
    public List<Participants> fetchregistered();

    public void deletepbyid(Long id);

    public Participants updateParticipants(Long id, Participants participants);

    public Participants updateView(Long id);

    public Participants ShowP(Long id);

    public int gettotal();
    public int getpend();
    public int getCompleted();
    public int getintiated();
}
