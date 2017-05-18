package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.ChargeTypeDao;
import com.xenenergy.projects.entities.ChargeType;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xenuser on 5/18/2017.
 */
@Service
@Transactional
public class ChargeTypeServiceImpl implements CRUDService<ChargeType> {

    @Autowired
    private ChargeTypeDao chargeTypeDao;

    public Page<ChargeType> findAllPageable(long idRateMaster, Pageable pageable) {
        return chargeTypeDao.findByIdRateMasterOrderByIdRateMasterAscPrintOrderAsc(idRateMaster, pageable);
    }

    @Override
    public Page<ChargeType> findAllPageable(Pageable pageable) {
        return chargeTypeDao.findAll(pageable);
    }

    @Override
    public ChargeType getById(long id) {
        return chargeTypeDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        chargeTypeDao.delete(id);
        return true;
    }

    @Override
    public ChargeType insert(ChargeType chargeType) {
        return chargeTypeDao.save(chargeType);
    }

    @Override
    public ChargeType update(ChargeType chargeType) {
        return chargeTypeDao.save(chargeType);
    }
}
