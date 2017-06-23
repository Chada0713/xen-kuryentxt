package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.FixedChargeTemplateDao;
import com.xenenergy.projects.entities.FixedChargeTemplate;
import com.xenenergy.projects.services.interfaces.FixedChargeTemplateService;
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
public class FixedChargeTemplateServiceImpl implements FixedChargeTemplateService {

    @Autowired
    private FixedChargeTemplateDao fixedChargeTemplateDao;

    @Override
    public Page<FixedChargeTemplate> findAllPageable(Pageable pageable) {
        return fixedChargeTemplateDao.findAll(pageable);
    }

    @Override
    public FixedChargeTemplate getById(long id) {
        return fixedChargeTemplateDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        fixedChargeTemplateDao.delete(id);
        return true;
    }

    @Override
    public FixedChargeTemplate insert(FixedChargeTemplate fixedChargeTemplate) {
        return fixedChargeTemplateDao.save(fixedChargeTemplate);
    }

    @Override
    public FixedChargeTemplate update(FixedChargeTemplate fixedChargeTemplate) {
        return fixedChargeTemplateDao.save(fixedChargeTemplate);
    }

    @Override
    public Integer findTopByPrintOrderOrderByPrintOrderDesc() {
        return fixedChargeTemplateDao.findTopByPrintOrderOrderByPrintOrderDesc();
    }
}
