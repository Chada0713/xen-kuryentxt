package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.CutoffMaster;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface CutoffMasterService extends CRUDService<CutoffMaster> {
    List<Integer> getDays();
}
