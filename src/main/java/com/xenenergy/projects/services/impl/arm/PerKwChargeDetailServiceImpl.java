package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.PerKwChargeDetailDao;
import com.xenenergy.projects.entities.arm.PerKwChargeDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.arm.PerKwChargeDetailsService;
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
public class PerKwChargeDetailServiceImpl implements PerKwChargeDetailsService {

    @Autowired
    PerKwChargeDetailDao perKwChargeDetailDao;

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

    @Override
    public void callCopyToTemplate(long id) {
        perKwChargeDetailDao.copyToTemplate(id);
    }

    @Override
    public List<PerKwChargeDetail> findAllPageable(long id) {
        return perKwChargeDetailDao.findByIdMasterOrderByPrintOrderAsc(id);
    }

    @Override
    public int getMaxPrintOrder(long id) {
        int maxPrintOrder = 0;
        try {
            if (perKwChargeDetailDao.findTopByPrintOrderOrderByPrintOrderDesc(id) == null) {
                maxPrintOrder = 0;
            } else {
                maxPrintOrder = perKwChargeDetailDao.findTopByPrintOrderOrderByPrintOrderDesc(id);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return maxPrintOrder;
    }

    @Override
    public double findSumOfTotalAmount(long id) {
        double totalAmt = 0.0000;
        try {
            if (perKwChargeDetailDao.findSumOfTotalAmount(id) == null) {
                totalAmt = 0.0000;
            } else {
                totalAmt = perKwChargeDetailDao.findSumOfTotalAmount(id);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return totalAmt;
    }
}
