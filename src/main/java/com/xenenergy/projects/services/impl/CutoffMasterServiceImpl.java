package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.CutoffMasterDao;
import com.xenenergy.projects.entities.CutoffMaster;
import com.xenenergy.projects.services.interfaces.CutoffMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CutoffMasterServiceImpl implements CutoffMasterService {

    @Autowired
    CutoffMasterDao cutoffMasterDao;

    @Override
    public Page<CutoffMaster> findAllPageable(Pageable pageable) {
        return cutoffMasterDao.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public CutoffMaster getById(long id) {
        return cutoffMasterDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        cutoffMasterDao.delete(id);
        return true;
    }

    @Override
    public CutoffMaster insert(CutoffMaster cutoffMaster) {
        return cutoffMasterDao.save(cutoffMaster);
    }

    @Override
    public CutoffMaster update(CutoffMaster cutoffMaster) {
        return cutoffMasterDao.save(cutoffMaster);
    }

    @Override
    public List<Integer> getDays() {
        List<Integer> days = new ArrayList<>();
        for(int x = 1; x<32; x++){
            days.add(x);
        }
        return days;
    }
}
