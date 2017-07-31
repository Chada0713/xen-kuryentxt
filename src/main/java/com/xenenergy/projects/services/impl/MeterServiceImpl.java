package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.MeterDao;
import com.xenenergy.projects.entities.Meter;
import com.xenenergy.projects.services.interfaces.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 27/07/2017.
 */
@Service
@Transactional
public class MeterServiceImpl implements MeterService{

    @Autowired
    private MeterDao meterDao;

    @Override
    public Page<Meter> findAllPageable(Pageable pageable) {
        return meterDao.findAll(pageable);
    }

    @Override
    public Meter getById(long id) {
        return meterDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        meterDao.delete(id);
        return true;
    }

    @Override
    public Meter insert(Meter meter) {
        return meterDao.save(meter);
    }

    @Override
    public Meter update(Meter meter) {
        return meterDao.save(meter);
    }

    @Override
    public Page<Meter> findByIdRoute(long idRoute, Pageable pageable) {
        return meterDao.findByIdRoute(idRoute, pageable);
    }
}
