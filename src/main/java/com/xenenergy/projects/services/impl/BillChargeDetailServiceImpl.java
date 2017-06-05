package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.BillChargeDetailDao;
import com.xenenergy.projects.entities.BillChargeDetail;
import com.xenenergy.projects.services.interfaces.BillChargeDetailService;
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
public class BillChargeDetailServiceImpl implements BillChargeDetailService {

    @Autowired
    private BillChargeDetailDao billChargeDetailDao;

    @Override
    public Page<BillChargeDetail> findAllPageable(Pageable pageable) {
        return billChargeDetailDao.findAll(pageable);
    }

    @Override
    public BillChargeDetail getById(long id) {
        return billChargeDetailDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        billChargeDetailDao.delete(id);
        return true;
    }

    @Override
    public BillChargeDetail insert(BillChargeDetail billChargeDetail) {
        return billChargeDetailDao.save(billChargeDetail);
    }

    @Override
    public BillChargeDetail update(BillChargeDetail billChargeDetail) {
        return billChargeDetailDao.save(billChargeDetail);
    }

    @Override
    public List<BillChargeDetail> findByPrintOrderMasterAndBillNo(int printOrderMaster, String bill_no) {
        return billChargeDetailDao.findByPrintOrderMasterAndBillNo(printOrderMaster, bill_no);
    }

}
