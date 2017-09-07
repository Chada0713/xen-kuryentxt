package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.RoutesDao;
import com.xenenergy.projects.entities.Route;
import com.xenenergy.projects.services.interfaces.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 26/05/2017.
 */
@Service
@Transactional
public class RoutesServiceImpl implements RoutesService {
    @Autowired
    private RoutesDao routesDao;


    @Override
    public Page<Route> findAllPageable(Pageable pageable) {
        return routesDao.findAll(pageable);
    }

    @Override
    public Route getById(long id) {
        return routesDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        routesDao.delete(id);
        return true;
    }

    @Override
    public Route insert(Route route) {
        return routesDao.save(route);
    }

    @Override
    public Route update(Route route) {
        return routesDao.save(route);
    }

    @Override
    public Page<Route> findByIdArea(long idArea, Pageable pageable){
        return routesDao.findByIdAreaOrderByRouteName(idArea, pageable);
    }

    @Override
    public Page<Route> findByIdAreaOrderByRouteCode(long idArea, Pageable pageable) {
        return routesDao.findByIdAreaOrderByRouteCode(idArea, pageable);
    }

    @Override
    public Page<Route> findByIdAreaOrderByRouteCodeDesc(long idArea, Pageable pageable) {
        return routesDao.findByIdAreaOrderByRouteCodeDesc(idArea, pageable);
    }

    @Override
    public Page<Route> findByIdAreaOrderByRouteName(long idArea, Pageable pageable) {
        return routesDao.findByIdAreaOrderByRouteName(idArea, pageable);
    }

    @Override
    public Page<Route> findByIdAreaOrderByRouteNameDesc(long idArea, Pageable pageable) {
        return routesDao.findByIdAreaOrderByRouteNameDesc(idArea, pageable);
    }

    @Override
    public List<Route> findAllByOrderById() {
        return routesDao.findAllByOrderById();
    }

    @Override
    public String findRouteName(long id) {
        return routesDao.findRouteName(id);
    }
}
