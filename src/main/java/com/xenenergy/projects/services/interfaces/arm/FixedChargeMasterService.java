package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.FixedChargeMaster;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface FixedChargeMasterService extends CRUDService<FixedChargeMaster> {
    Page<FixedChargeMaster> findAllByIdRateMaster(long idRateMaster, Pageable pageable);
}
