package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.LifeLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LifeLineDao extends PagingAndSortingRepository<LifeLine, Long> {
    Page<LifeLine> findAll(Pageable pageable);
}
