package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 26/05/2017.
 */
@Repository
public interface RoutesDao extends PagingAndSortingRepository<Route, Long> {
    Page<Route> findByIdAreaOrderByRouteName(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteCode(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteCodeDesc(long idArea, Pageable pageable);
    Page<Route> findByIdAreaOrderByRouteNameDesc(long idArea, Pageable pageable);
    List<Route> findAllByOrderById();

    @Query("select routeName from Route where id = ?1")
    String findRouteName(long id);
}
