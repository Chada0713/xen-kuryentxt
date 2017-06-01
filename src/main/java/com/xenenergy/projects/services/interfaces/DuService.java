package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Du;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface DuService extends CRUDService<Du> {
     List<Du> getDU();
}
