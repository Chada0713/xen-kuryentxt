package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.BillAddOnChargeDao;
import com.xenenergy.projects.entities.BillAddOnCharge;
import com.xenenergy.projects.services.interfaces.BillAddOnChargeService;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 13/06/2017.
 */
@Service
@Transactional
public class BillAddOnChargeServiceImpl implements BillAddOnChargeService {

    @Autowired
    private BillAddOnChargeDao billAddOnChargeDao;


    @Override
    public Page<BillAddOnCharge> findAllPageable(Pageable pageable) {
        return billAddOnChargeDao.findAll(pageable);
    }

    @Override
    public BillAddOnCharge getById(long id) {
        return billAddOnChargeDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        billAddOnChargeDao.delete(id);
        return true;
    }

    @Override
    public BillAddOnCharge insert(BillAddOnCharge billAddOnCharge) {
        return billAddOnChargeDao.save(billAddOnCharge);
    }

    @Override
    public BillAddOnCharge update(BillAddOnCharge billAddOnCharge) {
        return billAddOnChargeDao.save(billAddOnCharge);
    }

    @Override
    public List<BillAddOnCharge> findByBillNo(String billNo) {
        return billAddOnChargeDao.findByBillNo(billNo);
    }
}
