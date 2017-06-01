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

    List<Account> findByIdRoute(long idRoute);

    @Query("select count(id) from Account where isSeniorCitizen = 'Y'")
    int findCountOfSenior();

    @Query("select count(id) from Account")
    int findCountOfId();

    @Query("select a from Account a where a.idRoute = ?1 and a.seqNo >= ?2 and a.seqNo <= ?3 and (a.seqNo like %?5%)")
    Page<Account> findByRouteCodeSeqNo(long routeCode, int startSeq, int endSeq, String searchStr, int searchInt, Pageable pageable);
}
