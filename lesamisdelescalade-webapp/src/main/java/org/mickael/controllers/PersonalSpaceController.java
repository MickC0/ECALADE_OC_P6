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

    @GetMapping("/editMember/{id}")
    public String showMemberUpdateForm(@PathVariable("id") Integer id, Model model, @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if(memberInSessionId != null && memberInSessionId == id){
            Member memberInBdd = memberManager.findMember(id);
            model.addAttribute("memberEdit", memberInBdd);
            return "userForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/editMember/updateMember/{id}")
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
                return "userForm";
            } else {
                String hashPassword = passwordManager.hashPassword(member.getPassword());
                member.setPassword(hashPassword);
                memberManager.updateMember(member);
                System.out.println("etape 3 " + member);
                return "redirect:/personalSpace";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

}
