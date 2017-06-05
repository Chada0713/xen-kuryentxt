package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.BillChargeGroupDao;
import com.xenenergy.projects.entities.BillChargeGroup;
import com.xenenergy.projects.services.interfaces.BillChargeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 02/06/2017.
 */
@Service
@Transactional
public class BillChargeGroupServiceImpl implements BillChargeGroupService{

    @Autowired
    private BillChargeGroupDao billChargeGroupDao;


    @Override
    public Page<BillChargeGroup> findAllPageable(Pageable pageable) {
        return billChargeGroupDao.findAll(pageable);
    }

    @Override
    public BillChargeGroup getById(long id) {
        return billChargeGroupDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        billChargeGroupDao.delete(id);
        return true;
    }

    @Override
    public BillChargeGroup insert(BillChargeGroup billChargeGroup) {
        return billChargeGroupDao.save(billChargeGroup);
    }

    @Override
    public BillChargeGroup update(BillChargeGroup billChargeGroup) {
        return billChargeGroupDao.save(billChargeGroup);
    }

    @Override
    public List findByBillNo(String billno) {
        return billChargeGroupDao.findByBillNo(billno);
    }
}
