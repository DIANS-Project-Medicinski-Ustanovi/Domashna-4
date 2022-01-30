package com.example.medicinksi_ustanovitest.Web.Controller;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController  {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public HomeController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping({"/home", ""})
    public String getHomePage(Model model){
        model.addAttribute("countAllMedicalLabs", medicinski_ustanoviService.countAllMedicalLabs());
        model.addAttribute("countAllCovidLabs", medicinski_ustanoviService.countAllCovidLabs());
        model.addAttribute("bodyContent", "Home");
        return "master-template";
    }
}
