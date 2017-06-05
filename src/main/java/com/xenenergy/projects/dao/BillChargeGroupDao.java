package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.BillChargeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 02/06/2017.
 */
@Repository
public interface BillChargeGroupDao extends JpaRepository<BillChargeGroup, Long>{
    List<BillChargeGroup> findByBillNo(String billno);
}
