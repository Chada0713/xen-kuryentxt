package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.PerKwChargeMaster;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by xesi on 29/05/2017.
 */
public interface PerKwChargeMasterService extends CRUDService<PerKwChargeMaster> {
    Page<PerKwChargeMaster> findAllByIdRateMaster(long id, Pageable pageable);
}
