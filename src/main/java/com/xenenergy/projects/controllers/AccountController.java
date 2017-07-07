package com.xenenergy.projects.controllers;

import com.xenenergy.projects.entities.Bills;
import com.xenenergy.projects.services.interfaces.AccountService;
import com.xenenergy.projects.services.interfaces.BillsService;
import com.xenenergy.projects.services.interfaces.PropertyService;
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

    @Autowired
    private PropertyService propertyService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String getAccounts(){
        return "accounts/index";
    }

    @RequestMapping(value = "/accounts/account/{accountno}", method = RequestMethod.GET)
    public String showAccount(Model model, @PathVariable("accountno") String accountno){
        //System.out.println("Old Account No >>> " + accountService.getByAccountNo(accountno).getOldAccountNo());
        List<Bills> billsList = billsService.findByOldAcctNo(accountService.getByAccountNo(accountno).getOldAccountNo());

        String[] du = new String[7];
        if(propertyService.findByPropertyName("DU_CODE") != null){
            du[0] = propertyService.findByPropertyName("DU_CODE").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_NAME") != null){
            du[1] = propertyService.findByPropertyName("DU_NAME").getPropertyValue();
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN1") != null){
            du[2] = propertyService.findByPropertyName("DU_ADDRESSLN1").getPropertyValue();
        }else{
            du[2] = "";
        }
        if(propertyService.findByPropertyName("DU_ADDRESSLN2") != null){
            du[3] = propertyService.findByPropertyName("DU_ADDRESSLN2").getPropertyValue();
        }else{
            du[3] = "";
        }
        if(propertyService.findByPropertyName("DU_VAT_NO") != null){
            du[4] = propertyService.findByPropertyName("DU_VAT_NO").getPropertyValue();
        }

        model.addAttribute("account", accountService.getByAccountNo(accountno));
        model.addAttribute("bills", billsList);
        model.addAttribute("du", du);
        return "accounts/account";
    }
}
