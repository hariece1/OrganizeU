package com.EventM.OrganizeU.Emp.Service;

import com.EventM.OrganizeU.Emp.Entity.Participants;
import com.EventM.OrganizeU.Emp.Repository.ParticipantsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantsServiceImpl implements ParticipantsService{
    @Autowired
    private ParticipantsRepo participantsRepo;

    @Override
    public List<Participants> fetchregistered() {
        return participantsRepo.findAll();
    }

    @Override
    public void deletepbyid(Long id) {
        participantsRepo.deleteById(id);
    }

    @Override
    public Participants updateParticipants(Long id, Participants participants) {
//        ArrayList<Long> list = new ArrayList<>();
//        list.add(id);
        Participants participant = participantsRepo.findById(id).get();
        participant.setStatus(participants.getStatus());
        participant.setCollege(participants.getCollege());
        participant.setEmail(participants.getEmail());
        participant.setName(participants.getName());
        participant.setMobile(participants.getMobile());
        participant.setEventno(participants.getEventno());
        return participantsRepo.save(participants);
    }

    @Override
    public Participants updateView(Long id) {
        Participants updatepart = participantsRepo.findById(id).get();
        return updatepart;
    }

    @Override
    public Participants ShowP(Long id) {
        return participantsRepo.getReferenceById(id);
    }

    @Override
    public int gettotal() {
        int total = participantsRepo.gettotalpart();
        return total;
    }

    @Override
    public int getpend() {
        int total = participantsRepo.getpending();
        return total;
    }

    @Override
    public int getCompleted() {
        int total = participantsRepo.getcompleted();
        return total;
    }

    @Override
    public int getintiated() {
        int total = participantsRepo.getintiated();
        return total;
    }

    public Participants save(Participants user){
        System.out.println("GOt at service");
        System.out.println(user.toString());
        return participantsRepo.save(user);
    }
}
