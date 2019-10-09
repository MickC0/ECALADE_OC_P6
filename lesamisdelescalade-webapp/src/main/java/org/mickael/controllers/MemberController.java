package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.sql.Timestamp;

@Controller
public class MemberController {

    @Inject
    MemberManager memberManager;


    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(){

        return "/signUp";
    }



    @RequestMapping(value = "/createNewMember", method = RequestMethod.POST)
    public ModelAndView createMember(@RequestParam("firstName") String firstName, @RequestParam ("lastName") String lastName, @RequestParam ("pseudo") String pseudo,
                                     @RequestParam ("birthDate")Timestamp birthDate, @RequestParam ("gender") String gender, @RequestParam ("email") String email,
                                     @RequestParam ("password") String password, @RequestParam("isMember") boolean isMember, ModelAndView modelAndView){
        Member member = new Member();
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setPseudo(pseudo);
        member.setBirthDate(birthDate);
        member.setGender(gender);
        member.setEmail(email);
        member.setPassword(password);
        member.setMember(isMember);

        memberManager.createMember(member);

        modelAndView.setViewName("confirmedRegistration");

        return modelAndView;
    }





    @RequestMapping("/memberList")
    public String getAllMembers(Model model){
        model.addAttribute("members", memberManager.findAllMember());
        return "memberList";
    }
}
