package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.PerKwChargeTemplateDao;
import com.xenenergy.projects.entities.PerKwChargeTemplate;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.PerKwChargeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 23/06/2017.
 */
@Service
@Transactional
public class PerKwChargeTemplateServiceImpl implements PerKwChargeTemplateService {

    @Autowired
    private PerKwChargeTemplateDao perKwChargeTemplateDao;

    @Override
    public Page<PerKwChargeTemplate> findAllPageable(Pageable pageable) {
        return perKwChargeTemplateDao.findAll(pageable);
    }

    @Override
    public PerKwChargeTemplate getById(long id) {
        return perKwChargeTemplateDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        perKwChargeTemplateDao.delete(id);
        return true;
    }

    @Override
    public PerKwChargeTemplate insert(PerKwChargeTemplate perKwChargeTemplate) {
        return perKwChargeTemplateDao.save(perKwChargeTemplate);
    }

    @Override
    public PerKwChargeTemplate update(PerKwChargeTemplate perKwChargeTemplate) {
        return perKwChargeTemplateDao.save(perKwChargeTemplate);
    }

    @Override
    public Integer findTopByPrintOrderOrderByPrintOrderDesc() {
        return perKwChargeTemplateDao.findTopByPrintOrderOrderByPrintOrderDesc();
    }
}
