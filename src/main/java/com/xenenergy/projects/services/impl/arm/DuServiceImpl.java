package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.DuDao;
import com.xenenergy.projects.entities.arm.Du;
import com.xenenergy.projects.services.interfaces.arm.DuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xenuser on 5/17/2017.
 */
@Service
@Transactional
public class DuServiceImpl implements DuService {
    @Autowired
    private DuDao duDao;

    public List<Du> getDU() {
        return duDao.findAll();

    }

    @Override
    public Page<Du> findAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Du getById(long id) {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Du insert(Du du) {
        return null;
    }

    @Override
    public Du update(Du du) {
        return null;
    }
}
