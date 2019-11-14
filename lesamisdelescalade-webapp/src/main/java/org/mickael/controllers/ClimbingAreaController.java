package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;


@Controller
public class ClimbingAreaController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @Inject
    private SectorManager sectorManager;

    @Inject
    private ParkingManager parkingManager;

    @Inject
    private StartingPointManager startingPointManager;

    @Inject
    private MemberManager memberManager;

    @Inject
    private PhotoManager photoManager;

    @Inject
    private GuidebookManager guidebookManager;

    @Inject
    private RouteManager routeManager;

    @GetMapping("/showClimbingAreaForm")
    public String showClimbingAreaForm(Model model){
        model.addAttribute("climbingArea", new ClimbingArea());
        return "showClimbingArea";
    }

    @PostMapping("/saveClimbingAreaProcess")
    public String saveClimbingArea(@Valid @ModelAttribute("climbingArea") ClimbingArea newClimbingArea, BindingResult bindingResult, Model model, @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if (memberInSessionId != null){
            ClimbingArea climbingAreaInBdd = climbingAreaManager.findClimbingAreaByProperty("name", newClimbingArea.getName());
            if (climbingAreaInBdd != null){
                model.addAttribute("errorMessage", "Désolé ce site existe déjà");
                return "redirect:showClimbingAreaForm";
            } else {
                if (bindingResult.hasErrors()){
                    model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");
                    return "redirect:showClimbingAreaForm";
                } else {
                    climbingAreaManager.createClimbingArea(newClimbingArea);
                    return "redirect:/climbingAreaList";
                }
            }
        } else {
            return "redirect:doLogin";
        }
    }

    @GetMapping("/climbingArea/{id}")
    public String showClimbingArea(@PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        ClimbingArea climbingArea = climbingAreaManager.findClimbingArea(id);
        model.addAttribute("climbingArea", climbingArea);
        return "climbingArea";
    }

    @GetMapping("/climbingAreaList")
    public String showClimbingAreaList(Model model){
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        return "climbingAreaListPage";
    }
}
