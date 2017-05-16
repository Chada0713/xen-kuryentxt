package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.AddOnKwhDao;
import com.xenenergy.projects.entities.AddOnKwh;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 16/05/2017.
 */
@Service
@Transactional
public class AddOnKwhServiceImpl implements CRUDService<AddOnKwh>{

    @Autowired
    AddOnKwhDao addOnKwhDao;

    @Override
    public Page<AddOnKwh> findAllPageable(Pageable pageable) {
        return addOnKwhDao.findAll(pageable);
    }

    @Override
    public AddOnKwh getById(long id) {
        return addOnKwhDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        addOnKwhDao.delete(id);
        return true;
    }

    @Override
    public AddOnKwh insert(AddOnKwh addOnKwh) {
        return addOnKwhDao.save(addOnKwh);
    }

    @Override
    public AddOnKwh update(AddOnKwh addOnKwh) {
        return addOnKwhDao.save(addOnKwh);
    }
}
