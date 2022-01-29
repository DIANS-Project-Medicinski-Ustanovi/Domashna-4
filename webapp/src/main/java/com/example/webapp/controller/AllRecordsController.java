package com.example.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.webapp.service.MedicinskaUstanovaFetchService;
import com.example.webapp.dtos.MedicinskaUstanovaDto;
import com.example.webapp.service.Medicinski_UstanoviService;

@Controller
@RequestMapping(name = "All Records Controller",value = "/MedicalLAB")
public class AllRecordsController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public AllRecordsController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getAllMedicalLabPage(Model model){
        model.addAttribute("Ustanovi", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        return "All Records";
    }
}
