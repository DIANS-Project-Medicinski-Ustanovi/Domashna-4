package com.example.medicinksi_ustanovitest.Web.Controller;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Covid19RecordController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public Covid19RecordController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping("/covid19TestingLab")
    public String getCovid19TestingLabPage(Model model){
        model.addAttribute("Covid19TestingLabs", medicinski_ustanoviService.findAllCovid19TestingLabs());
        model.addAttribute("bodyContent", "Covid-19 Records");
        return "master-template";
    }
}
