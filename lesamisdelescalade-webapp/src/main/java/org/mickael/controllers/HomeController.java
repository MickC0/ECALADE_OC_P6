package org.mickael.controllers;

import org.mickael.business.contract.manager.MemberManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class HomeController {

    @Inject
    MemberManager memberManager;

    @RequestMapping("/home")
    public String displayHomePage(){
        return "home";
    }
}
