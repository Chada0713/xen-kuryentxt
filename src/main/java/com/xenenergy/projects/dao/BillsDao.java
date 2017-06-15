package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 17/05/2017.
 */
@Repository
public interface BillsDao extends JpaRepository<Bills, Long>{
    @Query("select count(a) from Bills a where a.runDate BETWEEN ?1 AND ?2")
    int countByRunDateBetween(String dateFrom, String dateTo);
    Bills findByBillNo(String billno);
    @Query("select a from Bills a where a.oldAcctNo = ?1")
    List<Bills> findByOldAcctNo(String oldAcctNo);
}
