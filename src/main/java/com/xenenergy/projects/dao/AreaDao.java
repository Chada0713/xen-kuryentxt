package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.DuArea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDao extends PagingAndSortingRepository<DuArea, Long> {
    /* Uncomment this if you want to display the record in desc order*/
    // Page<DuArea> findAllByOrderByIdDesc(Pageable pageable);
}
