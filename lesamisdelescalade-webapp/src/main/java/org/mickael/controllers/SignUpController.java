package org.mickael.controllers;


import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class SignUpController {

    @Inject
    MemberManager memberManager;

    @Inject
    PasswordManager passwordManager;


    @ModelAttribute("member")
    public Member setNewMember(){
        return new Member();
    }


    @GetMapping("/showSignUpForm")
    public String showForm(Model model, @ModelAttribute("member") Member member, @SessionAttribute(value = "memberSession", required = false) Member memberSession){
        model.addAttribute("member", member);
        return "signup-form";
    }

    @PostMapping("/saveSignUpForm")
    public String saveMember(@Valid Member newMember, BindingResult bindingResult, Model model, @SessionAttribute(value = "memberSession", required = false) Member memberSession){

        Member existingMember = memberManager.findMemberByMail(newMember.getEmail());

        if (existingMember != null){

            return "error-already-exist";
        } else {
            if (bindingResult.hasErrors()){
                model.addAttribute("member", newMember);
                return  "signup-form";
            }
            //encoder
            String hashPassword = passwordManager.hashPassword(newMember.getPassword());
            newMember.setPassword(hashPassword);
            newMember.setAdmin(false);
            newMember.setMember(false);
            memberManager.createMember(newMember);

            System.out.println("FirstName : " + newMember.getFirstName());
            System.out.println("LastName : " + newMember.getLastName());
            System.out.println("Username : " + newMember.getPseudo());
            System.out.println("Email : " + newMember.getEmail());

            model.addAttribute("message", "Member sign up successfully.");
            model.addAttribute("member", newMember);

            return "signup-success";
        }
    }
}
