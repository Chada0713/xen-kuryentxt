package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.SeniorCitizenDao;
import com.xenenergy.projects.entities.SeniorCitizen;
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
public class SeniorCitizenServiceImpl implements CRUDService<SeniorCitizen> {

    @Autowired
    private SeniorCitizenDao seniorCitizenDao;

    @Override
    public Page<SeniorCitizen> findAllPageable(Pageable pageable) {
        return seniorCitizenDao.findAll(pageable);
    }

    @Override
    public SeniorCitizen getById(long id) {
        return seniorCitizenDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        seniorCitizenDao.delete(id);
        return true;
    }

    @Override
    public SeniorCitizen insert(SeniorCitizen seniorCitizen) {
        return seniorCitizenDao.save(seniorCitizen);
    }

    @Override
    public SeniorCitizen update(SeniorCitizen seniorCitizen) {
        return seniorCitizenDao.save(seniorCitizen);
    }


}
