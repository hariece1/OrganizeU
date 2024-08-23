package com.EventM.OrganizeU.Emp.Controller;

import com.EventM.OrganizeU.Emp.Entity.Coordinator;
import com.EventM.OrganizeU.Emp.Entity.Participants;
import com.EventM.OrganizeU.Emp.Entity.UserL;
import com.EventM.OrganizeU.Emp.Service.CoordinatorService;
import com.EventM.OrganizeU.Emp.Service.ParticipantsService;
import com.EventM.OrganizeU.Emp.Service.UserLServiceL;
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
    @Autowired
    private UserLServiceL userl;

    @GetMapping("/")
    public String homme(Model model) {
        List<Participants> participants = participantsService.fetchregistered();
     //   System.out.println(participants);
        int totalpart = participantsService.gettotal();
        int totalpend = participantsService.getpend();
        int totalcomp = participantsService.getCompleted();
        int totalinit = participantsService.getintiated();
//        System.out.println(totalpart);
        model.addAttribute("totalpart",totalpart);
        model.addAttribute("totalpend",totalpend);
        model.addAttribute("totalcomp",totalcomp);
        model.addAttribute("totalinit",totalinit);
        model.addAttribute("participants",participants);
        return "index";
    }
    @GetMapping("/dashboard")
    public String home(Model model) {
        List<Participants> participants = participantsService.fetchregistered();
        int totalpart = participantsService.gettotal();
        int totalpend = participantsService.getpend();
        int totalcomp = participantsService.getCompleted();
        int totalinit = participantsService.getintiated();
        System.out.println(totalpart);
        model.addAttribute("totalpart",totalpart);
        model.addAttribute("totalpend",totalpend);
        model.addAttribute("totalcomp",totalcomp);
        model.addAttribute("totalinit",totalinit);
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
      //  System.out.println(participant1);
        model.addAttribute("participant1",participant1);
        return "ShowP";
    }

    @GetMapping("/update/participants/{id}")
    public String updateView(@PathVariable("id") Long id,Model model){
        Participants updatepart = participantsService.updateView(id);
      //  System.out.println(updatepart);
        model.addAttribute("updatepart",updatepart);
        return "EditP";
    }

    @GetMapping("/update/coordinator/{id}")
    public String updateViewC(@PathVariable("id") Long id,Model model){
        Coordinator updatepart = coordinatorService.updateView(id);
        System.out.println(updatepart);
        model.addAttribute("updatepart",updatepart);
        return "EditO";
    }

    @PostMapping("/updatepart/{id}")
    public String updateParticipants(@PathVariable("id") Long id,@ModelAttribute("updatepart") Participants user){
//        System.out.println("I AM HERE");
        System.out.println(user.getName());
        participantsService.updateParticipants(id,user);
        return "redirect:/Registered";
    }

    @GetMapping("/login")
    public String logins(){
//        model.addAttribute("ldetail",new UserL());
        return "/login";
    }
    @PostMapping("/checkc")
    public String saveUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        System.out.println("here" + password);
        return "password";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new UserL());
        return "signup";
    }

    @PostMapping("/saveuserl")
    public String saveUserL(@ModelAttribute("user") UserL user) {
        System.out.println(user);
        userl.save(user);
        return "redirect:/login";
    }



}
