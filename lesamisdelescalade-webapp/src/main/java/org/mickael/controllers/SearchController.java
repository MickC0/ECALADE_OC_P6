package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.contract.manager.GuidebookManager;
import org.mickael.business.contract.manager.UtilsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;

@Controller
public class SearchController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @Inject
    private UtilsManager utilsManager;

    @Inject
    private GuidebookManager guidebookManager;


    @GetMapping("/climbingAreaList/results")
    public String showClimbingAreaListSearchResults(Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){


        return "climbingAreaListPage";
    }
}
