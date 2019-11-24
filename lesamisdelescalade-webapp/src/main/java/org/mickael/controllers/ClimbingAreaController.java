package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.ClimbingArea;
import org.mickael.model.bean.Route;
import org.mickael.model.bean.Sector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
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
        return "climbingAreaForm";
    }

    @PostMapping("/saveClimbingAreaProcess")
    public String saveClimbingArea(@Valid @ModelAttribute("climbingArea") ClimbingArea newClimbingArea, BindingResult bindingResult, Model model, @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if (memberInSessionId != null){
            System.out.println(newClimbingArea.getName());
            ClimbingArea climbingAreaInBdd = climbingAreaManager.findClimbingAreaByProperty("name", newClimbingArea.getName());
            if (climbingAreaInBdd != null){
                model.addAttribute("errorMessage", "Désolé ce site existe déjà");
                return "redirect:/showClimbingAreaForm";
            } else {
                if (bindingResult.hasErrors()){
                    model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");
                    return "redirect:/showClimbingAreaForm";
                } else {
                    newClimbingArea.setMember(memberManager.findMember(memberInSessionId));
                    newClimbingArea.setApprouved(false);
                    climbingAreaManager.createClimbingArea(newClimbingArea);
                    return "redirect:/climbingAreaList";
                }
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/climbingArea/{id}")
    public String showClimbingArea(@PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        ClimbingArea climbingArea = climbingAreaManager.findClimbingArea(id);
        List<Sector> sectorList = sectorManager.findAllSectorByClimbingAreaId(id);
        List<Route> routeList = new ArrayList<>();
        for (Sector sector : sectorList){
            for (Route route : routeManager.findAllRouteBySectorId(sector.getId())){
                routeList.add(route);
            }
        }
        model.addAttribute("climbArea", climbingArea);
        model.addAttribute("sectorArea", sectorList);
        model.addAttribute("routeArea", routeList);
        return "climbingArea";
    }

    @GetMapping("/climbingAreaList")
    public String showClimbingAreaList(Model model){
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        model.addAttribute("climbingAreaList", climbingAreaList);
        return "climbingAreaListPage";
    }


    @GetMapping("/editClimbingArea/{id}")
    public String showUpdateClimbingAreaForm(Model model, @PathVariable("id") Integer id,
                                             @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if (memberInSessionId != null){
            ClimbingArea climbingAreaToUpdate = climbingAreaManager.findClimbingArea(id);
            System.out.println("etape 1");
            System.out.println(climbingAreaToUpdate.toString());
            model.addAttribute("climbingAreaToUpdate", climbingAreaToUpdate);
            return "updateClimbingAreaForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/editClimbingArea/updateClimbingArea/{id}")
    public String updateClimbingArea(@Valid ClimbingArea climbingArea, BindingResult bindingResult, Model model,
                                         @PathVariable("id") Integer id, @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if (memberInSessionId != null){
            System.out.println("etape 2");
            ClimbingArea climbingAreaInBdd = climbingAreaManager.findClimbingArea(id);
            climbingArea.setMember(climbingAreaInBdd.getMember());
            System.out.println("info etape 2 " + climbingArea);

            if (bindingResult.hasErrors()){
                System.out.println("erreur binding");
                List<FieldError> errors = bindingResult.getFieldErrors();
                for (FieldError error : errors ) {
                    System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
                }
                String str = "Une erreur est survenue. Vérifiez les champs.";
                model.addAttribute("climbingAreaToUpdate", climbingArea);
                model.addAttribute("errorMessage", str);
                return "updateClimbingAreaForm";
            } else {
                climbingAreaManager.updateClimbingArea(climbingArea);
                System.out.println("etape 3 " + climbingArea);
                return "redirect:/climbingAreaList";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/deleteClimbingArea/{id}")
    public String deleteClimbingArea(@PathVariable("id")Integer id, Model model, @SessionAttribute("memberInSessionId") Integer memberInSessionId){
        if (memberInSessionId != null){
            ClimbingArea climbingAreaToDelete = climbingAreaManager.findClimbingArea(id);
            climbingAreaManager.deleteClimbingArea(climbingAreaToDelete.getId());
            return "redirect:/climbingAreaList";
        } else {
            return "redirect:/doLogin";
        }
    }
}
