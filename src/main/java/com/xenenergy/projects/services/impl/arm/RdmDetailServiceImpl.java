package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.RdmDetailDao;
import com.xenenergy.projects.entities.arm.RdmDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 22/05/2017.
 */
@Service
@Transactional
public class RdmDetailServiceImpl implements CRUDService<RdmDetail> {

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

    public Page<RdmDetail> findAllByIdRdm(long idRdm, Pageable pageable){
        return rdmDetailDao.findByIdRdm(idRdm, pageable);
    }
}
