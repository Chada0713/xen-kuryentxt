package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.AddOnChargeDao;
import com.xenenergy.projects.entities.arm.AddOnCharge;
import com.xenenergy.projects.services.interfaces.arm.AddOnChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 16/05/2017.
 */
@Service
@Transactional
public class AddOnChargeServiceImpl implements AddOnChargeService {

    @Autowired
    private AddOnChargeDao addOnChargeDao;

    @Override
    public Page<AddOnCharge> findAllPageable(Pageable pageable) {
        return addOnChargeDao.findAll(pageable);
    }

    @Override
    public AddOnCharge getById(long id) {
        return addOnChargeDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        addOnChargeDao.delete(id);
        return true;
    }

    @Override
    public AddOnCharge insert(AddOnCharge addOnCharge) {
        return addOnChargeDao.save(addOnCharge);
    }

    @Override
    public AddOnCharge update(AddOnCharge addOnCharge) {
        return addOnChargeDao.save(addOnCharge);
    }
}
