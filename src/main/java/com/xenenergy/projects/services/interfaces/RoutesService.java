package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface RoutesService extends CRUDService<Route> {
    Page<Route> findByIdArea(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteCode(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteCodeDesc(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteName(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteNameDesc(long idArea, Pageable pageable);
}
