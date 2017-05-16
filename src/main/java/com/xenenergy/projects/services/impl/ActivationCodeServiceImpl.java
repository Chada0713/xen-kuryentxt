package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.ActivationCodeDao;
import com.xenenergy.projects.entities.ActivationCode;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivationCodeServiceImpl implements CRUDService<ActivationCode> {
    @Autowired
    private ActivationCodeDao activationCodeDao;

    @Override
    public Page<ActivationCode> findAllPageable(Pageable pageable) {
        return activationCodeDao.findAllByOrderByIdDesc(pageable);
    }

    @Override
    public ActivationCode getById(long id) {
        return activationCodeDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        activationCodeDao.delete(id);
        return true;
    }

    @Override
    public ActivationCode insert(ActivationCode activationCode) {
        return activationCodeDao.save(activationCode);
    }

    @Override
    public ActivationCode update(ActivationCode activationCode) {
        return activationCodeDao.save(activationCode);
    }

    public ActivationCode findActivationCode(String activationCode) {
        return activationCodeDao.findByActivationCode(activationCode);
    }
}
