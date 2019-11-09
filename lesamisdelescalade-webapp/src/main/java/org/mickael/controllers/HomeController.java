package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import java.util.List;

@Controller
public class HomeController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;


    @GetMapping("/home")
    public String displayHomePage(Model model, @SessionAttribute(value = "memberInSession", required = false) Member memberInSession){
        //Display all the climbing Area on the homepage
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        System.out.println("member not log");
        //Test if the member is logged
        if(memberInSession != null){
            System.out.println("member log");
            model.addAttribute("memberInSession", memberInSession);
        }
        return "home";
    }
}
