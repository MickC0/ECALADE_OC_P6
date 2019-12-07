package org.mickael.controllers;

import org.mickael.business.contract.manager.GuidebookManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Guidebook;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;

public class GuidebookController {

    @Inject
    private GuidebookManager guidebookManager;

    @Inject
    private MemberManager memberManager;

    @GetMapping("/showGuidebookForm")
    public String showGuidebookForm(@SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        if (memberInSessionId != null){
            model.addAttribute("guidebook", new Guidebook());
            return "guidebookForm";
        } else {
            return "redirect:/doLogin";
        }
    }


}
