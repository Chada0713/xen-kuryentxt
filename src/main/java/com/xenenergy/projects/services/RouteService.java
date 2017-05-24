package com.xenenergy.projects.services;

import com.xenenergy.projects.dao.dependence.RouteDao;
import com.xenenergy.projects.entities.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xesi on 23/05/2017.
 */
@Service
public class RouteService {

    @Autowired
    private RouteDao routeDao;

    public Collection<Route> getAll() {
        List<Route> routeEntities = new ArrayList<>();
        routeDao.findAll().forEach(routeEntities::add);
        return routeEntities;
    }

    public boolean deleteById(long id) {
        routeDao.delete(id);
        return true;
    }

    public Route insert(Route route) {
        return routeDao.save(route);
    }

    public Route getById(long id) {
        return routeDao.findOne(id);
    }

    public Route update(Route route) {
        return routeDao.save(route);
    }

    public List<Route> findByIdArea(long idArea) {
        return routeDao.findByIdArea(idArea);
    }
}
