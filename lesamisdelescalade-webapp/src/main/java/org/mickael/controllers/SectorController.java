package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.Route;
import org.mickael.model.bean.Sector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;


@Controller
public class SectorController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @Inject
    private SectorManager sectorManager;

    @Inject
    private MemberManager memberManager;

    @Inject
    private PhotoManager photoManager;

    @Inject
    private CommentManager commentManager;

    @Inject
    private RouteManager routeManager;


    /** ======== Sector ======== */



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

    @GetMapping("/deleteSector/{id}")
    public String deleteSector(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            model.addAttribute("climbId", sectorManager.findSector(id).getClimbingArea().getId());
            List<Route> routeList = routeManager.findAllRouteBySectorId(id);
            for (Route route : routeList){
                routeManager.deleteRoute(route.getId());
            }
            sectorManager.deleteSector(id);
            return "redirect:/climbingArea/{climbId}";
        } else {
            return "redirect:/doLogin";
        }
    }
}