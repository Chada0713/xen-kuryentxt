package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.LocalityDao;
import com.xenenergy.projects.entities.arm.Locality;
import com.xenenergy.projects.services.interfaces.arm.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xenuser on 5/15/2017.
 */
@Service
@Transactional
public class LocalityServiceImpl implements LocalityService {

    @Autowired
    private LocalityDao localityDao;

    @Override
    public Page<Locality> findAllPageable(Pageable pageable) {
        return localityDao.findAll(pageable);
    }

    @Override
    public Locality getById(long id) {
        return localityDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        localityDao.delete(id);
        return true;
    }

    @Override
    public Locality insert(Locality locality) {
        return localityDao.save(locality);
    }

    @Override
    public Locality update(Locality locality) {
        return localityDao.save(locality);
    }

    @Override
    public Page<Locality> findAllByIdArea(long id, Pageable pageable) {
        return localityDao.findByIdArea(id, pageable);
    }
}
