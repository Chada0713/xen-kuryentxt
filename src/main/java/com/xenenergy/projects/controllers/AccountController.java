package com.xenenergy.projects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by xenuser on 5/9/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAccounts(){
        return "accounts/index";
    }
}
