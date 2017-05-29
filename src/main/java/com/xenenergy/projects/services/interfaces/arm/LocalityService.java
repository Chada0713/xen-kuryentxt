package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Locality;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface LocalityService extends CRUDService<Locality> {
    Page<Locality> findAllByIdArea(long id, Pageable pageable);
}
