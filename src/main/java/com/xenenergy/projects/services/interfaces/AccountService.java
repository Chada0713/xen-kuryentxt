package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */

public interface AccountService extends CRUDService<Account> {
    List<Account> getAllAccounts();

    Account getByOldAccountNo(String oldAccountNo);

    List<Account> findByIdRoute(long idRoute);

    Page<Account> findByIdRoute(long idRoute, Pageable pageable);
}
