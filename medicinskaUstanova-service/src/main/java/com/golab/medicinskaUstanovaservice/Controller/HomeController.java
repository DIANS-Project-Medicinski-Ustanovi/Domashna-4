package com.golab.medicinskaUstanovaservice.Controller;


import com.golab.medicinskaUstanovaservice.Service.Medicinski_UstanoviService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(name = "Home controller", value = {"/home", ""})
@Slf4j
public class HomeController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public HomeController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getHomePage(Model model){
        log.info("Inside getHomePage of HomeController");

        model.addAttribute("countAll", medicinski_ustanoviService.all());
        model.addAttribute("countCovid", medicinski_ustanoviService.covid());
        return "Home";
    }

}
