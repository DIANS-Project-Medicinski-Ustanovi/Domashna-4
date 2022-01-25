package com.example.medicinksi_ustanovitest.Web.Servlet;

import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(name = "Map View", value = "/map")
public class MapController extends ModelAddingAndSettingAttributes {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public MapController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }

    @GetMapping
    public String getMapPage(Model model) {

        addingAttribute(model,"allCities", medicinski_ustanoviService.getAllCities());
        addingAttribute(model,"allCategories", medicinski_ustanoviService.getAllCategories());
        addingAttribute(model,"medicinski", medicinski_ustanoviService.FilterdMedUstanovi(null,null,null));
        return "Map View";
    }

    @PostMapping
    public String postMapPage(Model model, HttpServletRequest req) {

        String category = req.getParameter("category");
        String city = req.getParameter("city");
        String covidTest = req.getParameter("covidTest");
        settingAttribute(req,"category", category);
        settingAttribute(req,"city", city);
        settingAttribute(req,"covidTest", covidTest);
        req.setAttribute("sizeList", medicinski_ustanoviService.FilterdMedUstanovi(category, city, covidTest).size());
        addingAttribute(model,"allCities", medicinski_ustanoviService.getAllCities());
        addingAttribute(model,"allCategories", medicinski_ustanoviService.getAllCategories());
        addingAttribute(model,"medicinski", medicinski_ustanoviService.FilterdMedUstanovi(category, city, covidTest));

        return "Map View";
    }
}
