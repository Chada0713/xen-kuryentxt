package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.FixedChargeMasterDao;
import com.xenenergy.projects.entities.FixedChargeMaster;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 18/05/2017.
 */
@Service
@Transactional
public class FixedChargeMasterServiceImpl implements CRUDService<FixedChargeMaster>{

    @Autowired
    private FixedChargeMasterDao fixedChargeMasterDao;


    @Override
    public Page<FixedChargeMaster> findAllPageable(Pageable pageable) {
        return fixedChargeMasterDao.findAll(pageable);
    }

    @Override
    public FixedChargeMaster getById(long id) {
        return fixedChargeMasterDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        fixedChargeMasterDao.delete(id);
        return true;
    }

    @Override
    public FixedChargeMaster insert(FixedChargeMaster fixedChargeMaster) {
        return fixedChargeMasterDao.save(fixedChargeMaster);
    }

    @Override
    public FixedChargeMaster update(FixedChargeMaster fixedChargeMaster) {
        return fixedChargeMasterDao.save(fixedChargeMaster);
    }

    public Page<FixedChargeMaster> findAllByIdRateMaster(long idRateMaster, Pageable pageable){
        return fixedChargeMasterDao.findByIdRateMasterOrderByIdDesc(idRateMaster, pageable);
    }
}
