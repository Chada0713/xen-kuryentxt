package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Account;
import com.xenenergy.projects.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xenuser on 5/16/2017.
 */
@RestController
@RequestMapping("api")
public class AccountsRestController {

    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") long id) {
        return accountService.getById(id);
    }

   @GetMapping("/account")
    public Account getAccountByAccountNo(@RequestParam("oldaccountno") String oldAccountNo){
        return accountService.getByAccountNo(oldAccountNo);
    }
}
