package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.PerKwChargeDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/19/2017.
 */
@Repository
public interface PerKwChargeDetailDao extends JpaRepository<PerKwChargeDetail, Long> {
    List<PerKwChargeDetail> findByIdMasterOrderByPrintOrderAsc(long idMaster);

    @Query("select max(printOrder) from PerKwChargeDetail where idMaster = ?1")
    int findTopByPrintOrderOrderByPrintOrderDesc(long id);

    @Query("select sum(totalAmt) from PerKwChargeDetail where idMaster = ?1")
    double findSumOfTotalAmount(long id);
}
