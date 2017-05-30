package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Account;
import com.xenenergy.projects.services.interfaces.CRUDService;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface AccountService extends CRUDService<Account> {
    List<Account> getAllAccounts();
    Account getByOldAccountNo(String oldAccountNo);
}
