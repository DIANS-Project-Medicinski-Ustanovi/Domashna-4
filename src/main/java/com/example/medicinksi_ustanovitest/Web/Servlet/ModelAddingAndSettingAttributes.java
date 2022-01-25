package com.example.medicinksi_ustanovitest.Web.Servlet;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

class ModelAddingAndSettingAttributes {
    protected void addingAttribute(Model model, String user_lat, Object lat_adresa2) {
        model.addAttribute(user_lat, lat_adresa2);
    }
    protected void settingAttribute(HttpServletRequest req, String adresa, String adresa2) {
        req.setAttribute(adresa2, adresa);
    }
}
