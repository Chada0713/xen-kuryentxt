package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.Locality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xenuser on 5/15/2017.
 */
@Repository
public interface LocalityDao extends PagingAndSortingRepository<Locality, Long> {
    Page<Locality> findByIdArea(long idArea, Pageable pageable);
}
