package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.FixedChargeDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 19/05/2017.
 */
@Repository
public interface FixedChargeDetailDao extends JpaRepository<FixedChargeDetail, Long> {
    List<FixedChargeDetail> findByIdMasterOrderByPrintOrder(long idMaster);

    @Query("select max(printOrder) from FixedChargeDetail where idMaster = ?1")
    Integer findTopByPrintOrderOrderByPrintOrderDesc(long id);

    @Query("select sum(amount) from FixedChargeDetail where idMaster = ?1")
    Double findSumOfAmount(long id);

    @Procedure(name = "spCopyFixChargeTemplate")
    void copyToTemplate(@Param("idMaster") long idMaster);
}
