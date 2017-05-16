package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Account;
import com.xenenergy.projects.entities.Pager;
import com.xenenergy.projects.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

/**
 * Created by xenuser on 5/9/2017.
 */
@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAccounts(){
        return "accounts/index";
    }
}
