package com.golab.medicinskaUstanovaservice.Controller;


import com.golab.medicinskaUstanovaservice.Model.Medicinska_Ustanova;
import com.golab.medicinskaUstanovaservice.Service.Medicinski_UstanoviService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "All Records Controller",value = "/MedicalLAB")
@Slf4j
public class AllRecordsController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public AllRecordsController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getAllMedicalLabPage(Model model){
        log.info("Inside getAllMedicalLabPage of AllRecordsController");
        model.addAttribute("Ustanovi", medicinski_ustanoviService.findAllMedicinskiUstanovi());
        return "All Records";
    }
}
