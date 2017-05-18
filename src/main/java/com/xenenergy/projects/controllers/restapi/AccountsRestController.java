package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Account;
import com.xenenergy.projects.services.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xenuser on 5/16/2017.
 */
@RestController
@RequestMapping("api/accounts")
public class AccountsRestController {

    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") long id) {
        return accountService.getById(id);
    }
}
