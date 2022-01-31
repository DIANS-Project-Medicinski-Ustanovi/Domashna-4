package com.golab.medicinskaUstanovaservice.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "About Us Controller",value = "/aboutUs")
@Slf4j
public class AboutUsController {

    public String getHomePage(Model model){
        log.info("Inside getHomePage of AboutUsController");
        return "About US";
    }
}