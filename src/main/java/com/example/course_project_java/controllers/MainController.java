package com.example.course_project_java.controllers;

import com.example.course_project_java.service.ProcessingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private final ProcessingDataService processingDataService;

    @Autowired
    public MainController(
            ProcessingDataService processingDataService
    ){
        this.processingDataService = processingDataService;
    }

    @GetMapping("/")
    public ModelAndView home(Model model) {
        model.addAttribute("dates",
                processingDataService.getAndSaveDates());
        return new ModelAndView("/index");
    }
}