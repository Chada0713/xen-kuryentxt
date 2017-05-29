package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.DuArea;
import com.xenenergy.projects.services.interfaces.CRUDService;

import java.util.Collection;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface DuAreaService extends CRUDService<DuArea> {
    Collection<DuArea> getAll();
}
