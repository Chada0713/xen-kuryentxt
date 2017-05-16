package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.RemarksDao;
import com.xenenergy.projects.entities.Remarks;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xenuser on 5/11/2017.
 */
@Service
@Transactional
public class RemarksServiceImpl implements CRUDService<Remarks> {

    @Autowired
    private RemarksDao remarksDao;

    @Override
    public Page<Remarks> findAllPageable(Pageable pageable) {
        return remarksDao.findAll(pageable);
    }

    @Override
    public Remarks getById(long id) {
        return remarksDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        remarksDao.delete(id);
        return true;
    }

    @Override
    public Remarks insert(Remarks remarks) {
        return remarksDao.save(remarks);
    }

    @Override
    public Remarks update(Remarks remarks) {
        return remarksDao.save(remarks);
    }
}
