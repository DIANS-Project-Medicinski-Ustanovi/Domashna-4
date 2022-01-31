package com.golab.medicinskaUstanovaservice.Controller;


import com.golab.medicinskaUstanovaservice.Service.Medicinski_UstanoviService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "Covid 19 Record Controller",value = "/covid19TestingLab")
@Slf4j
public class Covid19RecordController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public Covid19RecordController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getCovid19TestingLabPage(Model model){
        log.info("Inside getCovid19TestingLabPage of Covid19RecordController");

        model.addAttribute("Covid19TestingUstanovi", medicinski_ustanoviService.findAllCovid19TestingLabs());
        return "Covid-19 Records";
    }
}
