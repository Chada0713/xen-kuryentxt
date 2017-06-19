package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.RdmDetailDao;
import com.xenenergy.projects.entities.RdmDetail;
import com.xenenergy.projects.services.interfaces.RdmDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 22/05/2017.
 */
@Service
@Transactional
public class RdmDetailServiceImpl implements RdmDetailService {

    @Autowired
    private RdmDetailDao rdmDetailDao;

    @Override
    public Page<RdmDetail> findAllPageable(Pageable pageable) {
        return rdmDetailDao.findAll(pageable);
    }

    @Override
    public RdmDetail getById(long id) {
        return rdmDetailDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        rdmDetailDao.delete(id);
        return true;
    }

    @Override
    public RdmDetail insert(RdmDetail rdmDetail) {
        return rdmDetailDao.save(rdmDetail);
    }

    @Override
    public RdmDetail update(RdmDetail rdmDetail) {
        return rdmDetailDao.save(rdmDetail);
    }

    @Override
    public Page<RdmDetail> findAllByIdRdm(long idRdm, Pageable pageable){
        return rdmDetailDao.findByIdRdm(idRdm, pageable);
    }

    @Override
    public List<RdmDetail> findAllByIdRdm(long idRdm) {
        return rdmDetailDao.findAllByIdRdm(idRdm);
    }

}
