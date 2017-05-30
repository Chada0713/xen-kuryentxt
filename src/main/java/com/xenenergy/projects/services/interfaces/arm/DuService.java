package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Du;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface DuService extends CRUDService<Du> {
     List<Du> getDU();
}
