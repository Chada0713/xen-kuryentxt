package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.CorelossDao;
import com.xenenergy.projects.entities.Coreloss;
import com.xenenergy.projects.services.interfaces.CorelossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 16/05/2017.
 */
@Service
@Transactional
public class CorelossServiceImpl implements CorelossService {

    @Autowired
    private CorelossDao corelossDao;

    @Autowired
    public List<Coreloss> getAllRecords(){
        return corelossDao.findAll();
    }

    @Override
    public Page<Coreloss> findAllPageable(Pageable pageable) {
        return corelossDao.findAll(pageable);
    }

    @Override
    public Coreloss getById(long id) {
        return corelossDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        corelossDao.delete(id);
        return true;
    }

    @Override
    public Coreloss insert(Coreloss coreloss) {
        return corelossDao.save(coreloss);
    }

    @Override
    public Coreloss update(Coreloss coreloss) {
        return corelossDao.save(coreloss);
    }


}
