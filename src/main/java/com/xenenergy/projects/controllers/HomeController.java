package com.xenenergy.projects.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Optional;

/**
 * Created by xenuser on 5/18/2017.
 */
@Controller
@SessionAttributes(value = {"caller"}) //, "ducode"
@RequestMapping("/")
public class HomeController {

    /*@Value("${kuryentxt.du-code}")
    private String ducode;*/

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @RequestParam Optional<String> caller) {
        if (caller.isPresent()) {
            model.addAttribute("caller", caller.get());
        }
        //model.addAttribute("ducode", ducode);
        return "index";
    }
}
