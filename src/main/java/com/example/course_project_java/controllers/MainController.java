package com.example.course_project_java.controllers;

import com.example.course_project_java.models.Data;
import com.example.course_project_java.repository.DataRepository;
import com.example.course_project_java.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Data> dates = dataRepository.getAllDespersion();
        FileDownloadService.fileDownloadFromIterable(dates);
        model.addAttribute("dates", dates);
        return "/index";
    }
}