package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.PerKwChargeMasterDao;
import com.xenenergy.projects.entities.arm.PerKwChargeMaster;
import com.xenenergy.projects.services.interfaces.arm.PerKwChargeMasterService;
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
public class PerKwChargeMasterServiceImpl implements PerKwChargeMasterService {

    @Autowired
    private PerKwChargeMasterDao perKwChargeMasterDao;

    @Override
    public Page<PerKwChargeMaster> findAllPageable(Pageable pageable) {
        return perKwChargeMasterDao.findAll(pageable);
    }

    @Override
    public PerKwChargeMaster getById(long id) {
        return perKwChargeMasterDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        perKwChargeMasterDao.delete(id);
        return true;
    }

    @Override
    public PerKwChargeMaster insert(PerKwChargeMaster perKwChargeMaster) {
        return perKwChargeMasterDao.save(perKwChargeMaster);
    }

    @Override
    public PerKwChargeMaster update(PerKwChargeMaster perKwChargeMaster) {
        return perKwChargeMasterDao.save(perKwChargeMaster);
    }

    @Override
    public Page<PerKwChargeMaster> findAllByIdRateMaster(long id, Pageable pageable) {
        return perKwChargeMasterDao.findByIdRateMasterOrderByIdDesc(id,pageable);
    }
}
