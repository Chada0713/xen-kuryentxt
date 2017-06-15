package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Bills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 29/05/2017.
 */
@Transactional
public interface BillsService extends CRUDService<Bills> {
    int countBills(String dateFrom, String dateTo);
    List<Bills> getAllBills();
    Bills findByBillNo(String billno);
    @Query("select a from Bills a where a.oldAcctNo = ?1")
    List<Bills> findByOldAcctNo(String oldAcctNo);
}
