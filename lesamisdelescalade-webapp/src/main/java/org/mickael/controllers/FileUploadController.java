package org.mickael.controllers;


import org.mickael.business.impl.manager.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @GetMapping("/showUploadForm")
    public String showUploadForm(){
        return "uploadForm";
    }

    /**
     * Upload single file using Spring Controller
     */
    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile multipartFile){
        long fileSize = multipartFile.getSize();
        String fileName = multipartFile.getOriginalFilename();
        ModelAndView modelAndView = new ModelAndView("upload-success");
        if(fileService.saveFile(multipartFile)){
            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("fileName", fileName);
            modelMap.put("fileSize", fileSize);
            modelAndView.addAllObjects(modelMap);
            return modelAndView;
        }
        return new ModelAndView("upload-failed");
    }


}
