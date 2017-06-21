package com.xenenergy.projects.controllers;

import com.xenenergy.projects.services.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by xesi on 21/06/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/about")
public class AboutController {
    @Autowired
    private PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET)
    public String showbillForm(Model model){
        String dbVersion = "";
        if(propertyService.findByPropertyName("DB_VERSION") == null){
            dbVersion = "No DB Version Found in Property!";
        }else{
            dbVersion = propertyService.findByPropertyName("DB_VERSION").getPropertyValue();
        }
        model.addAttribute("dbVersion", dbVersion);
        return "about/index";
    }
}
