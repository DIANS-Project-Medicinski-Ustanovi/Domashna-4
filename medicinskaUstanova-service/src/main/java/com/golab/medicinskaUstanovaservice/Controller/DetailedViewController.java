package com.golab.medicinskaUstanovaservice.Controller;


import com.golab.medicinskaUstanovaservice.Service.Medicinski_UstanoviService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(name = "DetailedView", value = "/MedicalLAB/{id}")
@Slf4j
public class DetailedViewController {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public DetailedViewController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }


    @GetMapping
    public String getDetailedView(Model model, @PathVariable int id) {
        log.info("Inside getDetailedView of DetailedViewController");

        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));
        return "Detailed View LAB";
    }

    @PostMapping
    public String postDetailedView(Model model, @PathVariable int id, HttpServletResponse resp,
                                   HttpServletRequest req) {
        log.info("Inside postDetailedView of DetailedViewController");


        String adresa = req.getParameter("adresa");   //vnesen input adresa od korisnik
        req.setAttribute("adresa", adresa);
        model.addAttribute("adresa", req.getAttribute("adresa"));

        String izbranaAdresa = req.getParameter("izbranaAdresa"); // izbrana adresa vo select
        req.setAttribute("izbranaAdresa", izbranaAdresa);
        model.addAttribute("izbranaAdresa", req.getAttribute("izbranaAdresa"));

        if(izbranaAdresa!=null) {
            String lat_adresa = izbranaAdresa.split("lat:")[1].split(",")[0].trim();
            String lng_adresa = izbranaAdresa.split("lng:")[1].trim();
            model.addAttribute("user_lat", lat_adresa);
            model.addAttribute("user_lng", lng_adresa);
        }

        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));

        return "Detailed View LAB";
    }

}
