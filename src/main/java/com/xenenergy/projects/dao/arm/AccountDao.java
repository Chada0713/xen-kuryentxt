package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
    Account findByOldAccountNo(String oldAccountNo);
    List<Account> findByIdRoute(long idRoute);

    /*@Query("select a, b.areaCode from Account a, DuArea b where a.oldAccountNo = ?1 and a.idArea = b.id")
    Account findByOldAccountNo(String oldAccountNo);*/
}
