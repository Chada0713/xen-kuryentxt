package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.PerKwChargeDetailDao;
import com.xenenergy.projects.entities.PerKwChargeDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/19/2017.
 */
@Service
@Transactional
public class PerKwChargeDetailServiceImpl implements CRUDService<PerKwChargeDetail> {

    @Autowired
    PerKwChargeDetailDao perKwChargeDetailDao;


    public List<PerKwChargeDetail> findAllPageable(long id) {
        return perKwChargeDetailDao.findByIdMasterOrderByPrintOrderAsc(id);
    }

    public int getMaxPrintOrder(long id) {
        return perKwChargeDetailDao.findTopByPrintOrderOrderByPrintOrderDesc(id);
    }
    public double findSumOfTotalAmount(long id) {
        return perKwChargeDetailDao.findSumOfTotalAmount(id);
    }

    @Override
    public Page<PerKwChargeDetail> findAllPageable(Pageable pageable) {
        return perKwChargeDetailDao.findAll(pageable);
    }

    @Override
    public PerKwChargeDetail getById(long id) {
        return perKwChargeDetailDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        perKwChargeDetailDao.delete(id);
        return true;
    }

    @Override
    public PerKwChargeDetail insert(PerKwChargeDetail perKwChargeDetail) {
        return perKwChargeDetailDao.save(perKwChargeDetail);
    }

    @Override
    public PerKwChargeDetail update(PerKwChargeDetail perKwChargeDetail) {
        return perKwChargeDetailDao.save(perKwChargeDetail);
    }
}
