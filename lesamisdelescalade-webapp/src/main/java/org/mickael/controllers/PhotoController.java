package org.mickael.controllers;

import org.mickael.business.contract.manager.*;
import org.mickael.model.bean.Photo;
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
public class PhotoController {

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
    private UtilsManager utilsManager;

    @Inject
    private GuidebookManager guidebookManager;

    @GetMapping("/climbingArea/{climbId}/showPhotoForm")
    public String showPhotoFormClimbingArea(@PathVariable Integer climbId, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        }
        model.addAttribute("climbId", climbId);
        model.addAttribute("photo", new Photo());

        return "photoForm";
    }

    @PostMapping("/climbingArea/{climbId}/savePhotoProcess")
    public String savePhotoClimbingArea(@PathVariable Integer climbId, @Valid Photo photo, BindingResult bindingResult, Model model,
                            @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        }

        if (bindingResult.hasErrors()){
            model.addAttribute("msg", "Une erreur est survenue");
            model.addAttribute("climbId", climbId);
            model.addAttribute("photo", photo);
            return "photoForm";
        } else {
            photo.setClimbingArea(climbingAreaManager.findClimbingArea(climbId));
            photoManager.createPhoto(photo);
            model.addAttribute("climbId", climbId);
            model.addAttribute("memberInSessionId", memberInSessionId);
            return "redirect:/climbingArea/{climbId}";
        }
    }

    @GetMapping("/climbingArea/{climbId}/showUpdatePhotoList")
    public String showUpdatePhotoFormClimbingArea(@PathVariable Integer climbId, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        }
        List<Photo> photoList = photoManager.findAllPhotoByClimbingAreaId(climbId);
        model.addAttribute("climbId", climbId);
        model.addAttribute("photoList", photoList);

        return "updatePhotoList";
    }

    @GetMapping("/updatePhoto/{id}")
    public String showUpdatePhotoForm(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        }

        Photo photoToUpdate = photoManager.findPhoto(id);
        model.addAttribute("photoToUpdate", photoToUpdate);
        model.addAttribute("memberInSessionId", memberInSessionId);
        return "updatePhotoForm";
    }

    @PostMapping("/updatePhoto/updatingPhotoProcess/{id}")
    public String updatePhotoProcess(@PathVariable Integer id, @Valid Photo photo, Model model, BindingResult bindingResult, @SessionAttribute(value = "memberInSessionId", required = false)Integer memberInSessionId){
        if (memberInSessionId == null){
            return "redirect:/doLogin";
        }

        if (bindingResult.hasErrors()){
            model.addAttribute("photoToUpdate", photoManager.findPhoto(id));
            model.addAttribute("memberInSessionId", memberInSessionId);
            return "updatePhotoForm";
        } else {
            photoManager.updatePhoto(photo);
            model.addAttribute("climbId", photo.getClimbingArea().getId());
            model.addAttribute("memberInSessionId", memberInSessionId);
            return "redirect:/climbingArea/{climbId}";
        }
    }

    @GetMapping("/deletePhoto/{id}")
    public String deletePhoto(@PathVariable Integer id, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (memberInSessionId == null) {
            return "redirect:/doLogin";
        }
        model.addAttribute("climbId", photoManager.findPhoto(id).getClimbingArea().getId());
        photoManager.deletePhoto(id);
        return "redirect:/climbingArea/{climbId}";
    }

}
