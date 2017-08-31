package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.CutoffDetailsDao;
import com.xenenergy.projects.entities.CutoffDetails;
import com.xenenergy.projects.services.interfaces.CutoffDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 29/08/2017.
 */
@Service
@Transactional
public class CutoffDetailsServiceImpl implements CutoffDetailsService {

    @Autowired
    private CutoffDetailsDao cutoffDetailsDao;

    @Override
    public Page<CutoffDetails> findAllPageable(Pageable pageable) {
        return cutoffDetailsDao.findAll(pageable);
    }

    @Override
    public CutoffDetails getById(long id) {
        return cutoffDetailsDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        cutoffDetailsDao.delete(id);
        return true;
    }

    @Override
    public CutoffDetails insert(CutoffDetails cutoffDetails) {
        return cutoffDetailsDao.save(cutoffDetails);
    }

    @Override
    public CutoffDetails update(CutoffDetails cutoffDetails) {
        return cutoffDetailsDao.save(cutoffDetails);
    }

    @Override
    public Page<CutoffDetails> findAllByIdCutOffMasterOrderByIdDesc(long id, Pageable pageable) {
        return cutoffDetailsDao.findAllByIdCutOffMasterOrderByIdDesc(id, pageable);
    }
}
