package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.CutoffMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CutoffMasterDao extends PagingAndSortingRepository<CutoffMaster, Long> {
    /*Uncomment this if you want to display record in desc order*/
    Page<CutoffMaster> findAllByOrderByIdDesc(Pageable pageable);
}
