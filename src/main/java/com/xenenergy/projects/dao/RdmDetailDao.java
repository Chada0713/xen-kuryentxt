package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.RdmDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 22/05/2017.
 */
@Repository
public interface RdmDetailDao extends PagingAndSortingRepository<RdmDetail, Long>{
    Page<RdmDetail> findByIdRdm(long idRdm, Pageable pageable);
    List<RdmDetail> findAllByIdRdm(long idRdm);
}
