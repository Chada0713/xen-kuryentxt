package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.MeterReaderDao;
import com.xenenergy.projects.entities.arm.Reader;
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
public class MeterReaderServiceImpl implements CRUDService<Reader> {

    @Autowired
    private MeterReaderDao meterReaderDao;

    @Override
    public Page<Reader> findAllPageable(Pageable pageable) {
        return meterReaderDao.findAll(pageable);
    }

    @Override
    public Reader getById(long id) {
        return meterReaderDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        meterReaderDao.delete(id);
        return true;
    }

    @Override
    public Reader insert(Reader reader) {
        return meterReaderDao.save(reader);
    }

    @Override
    public Reader update(Reader reader) {
        return meterReaderDao.save(reader);
    }
}
