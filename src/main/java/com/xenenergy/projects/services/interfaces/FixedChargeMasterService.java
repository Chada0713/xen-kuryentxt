package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.FixedChargeMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface FixedChargeMasterService extends CRUDService<FixedChargeMaster> {
    Page<FixedChargeMaster> findAllByIdRateMaster(long idRateMaster, Pageable pageable);
}
