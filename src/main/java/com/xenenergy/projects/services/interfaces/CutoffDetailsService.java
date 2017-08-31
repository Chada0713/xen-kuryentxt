package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.CutoffDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 29/08/2017.
 */
@Transactional
public interface CutoffDetailsService extends CRUDService<CutoffDetails>{
    Page<CutoffDetails> findAllByIdCutOffMasterOrderByIdDesc(long id, Pageable pageable);
}
