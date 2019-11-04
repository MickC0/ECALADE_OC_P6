package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Guidebook;
import org.mickael.model.bean.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.inject.Inject;
import java.util.List;

@Controller
@SessionAttributes("memberInSession")
public class PersonalSpaceController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @Inject
    private GuidebookManager guidebookManager;

    @Inject
    private MemberManager memberManager;

    @Inject
    private PasswordManager passwordManager;

    @Inject
    private ReservationRequestManager reservationRequestManager;

    @GetMapping("/personalSpace")
    public String getPersonalSpace(@SessionAttribute(value = "memberInSession", required = true)Member memberInSession, Model model){
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        List<Guidebook> guidebookList = guidebookManager.findAllGuidebookByMemberId(memberInSession.getId());
        model.addAttribute("climbingAreaList", climbingAreaList);
        model.addAttribute("guidebookList", guidebookList);
        model.addAttribute("memberLogged", memberInSession);
        return "personalSpace";
    }

}