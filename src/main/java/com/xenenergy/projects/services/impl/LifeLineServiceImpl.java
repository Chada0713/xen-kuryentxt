package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.LifeLineDao;
import com.xenenergy.projects.entities.LifeLine;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LifeLineServiceImpl implements CRUDService<LifeLine> {

    @Autowired
    private LifeLineDao lifeLineDao;

    @Override
    public Page<LifeLine> findAllPageable(Pageable pageable) {
        return lifeLineDao.findAll(pageable);
    }

    @Override
    public LifeLine getById(long id) {
        return lifeLineDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        lifeLineDao.delete(id);
        return true;
    }

    @Override
    public LifeLine insert(LifeLine lifeLine) {
        return lifeLineDao.save(lifeLine);
    }

    @Override
    public LifeLine update(LifeLine lifeLine) {
        return lifeLineDao.save(lifeLine);
    }
}
