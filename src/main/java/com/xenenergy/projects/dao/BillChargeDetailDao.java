package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.BillChargeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 02/06/2017.
 */
@Repository
public interface BillChargeDetailDao extends JpaRepository<BillChargeDetail, Long>{
    List<BillChargeDetail> findByPrintOrderMasterAndBillNo(int printOrderMaster, String bill_no);
}
