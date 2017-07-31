package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Meter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 27/07/2017.
 */
@Repository
public interface MeterDao extends PagingAndSortingRepository<Meter, Long> {
    Page<Meter> findByIdRoute(long idRoute, Pageable pageable);
}
