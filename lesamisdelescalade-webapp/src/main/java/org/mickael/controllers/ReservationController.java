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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

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
        model.addAttribute("guidebookId", id);
        model.addAttribute("memberInSessionId", memberInSessionId);
        model.addAttribute("reservationRequest", new ReservationRequest());
        return "reservationRequestForm";
    }

    @PostMapping("/saveReservationProcess/{id}")
    public String saveReservation(@Valid @ModelAttribute("reservationRequest")ReservationRequest newReservationRequest,
                                  @PathVariable Integer id, BindingResult bindingResult, Model model,
                                  @SessionAttribute("memberInSessionId")Integer memberInSessionId){

        if (memberInSessionId != null){
            ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestByMemberAndGuidebookId(memberInSessionId, id);
            String state = reservationRequestInBdd.getStatus();
            if (state == null || state == ReservationState.CLOSED.getStateValue() || state == ReservationState.CANCELLED.getStateValue() || state == ReservationState.REFUSED.getStateValue()){
                if (bindingResult.hasErrors()){
                    model.addAttribute("guidebookId", id);
                    model.addAttribute("memberInSessionId", memberInSessionId);
                    return "reservationRequestForm";
                } else {
                    newReservationRequest.setGuidebook(guidebookManager.findGuidebook(id));
                    newReservationRequest.setMember(memberManager.findMember(memberInSessionId));
                    newReservationRequest.setReservationState(ReservationState.PENDING);
                    reservationRequestManager.createReservationRequest(newReservationRequest);
                    return "redirect:/guidebookList";
                }
            } else {
                String msg = "Il y a déjà une réservation. Merci d'essayer ultérieurement.";
                model.addAttribute("errorMsg", msg);
                model.addAttribute("guidebookId", id);
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "redirect:/guidebookList";
            }
        } else {
          return "redirect:/doLogin";
        }
    }

    @GetMapping("/updateReservationState/{id}")
    public String showUpdateReservationState(Model model, @PathVariable Integer id,
                                             @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ReservationRequest reservationRequestToUpdate = reservationRequestManager.findReservationRequestById(id);
            model.addAttribute("reservationRequestToUpdate", reservationRequestToUpdate);
            return "updateReservationForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/updateReservationState/updatingReservationStateProcess/{id}")
    public String updateReservationRequest(@Valid ReservationRequest reservationRequest, BindingResult bindingResult, Model model,
                                     @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){

            ReservationRequest reservationRequestInBdd = reservationRequestManager.findReservationRequestById(id);
            Guidebook guidebookToLoan = reservationRequestInBdd.getGuidebook();
            if (bindingResult.hasErrors()){
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors ) {
                    System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
                }
                String str = "Une erreur est survenue. Vérifiez les champs.";
                model.addAttribute("reservationRequestToUpdate", reservationRequest);
                model.addAttribute("errorMessage", str);
                return "updateReservationForm";
            } else {
                if (reservationRequest.getStatus() == ReservationState.ACCEPTED.getStateValue()){
                    guidebookToLoan.setLoaned(true);
                }
                if (reservationRequest.getStatus() == ReservationState.CLOSED.getStateValue()){
                    guidebookToLoan.setLoaned(false);
                }
                guidebookManager.updateGuidebook(guidebookToLoan);
                reservationRequestManager.updateReservationRequest(reservationRequest);
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "redirect:/personalSpace/{memberInSessionId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }


}
