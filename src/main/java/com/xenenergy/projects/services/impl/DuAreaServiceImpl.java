package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.AreaDao;
import com.xenenergy.projects.entities.DuArea;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DuAreaServiceImpl implements CRUDService<DuArea> {

    @Autowired
    private AreaDao areaDao;


    @Override
    public Page<DuArea> findAllPageable(Pageable pageable) {
        return areaDao.findAll(pageable);
    }

    @Override
    public DuArea getById(long id) {
        return areaDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        areaDao.delete(id);
        return true;
    }

    @Override
    public DuArea insert(DuArea area) {
        return areaDao.save(area);
    }

    @Override
    public DuArea update(DuArea area) {
        return areaDao.save(area);
    }
}
