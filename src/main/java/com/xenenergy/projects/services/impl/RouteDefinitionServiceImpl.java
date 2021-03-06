package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.RouteDefinitionDao;
import com.xenenergy.projects.entities.Rdm;
import com.xenenergy.projects.services.interfaces.RouteDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RouteDefinitionServiceImpl implements RouteDefinitionService {

    @Autowired
    private RouteDefinitionDao routeDefinitionDao;

    @Override
    public Page<Rdm> findAllPageable(Pageable pageable) {
        return routeDefinitionDao.findAll(pageable);
    }

    @Override
    public Rdm getById(long id) {
        return routeDefinitionDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        routeDefinitionDao.delete(id);
        return true;
    }

    @Override
    public Rdm insert(Rdm rdm) {
        return routeDefinitionDao.save(rdm);
    }

    @Override
    public Rdm update(Rdm rdm) {
        return routeDefinitionDao.save(rdm);
    }


    @Override
    public Page<Rdm> findAllByOrderByIdDesc(Pageable pageable) {
        return routeDefinitionDao.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public Page<Rdm> findByRdmNameOrIdContaining(String value, Pageable pageable) {
        return routeDefinitionDao.findByRdmNameOrIdContainingOrderByIdDesc(value, pageable);
    }

}
