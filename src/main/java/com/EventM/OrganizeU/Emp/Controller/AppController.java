package com.EventM.OrganizeU.Emp.Controller;

import com.EventM.OrganizeU.Emp.Entity.Coordinator;
import com.EventM.OrganizeU.Emp.Entity.Participants;
import com.EventM.OrganizeU.Emp.Service.CoordinatorService;
import com.EventM.OrganizeU.Emp.Service.ParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private ParticipantsService participantsService;

    @GetMapping("/dashboard")
    public String home(Model model) {
        List<Participants> participants = participantsService.fetchregistered();
        model.addAttribute("participants",participants);
        return "index";
    }


    @GetMapping("/Coordinators")
    public String fetchcoordinator(Model model){
        List<Coordinator> coordinators = coordinatorService.fetchcoordinator();
        model.addAttribute("coordinators", coordinators);
        return "Coordinators";
    }
    @GetMapping("/paymentpaid")
    public String PaymentPaid(Model model){
        List<Participants> participants = participantsService.fetchregistered();
        model.addAttribute("participants",participants);
        return "PaymentPaid.html";
    }

    @GetMapping("/Registered")
    public String fetchregistered(Model model){
        List<Participants> participants = participantsService.fetchregistered();
        model.addAttribute("participants",participants);
        return "Registered";
    }

    @GetMapping("/sendmail")
    public String Sendmail(){
        return "Sendmail.html";
    }

    @GetMapping("/workassign")
    public String Workassign(Model model){
        List<Coordinator> coordinators = coordinatorService.fetchcoordinator();
        model.addAttribute("coordinators", coordinators);
        return "WorkAssignment.html";
    }

    @GetMapping("/createp")
    public String CreateParticipants(Model model){
        model.addAttribute("user", new Participants());
        return "CreateP";
    }
    @PostMapping("/saveuser")
    public String saveUser(@ModelAttribute("user") Participants user) {
        System.out.println("Send to service");
        participantsService.save(user);
        return "redirect:/Registered";
    }
    @GetMapping("/createo")
    public String CreateCoordinator(Model model){
        model.addAttribute("user", new Coordinator());
        return "CreateO";
    }
    @PostMapping("/saveusero")
    public String saveUserO(@ModelAttribute("user") Coordinator user) {
        System.out.println("Send to service");
        coordinatorService.save(user);
        return "redirect:/Coordinators";
    }
    @GetMapping("/delete/participants/{id}")
    public String deletepbyid(@PathVariable("id") Long id){
        System.out.println(id);
        participantsService.deletepbyid(id);
        return "redirect:/Registered";
    }

    @GetMapping("/show/participants/{id}")
    public String ShowP(@PathVariable("id") Long id,Model model){
        Participants participant1 = participantsService.ShowP(id);
        System.out.println(participant1);
        model.addAttribute("participant1",participant1);
        return "ShowP";
    }

    @GetMapping("/updateview/participants/{id}")
    public String updateView(@PathVariable("id") Long id,Model model){
        Participants updatepart = participantsService.updateView(id);
        model.addAttribute("updatepart",updatepart);
        return "EditP";
    }

    @PutMapping("/update/participants{id}")
    public Participants updateParticipants(@PathVariable("id") Long id,@RequestBody Participants participants){
        return participantsService.updateParticipants(id,participants);
    }

}
