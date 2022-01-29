package com.example.webapp.controller;

import com.example.webapp.service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(name = "Map View", value = "/map")
public class MapController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public MapController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getMapPage(Model model) {

        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("medicinski", medicinski_ustanoviService.FilterdMedUstanovi(null,null,null));
        return "Map View";
    }

    @PostMapping
    public String postMapPage(Model model, HttpServletRequest req, HttpServletResponse resp) {

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
