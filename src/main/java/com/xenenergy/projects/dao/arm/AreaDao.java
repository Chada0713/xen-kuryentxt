package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.DuArea;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDao extends PagingAndSortingRepository<DuArea, Long> {
    /* Uncomment this if you want to display the record in desc order*/
    // Page<DuArea> findAllByOrderByIdDesc(Pageable pageable);
}
