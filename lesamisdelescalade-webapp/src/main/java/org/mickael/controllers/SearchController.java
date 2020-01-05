package org.mickael.controllers;

import org.mickael.business.contract.manager.ClimbingAreaManager;
import org.mickael.business.contract.manager.EnumManager;
import org.mickael.business.contract.manager.PhotoManager;
import org.mickael.business.impl.SearchFilter;
import org.mickael.model.bean.ClimbingArea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Inject
    private ClimbingAreaManager climbingAreaManager;

    @Inject
    private PhotoManager photoManager;

    @Inject
    private EnumManager enumManager;


    @PostMapping("/climbingAreaList/search")
    public String showClimbingAreaListSearchResults(@Valid SearchFilter searchFilter, BindingResult bindingResult, Model model, @SessionAttribute(value = "memberInSessionId", required = false) Integer memberInSessionId){
        if (searchFilter.getName().equals("") && searchFilter.getRegion().equals("") && searchFilter.getCotation().equals("") && searchFilter.getNumberSector() == null){
            return "redirect:/climbingAreaList";
        }

        if (bindingResult.hasErrors()){
            model.addAttribute("msg", "Une erreur s'est produite. Veuillez essayer plus tard.");
            return "redirect:/climbingAreaList";
        } else {
            List<ClimbingArea> climbingAreaList = climbingAreaManager.findAllClimbingAreaSearchRequest(searchFilter.getName(), searchFilter.getRegion(), searchFilter.getCotation(), searchFilter.getNumberSector());
            List<String> regionList = enumManager.getEnumRegionStringValues();
            List<String> cotationList = enumManager.getEnumCotationStringValues();
            List<String> nameList = new ArrayList<>();
            List<Integer> numberSectorList = new ArrayList<>();
            List<ClimbingArea> climbingAreaListAll = climbingAreaManager.findAllClimbingArea();
            for (ClimbingArea climbingArea : climbingAreaListAll){
                nameList.add(climbingArea.getName());
            }

            for (ClimbingArea climbingArea : climbingAreaList){
                climbingArea.setPhotoList(photoManager.findAllPhotoByClimbingAreaId(climbingArea.getId()));
            }

            for (int i = 0; i < 101; i++){
                numberSectorList.add(i);
            }
            if (climbingAreaList.isEmpty()){
                model.addAttribute("noResults", "Aucun Résultat");
            }

            model.addAttribute("action", "climbingAreaList/search");
            model.addAttribute("climbingAreaList", climbingAreaList);
            model.addAttribute("regionList", regionList);
            model.addAttribute("cotationList", cotationList);
            model.addAttribute("nameList", nameList);
            model.addAttribute("numberSectorList", numberSectorList);
            return "climbingAreaListPage";
        }
    }
}
