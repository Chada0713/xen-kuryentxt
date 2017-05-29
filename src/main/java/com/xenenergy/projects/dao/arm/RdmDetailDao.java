package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.RdmDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 22/05/2017.
 */
@Repository
public interface RdmDetailDao extends PagingAndSortingRepository<RdmDetail, Long>{
    Page<RdmDetail> findByIdRdm(long idRdm, Pageable pageable);
}
