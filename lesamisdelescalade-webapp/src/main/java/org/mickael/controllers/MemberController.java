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
import java.util.Optional;

@Controller

public class MemberController {

    @Inject
    private MemberManager memberManager;

    @Inject
    private PasswordManager passwordManager;


    @GetMapping("/signUp")
    public String viewSignUp(Model model, @SessionAttribute(value = "member", required = false) Member memberSession){
        model.addAttribute("member", new Member());
        return "signUpForm";
    }


    @PostMapping(value = "/signUpTry")
    public String createMember(@Valid Member newMember, BindingResult result, Model model,
                               @SessionAttribute(value = "member", required = false) Member memberSession) {

        Optional<Member> existingMember = memberManager.testOptional(newMember.getEmail());
        //model.addAttribute("member", existingMember);
        if (existingMember.isPresent()){
        //if (existingMember != null){

            return "errorAlreadyExist";
        } else {
            if (result.hasErrors()){
                model.addAttribute("member", newMember);

                return  "signUpForm";
            }
            //encoder
            String hashPassword = passwordManager.hashPassword(newMember.getPassword());
            newMember.setPassword(hashPassword);
            newMember.setAdmin(false);
            newMember.setMember(false);
            memberManager.createMember(newMember);

            model.addAttribute("message", "Member sign up successfully.");
            model.addAttribute("member", newMember);

            return "confirmedRegistration";
        }
    }


    @GetMapping(value = "/logIn")
    public String viewLogin(Model model){

        return "loginForm";
    }


    @PostMapping(value = "/logInTry")
    public String loginMember(@Valid Member member, BindingResult result, Model model){

        return "memberLog";
    }





    @GetMapping("/memberList")
    public String getAllMembers(Model model){
        model.addAttribute("members", memberManager.findAllMember());
        return "memberList";
    }
}
