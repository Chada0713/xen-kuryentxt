package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.PerKwChargeMaster;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 29/05/2017.
 */
@Transactional
public interface PerKwChargeMasterService extends CRUDService<PerKwChargeMaster> {
    Page<PerKwChargeMaster> findAllByIdRateMaster(long id, Pageable pageable);
}
