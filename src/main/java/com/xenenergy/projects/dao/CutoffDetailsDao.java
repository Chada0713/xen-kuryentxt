package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.CutoffDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 29/08/2017.
 */
@Repository
public interface CutoffDetailsDao extends PagingAndSortingRepository<CutoffDetails, Long> {
    Page<CutoffDetails> findAllByIdCutOffMasterOrderByIdDesc(long id, Pageable pageable);
}
