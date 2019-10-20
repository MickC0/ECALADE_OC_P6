package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;

@Controller
public class HomeController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;


    @GetMapping("/home")
    public String displayHomePage(Model model, @SessionAttribute(value = "member", required = false) Member member){
        //Display all the climbing Area on the homepage
        model.addAttribute("climbingArea", climbingAreaManager.findAllClimbingArea());

        //Test if the member is log
        if(member != null){
            model.addAttribute("logMember", member.getId());
        }
        return "home";
    }






}
