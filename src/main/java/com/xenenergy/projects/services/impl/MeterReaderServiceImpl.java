package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.MeterReaderDao;
import com.xenenergy.projects.entities.MeterReader;
import com.xenenergy.projects.services.interfaces.MeterReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xenuser on 5/11/2017.
 */

@Service
@Transactional
public class MeterReaderServiceImpl implements MeterReaderService {

    @Autowired
    private MeterReaderDao meterReaderDao;

    @Override
    public Page<MeterReader> findAllPageable(Pageable pageable) {
        return meterReaderDao.findAll(pageable);
    }

    @Override
    public MeterReader getById(long id) {
        return meterReaderDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        meterReaderDao.delete(id);
        return true;
    }

    @Override
    public MeterReader insert(MeterReader reader) {
        return meterReaderDao.save(reader);
    }

    @Override
    public MeterReader update(MeterReader reader) {
        return meterReaderDao.save(reader);
    }

    @Override
    public List<MeterReader> findAll() {
        return meterReaderDao.findAll();
    }
}
