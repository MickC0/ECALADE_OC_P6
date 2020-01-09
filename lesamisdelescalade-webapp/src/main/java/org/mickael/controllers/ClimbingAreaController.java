package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.business.impl.SearchFilter;
import org.mickael.model.bean.*;
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
    private CommentManager commentManager;

    @Inject
    private RouteManager routeManager;

    @Inject
    private EnumManager enumManager;




    /** ======== Climbing Area ======== */


    @GetMapping("/showClimbingAreaForm")
    public String showClimbingAreaForm(Model model, @SessionAttribute(value = "memberInSessionId", required = true)Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
        List<String> regionList = enumManager.getEnumRegionStringValues();
        model.addAttribute("regionList", regionList);
        model.addAttribute("climbingArea", new ClimbingArea());
        return "climbingAreaForm";
    }

    @PostMapping("/saveClimbingAreaProcess")
    public String saveClimbingArea(@Valid @ModelAttribute("climbingArea") ClimbingArea newClimbingArea, BindingResult bindingResult, Model model, @SessionAttribute(value = "memberInSessionId", required = true) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
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
    }

    @GetMapping("/climbingArea/{id}")
    public String showClimbingArea(@PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId, Model model){
        ClimbingArea climbingArea = climbingAreaManager.findClimbingArea(id);
        List<Sector> sectorList = sectorManager.findAllSectorByClimbingAreaId(id);
        List<Comment> commentList = commentManager.findAllCommentByClimbingArea(id);
        List<Photo> photoList = photoManager.findAllPhotoByClimbingAreaId(id);
        climbingArea.setPhotoList(photoList);
        climbingArea.setSectorList(sectorList);
        climbingArea.setCommentList(commentList);

        for (Sector sector : sectorList){
            List<Route> routeList = new ArrayList<>();
            for (Route route : routeManager.findAllRouteBySectorId(sector.getId())){
                routeList.add(route);
            }
            sector.setRouteList(routeList);
        }
        model.addAttribute("climbArea", climbingArea);
        return "climbingArea";
    }

    @GetMapping("/climbingAreaList")
    public String showClimbingAreaList(Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingArea();
        List<String> regionList = enumManager.getEnumRegionStringValues();
        List<String> cotationList = enumManager.getEnumCotationStringValues();
        List<String> nameList = new ArrayList<>();
        List<Integer> numberSectorList = new ArrayList<>();

        for (ClimbingArea climbingArea : climbingAreaList){
            climbingArea.setPhotoList(photoManager.findAllPhotoByClimbingAreaId(climbingArea.getId()));
        }
        for (ClimbingArea climbingArea : climbingAreaList){
            nameList.add(climbingArea.getName());
        }

        for (int i = 0; i < 101; i++){
            numberSectorList.add(i);
        }
        model.addAttribute("regionList", regionList);
        model.addAttribute("cotationList", cotationList);
        model.addAttribute("nameList", nameList);
        model.addAttribute("numberSectorList", numberSectorList);
        model.addAttribute("searchFilter", new SearchFilter());
        model.addAttribute("climbingAreaList", climbingAreaList);
        return "climbingAreaListPage";
    }


    @GetMapping("/updateClimbingArea/{id}")
    public String showUpdateClimbingAreaForm(Model model, @PathVariable Integer id,
                                             @SessionAttribute(value = "memberInSessionId", required = true) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
        ClimbingArea climbingAreaToUpdate = climbingAreaManager.findClimbingArea(id);
        List<String> regionList = enumManager.getEnumRegionStringValues();
        model.addAttribute("regionList", regionList);
        model.addAttribute("climbingAreaToUpdate", climbingAreaToUpdate);
        return "updateClimbingAreaForm";
    }

    @PostMapping("/updateClimbingArea/updateClimbingAreaProcess/{id}")
    public String updateClimbingArea(@Valid ClimbingArea climbingArea, BindingResult bindingResult, Model model,
                                         @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = true) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
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
            model.addAttribute("id", id);
            return "redirect:/climbingArea/{id}";
        }
    }

    @GetMapping("/tagClimbingArea/{id}")
    public String showTagClimbingAreaForm(Model model, @PathVariable Integer id,
                                             @SessionAttribute(value = "memberInSessionId", required = true) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
        ClimbingArea climbingAreaToUpdate = climbingAreaManager.findClimbingArea(id);
        List<String> regionList = enumManager.getEnumRegionStringValues();
        model.addAttribute("regionList", regionList);
        model.addAttribute("climbingAreaToUpdate", climbingAreaToUpdate);
        return "tagClimbingAreaForm";
    }

    @PostMapping("/tagClimbingArea/tagClimbingAreaProcess/{id}")
    public String updateTagClimbingArea(@Valid ClimbingArea climbingArea, BindingResult bindingResult, Model model,
                                     @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = true) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
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
            return "tagClimbingAreaForm";
        } else {
            if (climbingArea.isApprouved() == true){
                climbingAreaManager.addTag(id);
            } else {
                climbingAreaManager.deleteTag(id);
            }
            model.addAttribute("id", id);
            return "redirect:/climbingArea/{id}";
        }
    }


    @GetMapping("/deleteClimbingArea/{id}")
    public String deleteClimbingArea(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
        //delete sector
        List<Sector> sectorList = sectorManager.findAllSectorByClimbingAreaId(id);
        for (Sector sector : sectorList){
            //delete route
            List<Route> routeList = routeManager.findAllRouteBySectorId(sector.getId());
            for (Route route : routeList){
                routeManager.deleteRoute(route.getId());
            }
            sectorManager.deleteSector(sector.getId());
        }
        //delete comment
        List<Comment> commentList = commentManager.findAllCommentByClimbingArea(id);
        for (Comment comment : commentList){
            commentManager.deleteComment(comment.getId());
        }
        //delete photo
        List<Photo> photoList = photoManager.findAllPhotoByClimbingAreaId(id);
        for (Photo photo : photoList){
            photoManager.deletePhoto(photo.getId());
        }
        //delete climbing area
        climbingAreaManager.deleteClimbingArea(id);
        return "redirect:/climbingAreaList";
    }



    /** ======== Sector ========



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

    /** ======== Route ========

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

    /** ======== Comments ========


    @GetMapping("/createNewComment/{climbId}")
    public String createNewComment(@PathVariable Integer climbId, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            Comment comment = new Comment();

            comment.setClimbingArea(climbingAreaManager.findClimbingArea(climbId));
            comment.setMember(memberManager.findMember(memberInSessionId));
            model.addAttribute("comment", comment);
            model.addAttribute("climbId", climbId);
            return "commentForm";

        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/createNewComment/saveComment/{climbId}")
    public String saveComment(@PathVariable Integer climbId, Model model,@Valid Comment comment, BindingResult bindingResult,
                             @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){

        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                model.addAttribute("errorMessage", "Une erreur est survenue. Vérifiez les champs.");

                return "commentForm";
            } else {
                commentManager.createComment(comment);
                model.addAttribute("climbId", climbId);
                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/updateComment/{id}")
    public String updateComment(Model model, @PathVariable Integer id, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){

            Comment commentToUpdate = commentManager.findCommentById(id);
            model.addAttribute("memberInSessionId", memberInSessionId);
            model.addAttribute("commentToUpdate", commentToUpdate);
            return "updateCommentForm";
        } else {
            return "redirect:/doLogin";
        }
    }

    @PostMapping("/updateComment/updatingCommentProcess/{id}")
    public String updatingComment(@Valid Comment comment, @PathVariable Integer id, Model model, BindingResult bindingResult, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId != null){
            if (bindingResult.hasErrors()){
                model.addAttribute("memberInSessionId", memberInSessionId);
                model.addAttribute("commentToUpdate", commentManager.findCommentById(id));
                return  "updateCommentForm";
            } else {
                model.addAttribute("climbId", commentManager.findCommentById(id).getClimbingArea().getId());
                model.addAttribute("memberInSessionId", memberInSessionId);
                commentManager.updateComment(comment);
                return "redirect:/climbingArea/{climbId}";
            }
        } else {
            return "redirect:/doLogin";
        }
    }

    @GetMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId != null){
            model.addAttribute("climbId", commentManager.findCommentById(id).getClimbingArea().getId());
            model.addAttribute("memberInSessionId", memberInSessionId);
            commentManager.deleteComment(id);
            return "redirect:/climbingArea/{climbId}";
        } else {
            return "redirect:/doLogin";
        }
    }*/


}
