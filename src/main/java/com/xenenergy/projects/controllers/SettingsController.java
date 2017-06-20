package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Property;
import com.xenenergy.projects.entities.PropertyWrapper;
import com.xenenergy.projects.services.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by xesi on 19/06/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("")
public class SettingsController {
    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String showbillForm(Model model){
        PropertyWrapper duProperty = new PropertyWrapper();
        duProperty.setProperties(propertyService.getAllDuProperty());
        model.addAttribute("duproperties", duProperty);
        return "settings/index";
    }

    @GetMapping("/settings/edit")
    public String editForm(Model model){
        PropertyWrapper duProperty = new PropertyWrapper();
        duProperty.setProperties(propertyService.getAllDuProperty());
        model.addAttribute("duproperties", duProperty);
        return "settings/edit";
    }

    @PostMapping("settings/update")
    public String update(@ModelAttribute("duproperties") PropertyWrapper duproperties,
                         final RedirectAttributes redirectAttributes){
        System.out.println(duproperties.getProperties() != null ? duproperties.getProperties().size() : "null list");
        for(Property property : duproperties.getProperties()){
            //System.out.println("Property Value >> " + property.getPropertyValue());
            if(propertyService.update(property) != null){
                redirectAttributes.addFlashAttribute("edit", "success");
            }else{
                redirectAttributes.addFlashAttribute("edit", "unsuccess");
            }
        }
        System.out.println("--");
        return "redirect:/settings";
    }
}
