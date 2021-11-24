package com.example.course_project_java.controllers;

import com.example.course_project_java.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(
            FileUploadService fileUploadService
    ){
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/")
    public ModelAndView handleFileUpload(
            @RequestParam MultipartFile file,
            Model model
    ) {
        fileUploadService.uploadFileToDatabase(file);
        return new ModelAndView("/index");
    }
}
