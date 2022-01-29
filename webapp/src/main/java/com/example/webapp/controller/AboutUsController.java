package com.example.webapp.controller;

import com.example.webapp.service.MedicinskaUstanovaFetchService;
import com.example.webapp.dtos.MedicinskaUstanovaDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(name = "About Us Controller",value = "/aboutUs")
public class AboutUsController {
    @GetMapping
    public String getHomePage(Model model){
        return "About US";
    }
}