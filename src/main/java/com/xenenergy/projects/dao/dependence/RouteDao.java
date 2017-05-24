package com.xenenergy.projects.dao.dependence;

import com.xenenergy.projects.entities.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 23/05/2017.
 */
@Transactional
public interface RouteDao extends CrudRepository<Route, Long>{
    List<Route> findByIdArea(long idArea);
}
