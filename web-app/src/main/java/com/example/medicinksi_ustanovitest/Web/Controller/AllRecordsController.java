package com.example.medicinksi_ustanovitest.Web.Controller;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AllRecordsController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public AllRecordsController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping("/MedicalLAB")
    public String getAllMedicalLabPage(Model model){
        model.addAttribute("allMedicalLabs", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        model.addAttribute("bodyContent", "All Records");
        return "master-template";
    }
}
