package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.PerKwChargeMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xenuser on 5/18/2017.
 */
@Repository
public interface PerKwChargeMasterDao extends PagingAndSortingRepository<PerKwChargeMaster, Long>{
    Page<PerKwChargeMaster> findByIdRateMasterOrderByIdDesc(long idRateMaster, Pageable pageable);
}
