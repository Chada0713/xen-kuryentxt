package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface RoutesService extends CRUDService<Route> {
    Route getById(long idArea);
    Page<Route> findByIdArea(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteCode(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteCodeDesc(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteName(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteNameDesc(long idArea, Pageable pageable);
    List<Route> findAllByOrderById();

    @Query("select routeName from Route where id = ?1")
    String findRouteName(long id);
}
