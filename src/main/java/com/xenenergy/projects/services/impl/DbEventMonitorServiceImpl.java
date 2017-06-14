package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.DbEventMonitorDao;
import com.xenenergy.projects.entities.DbEventMonitor;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.DbEventMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 13/06/2017.
 */
@Service
@Transactional
public class DbEventMonitorServiceImpl implements DbEventMonitorService{

    @Autowired
    DbEventMonitorDao dbEventMonitorDao;


    @Override
    public Page<DbEventMonitor> findAllPageable(Pageable pageable) {
        return dbEventMonitorDao.findAll(pageable);
    }

    @Override
    public DbEventMonitor getById(long id) {
        return dbEventMonitorDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        dbEventMonitorDao.delete(id);
        return true;
    }

    @Override
    public DbEventMonitor insert(DbEventMonitor dbEventMonitor) {
        return dbEventMonitorDao.save(dbEventMonitor);
    }

    @Override
    public DbEventMonitor update(DbEventMonitor dbEventMonitor) {
        return dbEventMonitorDao.save(dbEventMonitor);
    }
}
