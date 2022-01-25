package com.example.medicinksi_ustanovitest.Web.Servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "About Us Controller",value = "/aboutUs")
public class AboutUsController {
    @GetMapping
    public String getHomePage(){
        return "About US";
    }
}