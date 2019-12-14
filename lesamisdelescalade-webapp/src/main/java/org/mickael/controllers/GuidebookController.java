package org.mickael.controllers;

import org.mickael.business.contract.manager.GuidebookManager;
import org.mickael.business.contract.manager.MemberManager;
import org.mickael.model.bean.Guidebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@Controller
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


    @PostMapping("/saveGuidebookProcess")
    public String saveGuidebook(@Valid @ModelAttribute("guidebook") Guidebook newGuidebook, BindingResult bindingResult, Model model,
                                @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){

            Guidebook guidebookInBdd = guidebookManager.findGuidebookByProperty("name", newGuidebook.getName());
            if (guidebookInBdd != null){
                model.addAttribute("errorMessage", "Désolé ce site existe déjà");
                return "redirect:/showGuidebookForm";
            } else {
                if (bindingResult.hasErrors()){
                    model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");
                    return "redirect:/showGuidebookForm";
                } else {

                    newGuidebook.setMember(memberManager.findMember(memberInSessionId));
                    newGuidebook.setLoaned(false);
                    newGuidebook.setAddedDate(new Timestamp(System.currentTimeMillis()));
                    guidebookManager.createGuidebook(newGuidebook);
                    model.addAttribute("id", memberInSessionId);
                    return "redirect:/personalSpace/{id}"; //voir la redirection avec {id} ?
                }
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/guidebook/{id}")
    public String showGuidebook(@PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        Guidebook guidebook = guidebookManager.findGuidebook(id);

        model.addAttribute("guidebook", guidebook);
        model.addAttribute("memberInSessionId", memberInSessionId);
        return "guidebook";
    }
    
    
    @GetMapping("/editGuidebook/{id}")
    public String showUpdateGuidebookForm(@PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        if (memberInSessionId != null){
            Guidebook guidebook = guidebookManager.findGuidebook(id);
            model.addAttribute("guidebook", guidebook);
            model.addAttribute("memberInSessionId", memberInSessionId);
            return "updateGuidebookForm";
        } else {
            return "redirect:/doLogin";
        }
    }
    
    @PostMapping("/editGuidebook/updateGuidebook/{id}")
    public String updateGuidebook(@PathVariable Integer id, @Valid Guidebook guidebook, BindingResult bindingResult,
                                  @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        if (memberInSessionId != null){
            Guidebook guidebookInBdd = guidebookManager.findGuidebook(id);
            guidebook.setMember(guidebookInBdd.getMember());
            
            if (bindingResult.hasErrors()){
                model.addAttribute("guidebook", guidebook);
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "updateGuidebookForm";
            } else {
                guidebookManager.updateGuidebook(guidebook);
                return "redirect:/guidebookList";
            }
        } else {
            return "redirect:/doLogin";
        }
    }
    


    @GetMapping("/guidebookList")
    public String showGuidebookList(Model model){
        List<Guidebook> guidebookList = guidebookManager.findAllGuidebook();
        model.addAttribute("guidebookList", guidebookList);
        return "guidebookListPage";
    }



}
