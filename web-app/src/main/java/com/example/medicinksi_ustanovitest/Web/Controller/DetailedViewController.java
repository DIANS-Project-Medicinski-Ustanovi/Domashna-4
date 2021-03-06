package com.example.medicinksi_ustanovitest.Web.Controller;


import com.example.medicinksi_ustanovitest.Service.Medicinski_UstanoviService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class DetailedViewController  {
    private final Medicinski_UstanoviService medicinski_ustanoviService;

    public DetailedViewController(Medicinski_UstanoviService medicinski_ustanoviService) {
        this.medicinski_ustanoviService = medicinski_ustanoviService;
    }


    @GetMapping("/{id}")
    public String getDetailedView(Model model, @PathVariable int id) {
        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));
        model.addAttribute("bodyContent", "Detailed View LAB");
        return "master-template";
    }

    @PostMapping("/{id}")
    public String postDetailedView(Model model, @PathVariable int id,
                                   HttpServletRequest req) {

        req.setAttribute("adresa", req.getParameter("adresa"));  //vnesen input adresa od korisnik
        String izbranaAdresa = req.getParameter("izbranaAdresa"); // izbrana adresa vo select
        req.setAttribute("izbranaAdresa", izbranaAdresa);

        if(izbranaAdresa!=null) {
            model.addAttribute("user_lat", this.medicinski_ustanoviService.extractLatitudeFromAddress(izbranaAdresa));
            model.addAttribute("user_lng", this.medicinski_ustanoviService.extractLongitudeFromAddress(izbranaAdresa));
        }

        model.addAttribute("adresa", req.getAttribute("adresa"));
        model.addAttribute("izbranaAdresa", req.getAttribute("izbranaAdresa"));
        model.addAttribute("DetailedViewLab", medicinski_ustanoviService.findById(id));
        model.addAttribute("bodyContent", "Detailed View LAB");

        return "master-template";
    }

}
