package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.BillsDao;
import com.xenenergy.projects.entities.arm.Bills;
import com.xenenergy.projects.services.interfaces.arm.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 17/05/2017.
 */
@Service
@Transactional
public class BillsServiceImpl implements BillsService {

    @Autowired
    private BillsDao billsDao;

    @Override
    public Page<Bills> findAllPageable(Pageable pageable) {
        return billsDao.findAll(pageable);
    }

    @Override
    public Bills getById(long id) {
        return billsDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        billsDao.delete(id);
        return true;
    }

    @Override
    public Bills insert(Bills bills) {
        return billsDao.save(bills);
    }

    @Override
    public Bills update(Bills bills) {
        return billsDao.save(bills);
    }

    @Override
    public int countBills(String dateFrom, String dateTo) {
        return billsDao.countByRunDateBetween(dateFrom, dateTo);
    }

    @Override
    public List<Bills> getAllBills() {
        return billsDao.findAll();
    }
}
