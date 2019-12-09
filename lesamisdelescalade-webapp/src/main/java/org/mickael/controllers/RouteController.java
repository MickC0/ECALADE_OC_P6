package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.Route;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;


@Controller
public class RouteController {

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

    /** ======== Route ======== */

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

    @GetMapping("/updateRoute/{id}")
    public String updateRoute(Model model, @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){

            Route routeToUpdate = routeManager.findRoute(id);
            model.addAttribute("memberInSessionId", memberInSessionId);
            model.addAttribute("routeToUpdate", routeToUpdate);
            return "updateRouteForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/updateRoute/updatingRouteProcess/{id}")
    public String updatingRoute(@Valid Route route, @PathVariable Integer id, Model model, BindingResult bindingResult, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                model.addAttribute("memberInSessionId", memberInSessionId);
                model.addAttribute("routeToUpdate", routeManager.findRoute(id));
                return  "updateRouteForm";
            } else {
                Integer climbId = sectorManager.findSector(routeManager.findRoute(id).getSector().getId()).getClimbingArea().getId();

                routeManager.updateRoute(route);
                model.addAttribute("climbId", climbId);
                model.addAttribute("memberInSessionId", memberInSessionId);
                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/deleteRoute/{id}")
    public String deleteRoute(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            Integer climbId = routeManager.findRoute(id).getSector().getClimbingArea().getId();
            routeManager.deleteRoute(id);
            model.addAttribute("climbId", climbId);
            return "redirect:/climbingArea/{climbId}";
        } else {
            return "redirect:/doLogin";
        }
    }
}