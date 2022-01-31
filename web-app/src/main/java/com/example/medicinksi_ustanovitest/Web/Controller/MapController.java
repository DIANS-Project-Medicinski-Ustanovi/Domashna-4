package com.example.medicinksi_ustanovitest.Web.Controller;

import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
public class MapController{
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public MapController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping("/map")
    public String getMapPage(Model model) {

        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("filteredMedicalLabs", medicinski_ustanoviService.FilterdMedUstanovi(null,null,null));
        model.addAttribute("bodyContent", "Map View");
        return "master-template";

    }

    @PostMapping("/map")
    public String postMapPage(Model model, HttpServletRequest req) {

        String category = req.getParameter("category");
        String city = req.getParameter("city");
        String covidTest = req.getParameter("covidTest");
        req.setAttribute("category", category);
        req.setAttribute("city", city);
        req.setAttribute("covidTest", covidTest);
        req.setAttribute("countMedicalLabs", medicinski_ustanoviService.FilterdMedUstanovi(category, city, covidTest).size());
        model.addAttribute("allCities", medicinski_ustanoviService.getAllCities());
        model.addAttribute("allCategories", medicinski_ustanoviService.getAllCategories());
        model.addAttribute("filteredMedicalLabs", medicinski_ustanoviService.FilterdMedUstanovi(category, city, covidTest));
        model.addAttribute("bodyContent", "Map View");
        return "master-template";
    }
}
