package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Bills;
import com.xenenergy.projects.services.interfaces.AccountService;
import com.xenenergy.projects.services.interfaces.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xenuser on 5/9/2017.
 */
@Controller
@SessionAttributes("caller")
@RequestMapping("")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BillsService billsService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String getAccounts(){
        return "accounts/index";
    }

    @RequestMapping(value = "/accounts/account/{accountno}", method = RequestMethod.GET)
    public String showAccount(Model model, @PathVariable("accountno") String accountno){
        //System.out.println("Old Account No >>> " + accountService.getByAccountNo(accountno).getOldAccountNo());
        List<Bills> billsList = billsService.findByOldAcctNo(accountService.getByAccountNo(accountno).getOldAccountNo());
        model.addAttribute("account", accountService.getByAccountNo(accountno));
        model.addAttribute("bills", billsList);
        return "accounts/account";
    }
}
