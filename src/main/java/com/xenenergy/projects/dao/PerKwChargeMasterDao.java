package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.PerKwChargeMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * Created by xenuser on 5/18/2017.
 */
@Repository
public interface PerKwChargeMasterDao extends PagingAndSortingRepository<PerKwChargeMaster, Long>{
    Page<PerKwChargeMaster> findByIdRateMasterOrderByIdDesc(long idRateMaster, Pageable pageable);

    @Procedure(name = "spDuplicateRate")
    void duplicateRate(@Param("id") int id,@Param("idRateMaster") int idRateMaster,@Param("effectivityDate") Date effectivityDate);
}
