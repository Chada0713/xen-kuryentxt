package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.RateMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 15/05/2017.
 */
@Repository
public interface RateMasterDao extends PagingAndSortingRepository<RateMaster, Long> {
    Page<RateMaster> findAllByOrderByIdDesc(Pageable pageable);
}
