package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.PropertyDao;
import com.xenenergy.projects.entities.Property;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xenuser on 5/4/2017.
 */
@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

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

    @Override
    public Property findByPropertyName(String propertyName) {
        return propertyDao.findByPropertyName(propertyName);
    }

    @Override
    public List<Property> findAllByOrderByIdDesc() {
        return propertyDao.findAllByOrderByIdDesc();
    }

    @Override
    public List<Property> findAllByOrderById() {
        return propertyDao.findAllByOrderById();
    }

    @Override
    public Property updatePropertyValue(String propertyValue, long id) {
        return propertyDao.updatePropertyValue(propertyValue, id);
    }

    @Override
    public List<Property> getAllDuProperty() {
        return propertyDao.getAllDuProperty();
    }
}
