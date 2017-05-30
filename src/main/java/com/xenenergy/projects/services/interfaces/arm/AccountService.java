package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Account;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface AccountService extends CRUDService<Account> {
    List<Account> getAllAccounts();
    Account getByOldAccountNo(String oldAccountNo);
}
