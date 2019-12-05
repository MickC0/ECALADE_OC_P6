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
    private MemberManager memberManager;

    @Inject
    private PhotoManager photoManager;

    @Inject
    private GuidebookManager guidebookManager;

    @Inject
    private RouteManager routeManager;

    @GetMapping("/showClimbingAreaForm")
    public String showClimbingAreaForm(Model model, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){
            model.addAttribute("climbingArea", new ClimbingArea());
            return "climbingAreaForm";
        } else {
            return "redirect:/doLogin";
        }

    }

    @PostMapping("/saveClimbingAreaProcess")
    public String saveClimbingArea(@Valid @ModelAttribute("climbingArea") ClimbingArea newClimbingArea, BindingResult bindingResult, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
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
    public String showUpdateClimbingAreaForm(Model model, @PathVariable Integer id,
                                             @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ClimbingArea climbingAreaToUpdate = climbingAreaManager.findClimbingArea(id);
            model.addAttribute("climbingAreaToUpdate", climbingAreaToUpdate);
            return "updateClimbingAreaForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/editClimbingArea/updateClimbingArea/{id}")
    public String updateClimbingArea(@Valid ClimbingArea climbingArea, BindingResult bindingResult, Model model,
                                         @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ClimbingArea climbingAreaInBdd = climbingAreaManager.findClimbingArea(id);
            climbingArea.setMember(climbingAreaInBdd.getMember());

            if (bindingResult.hasErrors()){
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
                return "redirect:/climbingAreaList";
            }
        } else {
            return "redirect:/doLogin";
        }
    }


    @GetMapping("/deleteClimbingArea/{id}")
    public String deleteClimbingArea(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            ClimbingArea climbingAreaToDelete = climbingAreaManager.findClimbingArea(id);
            climbingAreaManager.deleteClimbingArea(climbingAreaToDelete.getId());
            return "redirect:/climbingAreaList";
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/createNewSector/{climbId}")
    public String createNewSector(@PathVariable Integer climbId, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            Sector sector = new Sector();
            sector.setClimbingArea(climbingAreaManager.findClimbingArea(climbId));
            model.addAttribute("sector", sector);
            model.addAttribute("climbId", climbId);
            return "sectorForm";

        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/createNewSector/saveSector/{climbId}")
    public String saveSector(@PathVariable Integer climbId, Model model,@Valid Sector sector, BindingResult bindingResult,
                             @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){

        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                    model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");

                    return "sectorForm";
            } else {
                sectorManager.createSector(sector);

                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/updateSector/{id}")
    public String updateSector(Model model, @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){

            Sector sectorToUpdate = sectorManager.findSector(id);
            model.addAttribute("memberInSessionId", memberInSessionId);
            model.addAttribute("sectorToUpdate", sectorToUpdate);
            return "updateSectorForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/updateSector/updatingSectorProcess/{id}")
    public String updatingSector(@Valid Sector sector, @PathVariable Integer id, Model model, BindingResult bindingResult, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                model.addAttribute("memberInSessionId", memberInSessionId);
                model.addAttribute("sectorToUpdate", sectorManager.findSector(id));
                return  "updateSectorForm";
            } else {
                sectorManager.updateSector(sector);
                model.addAttribute("climbId", sector.getClimbingArea().getId());
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/createNewRoute/{sectorId}")
    public String createNewRoute(@PathVariable Integer sectorId, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            Route route = new Route();
            route.setSector(sectorManager.findSector(sectorId));
            model.addAttribute("route", route);
            model.addAttribute("sectorId", sectorId);
            return "routeForm";

        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/createNewRoute/saveRoute/{sectorId}")
    public String saveRoute(@PathVariable Integer sectorId, Model model, @Valid Route route, BindingResult bindingResult,
                             @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){

        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                    model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");

                    return "routeForm";
            } else {
                routeManager.createRoute(route);
                Integer climbId = sectorManager.findSector(sectorId).getClimbingArea().getId();
                model.addAttribute("climbId", climbId);

                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }
}
