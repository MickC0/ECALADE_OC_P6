package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Inject
    private PasswordManager passwordManager;

    @Inject
    private MemberManager memberManager;


    @GetMapping("/doRegister")
    public String viewRegistration(@SessionAttribute(value = "memberInSession", required = false) Member memberInSession, Model model){
        model.addAttribute("member", new Member());

        return "registration";
    }

    @PostMapping("/registrationProcess")
    public String saveNewMember(@Valid Member newMember, BindingResult bindingResult, Model model, @SessionAttribute(value = "memberInSession", required = false) Member memberInSession){
        Member existingMember = memberManager.findMemberByMail(newMember.getEmail());

        if (existingMember != null){

            return "_error/errorLogin";
        } else {
            if (bindingResult.hasErrors()) {
                model.addAttribute("member", newMember);
                return "registration";
            }
            //encoder
            String hashPassword = passwordManager.hashPassword(newMember.getPassword());
            newMember.setPassword(hashPassword);
            newMember.setRole("User");
            newMember.setEnabled(true);
            memberManager.createMember(newMember);

            model.addAttribute("message", "Member register successfully.");
            model.addAttribute("member", newMember);

            return "_confirmation/registrationSuccess";
        }
    }

}
