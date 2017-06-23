package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.ChargeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xenuser on 5/18/2017.
 */
@Repository
public interface ChargeTypeDao extends PagingAndSortingRepository<ChargeType, Long> {
    Page<ChargeType> findByIdRateMasterOrderByIdRateMasterAscPrintOrderAsc(long idRateMaster, Pageable pageable);
    List<ChargeType> findByIdRateMaster(long idRateMaster);
    @Query("select max(printOrder) from ChargeType where idRateMaster = ?1")
    Integer findTopByPrintOrderOrderByPrintOrderDesc(long id);
}
