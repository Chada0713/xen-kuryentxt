package com.xenenergy.projects.controllers;

import com.sun.tracing.dtrace.ModuleAttributes;
import com.xenenergy.projects.entities.Property;
import com.xenenergy.projects.entities.PropertyWrapper;
import com.xenenergy.projects.services.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Property> propertyLists = propertyService.getAllNotDuProperty();
        duProperty.setProperties(propertyService.getAllDuProperty());
        List<String> t = new ArrayList<>();

        List<Property> propertyList = new ArrayList<>();
        int i = 0;
        String tag = "";

        if(propertyService.findByPropertyName("DU_CODE") == null){
            t.add("DU_CODE");
            i+=1;
        }if(propertyService.findByPropertyName("DU_NAME") == null){
            t.add("DU_NAME");
            i+=1;
        }if(propertyService.findByPropertyName("DU_VAT_NO") == null){
            t.add("DU_VAT_NO");
            i+=1;
        }if(propertyService.findByPropertyName("DU_CONTACT_PERSON") == null){
            t.add("DU_CONTACT_PERSON");
            i+=1;
        }if(propertyService.findByPropertyName("DU_CONTACT_NO") == null){
            t.add("DU_CONTACT_NO");
            i+=1;
        }if(propertyService.findByPropertyName("DU_ADDRESSLN1") == null){
            t.add("DU_ADDRESSLN1");
            i+=1;
        }if(propertyService.findByPropertyName("DU_ADDRESSLN2") == null){
            t.add("DU_ADDRESSLN2");
            i+=1;
        }

        if(i > 0){
            tag = "true";
        }

        duProperty.setPropertyName(t);
        model.addAttribute("duproperties", duProperty);
        model.addAttribute("tag", tag);
        model.addAttribute("propertyLists", propertyLists);
        return "settings/index";
    }

    @GetMapping("/settings/edit")
    public String editForm(Model model){
        PropertyWrapper duProperty = new PropertyWrapper();
        duProperty.setProperties(propertyService.getAllDuProperty());
        model.addAttribute("duproperties", duProperty);
        return "settings/edit";
    }

    @GetMapping("/settings/editall")
    public String editAllForm(Model model){
        PropertyWrapper duProperty = new PropertyWrapper();
        duProperty.setProperties(propertyService.getAllNotDuProperty()); /*duProperty.getProperties().forEach(System.out::println);*/
        model.addAttribute("duproperties", duProperty);
        return "settings/editadvance";
    }

    @PostMapping("settings/update")
    public String update(@ModelAttribute("duproperties") PropertyWrapper duproperties,
                         final RedirectAttributes redirectAttributes){
        //System.out.println(duproperties.getProperties() != null ? duproperties.getProperties().size() : "null list");
        for(Property property : duproperties.getProperties()){
            if(propertyService.update(property) != null){
                redirectAttributes.addFlashAttribute("edit", "success");
            }else{
                redirectAttributes.addFlashAttribute("edit", "unsuccess");
            }
        }
        System.out.println("--");
        return "redirect:/settings";
    }

    @PostMapping("settings/updateall")
    public String updateAll(@ModelAttribute("duproperties") PropertyWrapper duproperties,
                         final RedirectAttributes redirectAttributes){
        //System.out.println(duproperties.getProperties() != null ? duproperties.getProperties().size() : "null list");
        for(Property property : duproperties.getProperties()){
            if(propertyService.update(property) != null){
                redirectAttributes.addFlashAttribute("edit", "success");
            }else{
                redirectAttributes.addFlashAttribute("edit", "unsuccess");
            }
        }
        return "redirect:/settings";
    }

    @GetMapping("settings/add")
    public String addForm(Model model){
        model.addAttribute("duproperties", new Property());
        return "settings/add";
    }

    @PostMapping("settings/create")
    public String save(Property property, final RedirectAttributes redirectAttributes){
        if (propertyService.insert(property) != null) {
            redirectAttributes.addFlashAttribute("save", "success");
        } else {
            redirectAttributes.addFlashAttribute("save", "unsuccess");
        }

        return "redirect:/settings";
    }
}
