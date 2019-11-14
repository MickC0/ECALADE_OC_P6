package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Guidebook;
import org.mickael.model.bean.ReservationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.inject.Inject;
import java.util.List;

@Controller
@SessionAttributes("memberInSessionId")
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
    public String getPersonalSpace(@SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId, Model model){
        if (memberInSessionId == null){
            return "redirect:/home";
        }
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findClimbingAreaByMemberId(memberInSessionId);
        List<Guidebook> guidebookList = guidebookManager.findAllGuidebookByMemberId(memberInSessionId);
        List<ReservationRequest> reservationRequestList = reservationRequestManager.findAllReservationRequestByMemberId(memberInSessionId);
        model.addAttribute("climbingAreaList", climbingAreaList);
        model.addAttribute("guidebookList", guidebookList);
        model.addAttribute("reservationRequestList", reservationRequestList);
        //model.addAttribute("memberInSession", memberInSession);
        return "personalSpace";
    }

}
