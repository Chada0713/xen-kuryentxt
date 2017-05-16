package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.PropertyDao;
import com.xenenergy.projects.entities.Property;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by xenuser on 5/4/2017.
 */
@Service
public class PropertyServiceImpl implements CRUDService<Property> {

    @Autowired
    private PropertyDao propertyDao;

    @Override
    public Page<Property> findAllPageable(Pageable pageable) {
        return propertyDao.findAll(pageable);
    }

    @Override
    public Property getById(long id) {
        return propertyDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        propertyDao.delete(id);
        return true;
    }

    @Override
    public Property insert(Property area) {
        return propertyDao.save(area);
    }

    @Override
    public Property update(Property area) {
        return propertyDao.save(area);
    }

}
