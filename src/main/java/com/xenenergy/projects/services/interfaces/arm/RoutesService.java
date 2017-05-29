package com.xenenergy.projects.services.interfaces.arm;

import com.xenenergy.projects.entities.arm.Route;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
public interface RoutesService extends CRUDService<Route> {
    Page<Route> findByIdArea(long idArea, Pageable pageable);
}
