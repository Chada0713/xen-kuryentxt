package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.BillAddOnCharge;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 13/06/2017.
 */
@Repository
public interface BillAddOnChargeDao extends PagingAndSortingRepository<BillAddOnCharge, Long>{
    List<BillAddOnCharge> findByBillNo(String billNo);
}
