package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.LogDao;
import com.xenenergy.projects.entities.LogMsg;
import com.xenenergy.projects.services.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 10/25/2017.
 */
@Transactional
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public Page<LogMsg> findAllPageable(Pageable pageable) {
        return logDao.findAll(pageable);
    }

    @Override
    public LogMsg getById(long id) {
        return logDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        logDao.delete(id);
        return false;
    }

    @Override
    public LogMsg insert(LogMsg logMsg) {
        return logDao.save(logMsg);
    }

    @Override
    public LogMsg update(LogMsg logMsg) {
        return logDao.save(logMsg);
    }

    @Override
    public List<LogMsg> findAllByOrderById() {
        return logDao.findAllByOrderById();
    }
}
