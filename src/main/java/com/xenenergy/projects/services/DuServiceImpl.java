package com.xenenergy.projects.services;

import com.xenenergy.projects.dao.DuDao;
import com.xenenergy.projects.entities.Du;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xenuser on 5/17/2017.
 */
@Service
@Transactional
public class DuServiceImpl {
    @Autowired
    private DuDao duDao;

    public List<Du> getDU() {
        return duDao.findAll();

    }
}
