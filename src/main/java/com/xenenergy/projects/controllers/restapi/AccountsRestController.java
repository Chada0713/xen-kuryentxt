package com.xenenergy.projects.controllers.restapi;

import com.xenenergy.projects.entities.Account;
import com.xenenergy.projects.services.impl.AccountServiceImpl;
import com.xenenergy.projects.services.interfaces.AccountService;
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
    public Account getByAccountNo(@RequestParam("oldaccountno") String oldAccountNo){
        return accountService.getByOldAccountNo(oldAccountNo);
    }

    @GetMapping("/byaccountno")
    public Account getByAccount_No(@RequestParam("accountno") String accountNo){
        return accountService.getByAccountNo(accountNo);
    }

    @GetMapping("/viewaccounts/{idRoute}")
    public List<Account> findAccountsByIdRoute(@PathVariable("idRoute") long idRoute){
        return accountService.findByIdRoute(idRoute);
    }
}
