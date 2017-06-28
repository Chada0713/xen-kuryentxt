package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.PerKwChargeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/19/2017.
 */
@Repository
public interface PerKwChargeDetailDao extends JpaRepository<PerKwChargeDetail, Long> {
    List<PerKwChargeDetail> findByIdMasterOrderByPrintOrderAsc(long idMaster);

    @Query("select max(printOrder) from PerKwChargeDetail where idMaster = ?1")
    Integer findTopByPrintOrderOrderByPrintOrderDesc(long id);

    @Query("select sum(totalAmt) from PerKwChargeDetail where idMaster = ?1")
    Double findSumOfTotalAmount(long id);

    @Procedure(name = "spCopyPerKWChargeTemplate")
    void copyToTemplate(@Param("idMaster") long idMaster);

    @Modifying
    @Query("delete from PerKwChargeDetail a where a.idMaster = ?1")
    void deleteByIdMaster(long idMaster);

}
