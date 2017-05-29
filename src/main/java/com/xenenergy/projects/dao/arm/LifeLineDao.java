package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.LifeLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeLineDao extends PagingAndSortingRepository<LifeLine, Long> {
    Page<LifeLine> findAll(Pageable pageable);
}
