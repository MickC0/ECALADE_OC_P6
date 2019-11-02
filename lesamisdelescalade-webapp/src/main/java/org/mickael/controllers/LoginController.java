package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.PasswordManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;

@Controller
@SessionAttributes("memberInSession")
public class LoginController {

    @Inject
    private MemberManager memberManager;

    @Inject
    private PasswordManager passwordManager;

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @ModelAttribute("memberInSession")
    public Member setUpMemberForm(){
        return new Member();
    }

    @GetMapping("/doLogin")
    public String showLoginForm(@SessionAttribute(value = "memberInSession", required = false) Member memberInSession){

        return "login";
    }

    @PostMapping("/loginProcess")
    public String doLogin(@ModelAttribute("memberInSession")Member memberInSession, WebRequest webRequest, SessionStatus sessionStatus, Model model){
        //variable
        boolean checkPassword = false;

        //Objet
        Member memberBdd = new Member();
        System.out.println("memberInSession: " + memberInSession.toString());
        System.out.println("memberBdd: " + memberBdd.toString());

        //method for have UserBdd bean with sessionUser email
        if (memberInSession != null) {

            memberBdd = memberManager.findMemberByMail(memberInSession.getEmail());
            System.out.println("memberInSession: " + memberInSession.toString());
            System.out.println("memberBdd: " + memberBdd.toString());

            //Member not recognize on bdd
            if (memberBdd == null) {
                // for fix bug after deleting user (go to error page and clic home (old user is log)
                sessionStatus.setComplete();
                webRequest.removeAttribute("memberInSession", WebRequest.SCOPE_SESSION);
                return "_error/errorLogin";
            }
            //method for check if password is good
            checkPassword = passwordManager.matches(memberInSession.getPassword(), memberBdd.getPassword());
            System.out.println(checkPassword);

            if (checkPassword) {
                model.addAttribute("memberLogged", memberBdd.getEmail());
            } else {
                sessionStatus.setComplete();
                webRequest.removeAttribute("memberInSession", WebRequest.SCOPE_SESSION);
                return "_error/errorLogin";
            }

        }
        //for display climbing site
        model.addAttribute("climbingArea", climbingAreaManager.findAllClimbingArea());
        return "home";
    }

    @GetMapping("/doLogout")
    public String doLogout(WebRequest webRequest, SessionStatus sessionStatus, Model model){
        sessionStatus.setComplete();
        webRequest.removeAttribute("memberInSession", WebRequest.SCOPE_SESSION);

        model.addAttribute("climbingArea", climbingAreaManager.findAllClimbingArea());
        return "home";
    }


}
