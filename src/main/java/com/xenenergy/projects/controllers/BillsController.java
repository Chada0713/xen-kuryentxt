package com.xenenergy.projects.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by xesi on 17/05/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/bills")
public class BillsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getBills(){
        return "bills/index";
    }
}
