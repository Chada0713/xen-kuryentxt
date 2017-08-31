package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.CutoffMaster;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface CutoffMasterService extends CRUDService<CutoffMaster> {
    List<Integer> getDays();
    CutoffMaster findAllByIdOrderByIdDesc(long id);
}
