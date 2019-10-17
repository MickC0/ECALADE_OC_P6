package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@SessionAttributes("member")
public class MemberController {

    @Inject
    private MemberManager memberManager;

    @Inject
    private PasswordManager passwordManager;

    @ModelAttribute("member")
    public Member setUpMember(){
        return new Member();
    }


    @GetMapping("/signUp")
    public String viewSignUp(Model model, @SessionAttribute(value = "member", required = false) Member memberSession){
        model.addAttribute("member", new Member());
        return "signUpForm";
    }


    @PostMapping(value = "/signUpTry")
    public String createMember(@Valid Member newMember, BindingResult result, Model model,
                               @SessionAttribute(value = "member", required = false) Member memberSession) {

        Member existingMember = memberManager.findMemberByMail(newMember.getEmail());
        if (existingMember != null){

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
        model.addAttribute("member", new Member());
        return "loginForm";
    }


    @PostMapping(value = "/logInTry")
    public String loginMember(@ModelAttribute("member") Member memberSession,  WebRequest webRequest, SessionStatus sessionStatus, Model model){
        boolean checkPassword = false;
        Member memberInBdd = new Member();

        if (memberSession != null){
            memberInBdd = memberManager.findMemberByMail(memberSession.getEmail());
            if (memberInBdd == null){
                sessionStatus.setComplete();
                webRequest.removeAttribute("member", WebRequest.SCOPE_SESSION);
                return "errorAlreadyExist";
            }

            checkPassword = passwordManager.matches(memberSession.getPassword(), memberInBdd.getPassword());

            if (checkPassword){
                model.addAttribute("logged", memberSession.getEmail());
            } else {
                sessionStatus.setComplete();
                webRequest.removeAttribute("member", WebRequest.SCOPE_SESSION);
                return "errorAlreadyExist";
            }
        }
        return "home";
    }


    @GetMapping("/memberList")
    public String getAllMembers(Model model){
        model.addAttribute("members", memberManager.findAllMember());
        return "memberList";
    }
}
