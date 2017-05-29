package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.arm.RoutesDao;
import com.xenenergy.projects.entities.arm.Route;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 26/05/2017.
 */
@Service
@Transactional
public class RoutesServiceImpl implements CRUDService<Route> {
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

    public Page<Route> findByIdArea(long idArea, Pageable pageable){
        return routesDao.findByIdAreaOrderByRouteName(idArea, pageable);
    }
}
