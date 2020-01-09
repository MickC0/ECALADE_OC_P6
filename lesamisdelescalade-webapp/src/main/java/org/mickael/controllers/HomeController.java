package org.mickael.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.contract.manager.PhotoManager;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @Inject
    private PhotoManager photoManager;


    @GetMapping({"/showHome", "/"})
    public String displayHomePage(Model model , @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, HttpSession httpSession){
        //Display all the climbing Area on the homepage
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        //Test if the member is logged
        if(memberInSessionId == null){
            httpSession.invalidate();
        }
        return "home";
    }
}
