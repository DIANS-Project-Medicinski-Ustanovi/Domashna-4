package com.example.medicinksi_ustanovitest.Web.Servlet;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(name = "DetailedView", value = "/MedicalLAB/{id}")
public class DetailedViewController extends ModelAddingAndSettingAttributes {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public DetailedViewController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }


    @GetMapping
    public String getDetailedView(Model model, @PathVariable int id) {
        addingAttribute(model,"DetailedViewLab", medicinski_ustanoviService.findById(id));
        return "Detailed View LAB";
    }

    @PostMapping
    public String postDetailedView(Model model, @PathVariable int id,
                                   HttpServletRequest req) {

        String adresa = getAdress(req, "adresa");
        settingAttribute(req, adresa, "adresa");
        addingAttribute(model, "adresa", req.getAttribute("adresa"));

        String izbranaAdresa = getAdress(req, "izbranaAdresa");
        settingAttribute(req, izbranaAdresa, "izbranaAdresa");
        addingAttribute(model, "izbranaAdresa", req.getAttribute("izbranaAdresa"));

        if(izbranaAdresa!=null) {
            String lat_adresa = izbranaAdresa.split("lat:")[1].split(",")[0].trim();
            String lng_adresa = izbranaAdresa.split("lng:")[1].trim();
            addingAttribute(model, "user_lat", lat_adresa);
            addingAttribute(model, "user_lng", lng_adresa);
        }

        addingAttribute(model,"DetailedViewLab",medicinski_ustanoviService.findById(id));
        return "Detailed View LAB";
    }

    private String getAdress(HttpServletRequest req, String adress) {
        return req.getParameter(adress);
    }

}
