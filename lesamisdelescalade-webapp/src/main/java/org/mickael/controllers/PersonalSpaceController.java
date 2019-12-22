package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Guidebook;
import org.mickael.model.bean.Member;
import org.mickael.model.bean.ReservationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
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

    @GetMapping("/personalSpace/{memberInSessionId}")
    public String getPersonalSpace(@PathVariable@SessionAttribute("memberInSessionId")Integer memberInSessionId, Model model){
        if (memberInSessionId == null){
            return "redirect:/home";
        }

        //show all the climbing area's owner
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findClimbingAreaByMemberId(memberInSessionId);
        //show all the guidebook's owner
        List<Guidebook> guidebookList = guidebookManager.findAllGuidebookByMemberId(memberInSessionId);
        for (Guidebook guidebook : guidebookList){
            System.out.println(guidebook.toString());
        }
        //show all renting demands for guidebooks owner
//        List<ReservationRequest> guideReservationRequestList = new ArrayList<>();
//        for (Guidebook guidebook : guidebookList){
//            guideReservationRequestList.add(reservationRequestManager.findReservationRequestByGuidebookId(guidebook.getId()));
//        }
        //show all the reservation request's owner
        List<ReservationRequest> memberReservationRequestList = reservationRequestManager.findAllReservationRequestByMemberId(memberInSessionId);
        for (ReservationRequest guidebook : memberReservationRequestList){
            System.out.println(guidebook.toString());
        }
        Member memberInSession = memberManager.findMember(memberInSessionId);

        model.addAttribute("climbingAreaList", climbingAreaList);
        model.addAttribute("guidebookList", guidebookList);
        model.addAttribute("memberReservationRequestList", memberReservationRequestList);
        //model.addAttribute("guideReservationRequestList", guideReservationRequestList);
        model.addAttribute("memberInSessionId", memberInSessionId);
        model.addAttribute("memberInSession", memberInSession);
        return "personalSpace";
    }

    @GetMapping("/editMember/{id}")
    public String showMemberUpdateForm(@PathVariable("id") Integer id, Model model, @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if(memberInSessionId != null && memberInSessionId == id){
            Member memberInBdd = memberManager.findMember(id);
            model.addAttribute("memberEdit", memberInBdd);
            return "updateMemberForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/editMember/updateMemberProcess/{id}")
    public String updateMember(@Valid Member member, @PathVariable("id") Integer id, Model model, @SessionAttribute("memberInSessionId") Integer memberInSessionId,
                               BindingResult bindingResult){
        if(memberInSessionId != null && memberInSessionId == id){
            if (bindingResult.hasErrors()){
                System.out.println("erreur binding");
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors ) {
                    System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
                }
                String str = "Une erreur est survenue. Vérifiez les champs.";
                model.addAttribute("memberToEdit", member);
                model.addAttribute("errorMessage", str);
                return "updateMemberForm";
            } else {
                String hashPassword = passwordManager.hashPassword(member.getPassword());
                member.setPassword(hashPassword);
                memberManager.updateMember(member);
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "redirect:/personalSpace/{memberInSessionId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

}
