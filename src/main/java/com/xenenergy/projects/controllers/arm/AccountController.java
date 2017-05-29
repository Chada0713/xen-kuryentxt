package com.xenenergy.projects.controllers.arm;

import com.xenenergy.projects.services.interfaces.arm.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xenuser on 5/9/2017.
 */
@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAccounts(){
        return "accounts/index";
    }
}
