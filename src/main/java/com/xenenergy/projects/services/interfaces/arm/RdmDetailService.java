package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.RdmDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface RdmDetailService extends CRUDService<RdmDetail> {
    Page<RdmDetail> findAllByIdRdm(long idRdm, Pageable pageable);
}
