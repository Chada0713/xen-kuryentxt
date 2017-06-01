package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.DuArea;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface DuAreaService extends CRUDService<DuArea> {
    Collection<DuArea> getAll();
}
