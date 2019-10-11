package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;

@Controller
public class HomeController {

    @Inject
    MemberManager memberManager;


    @GetMapping("/home")
    public String displayHomePage(Model model, @SessionAttribute(value = "member", required = false) Member memberSession){
        return "home";
    }

    /**@GetMapping("/signUp")
    public String viewSignUp(Model model, @SessionAttribute(value = "member", required = false) Member memberSession){
        model.addAttribute("member", new Member());
        return "signUpForm";
    }*/




}
