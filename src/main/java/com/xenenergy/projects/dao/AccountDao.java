package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    Account findByOldAccountNo(String oldAccountNo);
    Account findByAccountNo(String accountNo);
    List<Account> findByIdRoute(long idRoute);

    @Query("select count(id) from Account where isSeniorCitizen = 'Y'")
    int findCountOfSenior();

    @Query("select count(id) from Account")
    int findCountOfId();

    @Query("select a from Account a where a.idRoute = ?1 and a.seqNo >= ?2 and a.seqNo <= ?3 and (cast(a.seqNo as string) like %?4% or a.accountName like %?4%)")
    Page<Account> findByRouteCodeSeqNo(long routeCode, int startSeq, int endSeq, String searchStr, Pageable pageable);

}
