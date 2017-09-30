package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */

public interface AccountService extends CRUDService<Account> {
    List<Account> getAllAccounts();

    Account getByOldAccountNo(String oldAccountNo);

    Account getByAccountNo(String accountNo);

    List<Account> findByIdRoute(long idRoute);

    int findCountOfSenior();

    int findCountOfId();

    Page<Account> findByRouteCodeSeqNo(long routeCode, int startSeq, int endSeq, String searchStr, Pageable pageable);

    int countByIdRoute(long idRoute);
}

