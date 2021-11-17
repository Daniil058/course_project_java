package com.example.course_project_java.controllers;

import com.example.course_project_java.repository.DataRepository;
import com.example.course_project_java.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {

    @Autowired
    DataRepository dataRepository;

    @PostMapping("/")
    public String handleFileUpload(@RequestParam MultipartFile file, Model model){
        FileUploadService.uploadFileToDatabase(dataRepository, file);
        return "redirect:/";
    }
}
