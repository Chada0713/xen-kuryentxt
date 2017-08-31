package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.CutoffMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CutoffMasterDao extends PagingAndSortingRepository<CutoffMaster, Long> {
    /*Uncomment this if you want to display record in desc order*/
    Page<CutoffMaster> findAllByOrderByIdDesc(Pageable pageable);
    CutoffMaster findAllByIdOrderById(long id);
}
