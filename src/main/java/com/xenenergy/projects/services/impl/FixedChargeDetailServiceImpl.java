package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.FixedChargeDetailDao;
import com.xenenergy.projects.entities.FixedChargeDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 19/05/2017.
 */
@Service
@Transactional
public class FixedChargeDetailServiceImpl implements CRUDService<FixedChargeDetail>{

    @Autowired
    private FixedChargeDetailDao fixedChargeDetailDao;


    @Override
    public Page<FixedChargeDetail> findAllPageable(Pageable pageable) {
        return fixedChargeDetailDao.findAll(pageable);
    }

    @Override
    public FixedChargeDetail getById(long id) {
        return fixedChargeDetailDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        fixedChargeDetailDao.delete(id);
        return true;
    }

    @Override
    public FixedChargeDetail insert(FixedChargeDetail fixedChargeDetail) {
        return fixedChargeDetailDao.save(fixedChargeDetail);
    }

    @Override
    public FixedChargeDetail update(FixedChargeDetail fixedChargeDetail) {
        return fixedChargeDetailDao.save(fixedChargeDetail);
    }

    public List<FixedChargeDetail> findAllByIdFixedChargeDetail(long idMaster){
        return fixedChargeDetailDao.findByIdMasterOrderByPrintOrderDesc(idMaster);
    }

    public int findTopByPrintOrderOrderByPrintOrderDesc(long idMaster){
        return fixedChargeDetailDao.findTopByPrintOrderOrderByPrintOrderDesc(idMaster);
    }

    public double findSumOfAmount(long idMaster){
        return fixedChargeDetailDao.findSumOfAmount(idMaster);
    }
}
