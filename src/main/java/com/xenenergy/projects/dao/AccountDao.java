package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    //Account findByOldAccountNo(String oldAccountNo);

    @Query("select a from Account a where a.oldAccountNo = ?1")
    Account findByOldAccountNo(String oldAccountNo);
}
