package com.example.medicinksi_ustanovitest.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "About Us Controller",value = "/aboutUs")
public class AboutUsController {
    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "About US");
        return "master-template";
    }
}