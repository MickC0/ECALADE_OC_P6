package org.mickael.controllers;

import org.mickael.business.contract.manager.GuidebookManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.business.contract.manager.ReservationRequestManager;
import org.mickael.model.bean.Guidebook;
import org.mickael.model.bean.ReservationRequest;
import org.mickael.model.enumeration.ReservationState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
public class ReservationController {

    @Inject
    private GuidebookManager guidebookManager;

    @Inject
    private MemberManager memberManager;

    @Inject
    private ReservationRequestManager reservationRequestManager;

    @GetMapping("/showReservationForm/{id}")
    public String showReservationForm(@PathVariable Integer id, @SessionAttribute("memberInSessionId")Integer memberInSessionId, Model model){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        }
        ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestByMemberAndGuidebookId(memberInSessionId, id);
        String reservationInBddStatus = new String();
        if (reservationRequestInBdd != null){
            reservationInBddStatus = reservationRequestInBdd.getStatus();

        } else {
            reservationInBddStatus = "null";
        }

        model.addAttribute("reservationInBddStatus", reservationInBddStatus);
        model.addAttribute("guidebookId", id);
        model.addAttribute("memberInSessionId", memberInSessionId);
        model.addAttribute("reservationRequest", new ReservationRequest());
        return "reservationRequestForm";
    }

    @PostMapping("/showReservationForm/saveReservationProcess/{id}")
    public String saveReservation(@Valid @ModelAttribute("reservationRequest")ReservationRequest newReservationRequest,
                                  @PathVariable Integer id, BindingResult bindingResult, Model model,
                                  @SessionAttribute("memberInSessionId")Integer memberInSessionId){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        } else {
            if (bindingResult.hasErrors()){
                model.addAttribute("guidebookId", id);
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "reservationRequestForm";
            } else {
                newReservationRequest.setGuidebook(guidebookManager.findGuidebook(id));
                newReservationRequest.setMember(memberManager.findMember(memberInSessionId));
                newReservationRequest.setStatus(ReservationState.PENDING.getStateValue());
                reservationRequestManager.createReservationRequest(newReservationRequest);
                return "redirect:/guidebookList";
            }
        }
    }

    @GetMapping("/cancelReservationRequest/{id}")
    public String cancelReservationRequest(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestById(id);
            reservationRequestInBdd.setStatus(ReservationState.CANCELLED.getStateValue());
            Guidebook guidebookToRent = reservationRequestInBdd.getGuidebook();
            guidebookToRent.setLoaned(false);
            reservationRequestManager.updateReservationRequest(reservationRequestInBdd);
            guidebookManager.updateGuidebook(guidebookToRent);

            model.addAttribute("memberInSessionId", memberInSessionId);


            return "redirect:/personalSpace/{memberInSessionId}";
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/deleteReservationRequest/{id}")
    public String deleteReservationRequest(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            model.addAttribute("memberInSessionId", memberInSessionId);
            reservationRequestManager.deleteReservationRequest(id);
            return "redirect:/personalSpace/{memberInSessionId}";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/acceptReservationRequest/{id}")
    public String acceptReservationRequest(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestById(id);
            reservationRequestInBdd.setStatus(ReservationState.ACCEPTED.getStateValue());
            Guidebook guidebookToRent = reservationRequestInBdd.getGuidebook();
            guidebookToRent.setLoaned(true);
            reservationRequestManager.updateReservationRequest(reservationRequestInBdd);
            guidebookManager.updateGuidebook(guidebookToRent);

            model.addAttribute("memberInSessionId", memberInSessionId);


            return "redirect:/personalSpace/{memberInSessionId}";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/refuseReservationRequest/{id}")
    public String refuseReservationRequest(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestById(id);
            reservationRequestInBdd.setStatus(ReservationState.REFUSED.getStateValue());
            reservationRequestManager.updateReservationRequest(reservationRequestInBdd);

            model.addAttribute("memberInSessionId", memberInSessionId);

            String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();

            System.out.println(uri);
            return "redirect:/personalSpace/{memberInSessionId}";
        } else {
            return "redirect:/doLogin";
        }
    }
    @PostMapping("/closeReservationRequest/{id}")
    public String closeReservationRequest(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestById(id);
            reservationRequestInBdd.setStatus(ReservationState.CLOSED.getStateValue());
            Guidebook guidebookToRent = reservationRequestInBdd.getGuidebook();
            guidebookToRent.setLoaned(false);
            reservationRequestManager.updateReservationRequest(reservationRequestInBdd);
            guidebookManager.updateGuidebook(guidebookToRent);
            model.addAttribute("memberInSessionId", memberInSessionId);
            return "redirect:/personalSpace/{memberInSessionId}";
        } else {
            return "redirect:/doLogin";
        }
    }

}
