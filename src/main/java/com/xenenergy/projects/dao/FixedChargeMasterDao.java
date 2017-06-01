package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.FixedChargeMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 18/05/2017.
 */
@Repository
public interface FixedChargeMasterDao extends PagingAndSortingRepository<FixedChargeMaster, Long>{
    Page<FixedChargeMaster> findByIdRateMasterOrderByIdDesc(long idRateMaster, Pageable pageable);
}
