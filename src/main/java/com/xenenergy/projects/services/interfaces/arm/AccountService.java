package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Account;
import com.xenenergy.projects.entities.arm.ActivationCode;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface AccountService extends CRUDService<Account> {
    List<Account> getAllAccounts();

    Object getByAccountNo(String oldAccountNo);
}
