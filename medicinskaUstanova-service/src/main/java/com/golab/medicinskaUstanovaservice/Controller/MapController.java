package com.golab.medicinskaUstanovaservice.Controller;

import com.golab.medicinskaUstanovaservice.Service.Medicinski_UstanoviService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(name = "Map View", value = "/map")
@Slf4j
public class MapController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public MapController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getMapPage(Model model) {
        log.info("Inside getMapPage of MapController");


        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("medicinski", medicinski_ustanoviService.FilterdMedUstanovi(null,null,null));
        return "Map View";
    }

    @PostMapping
    public String postMapPage(Model model, HttpServletRequest req, HttpServletResponse resp) {
        log.info("Inside postMapPage of MapController");


        String category = req.getParameter("category");
        String city = req.getParameter("city");
        String covidTest = req.getParameter("covidTest");
        req.setAttribute("category", category);
        req.setAttribute("city", city);
        req.setAttribute("covidTest", covidTest);
        req.setAttribute("sizeList", medicinski_ustanoviService.FilterdMedUstanovi(category, city, covidTest).size());
        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("medicinski", medicinski_ustanoviService.FilterdMedUstanovi(category, city, covidTest));

        return "Map View";
    }
}
