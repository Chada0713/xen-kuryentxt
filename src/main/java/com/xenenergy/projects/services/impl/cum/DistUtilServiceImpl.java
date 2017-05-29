package com.xenenergy.projects.services.impl.cum;

import com.xenenergy.projects.dao.cum.DistUtilDao;
import com.xenenergy.projects.entities.cum.DistUtil;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Service
@Transactional
public class DistUtilServiceImpl implements CRUDService<DistUtil> {

    @Autowired
    private DistUtilDao distUtilDao;

    @Override
    public Page<DistUtil> findAllPageable(Pageable pageable) {
        return distUtilDao.findAll(pageable);
    }

    @Override
    public DistUtil getById(long id) {
        return distUtilDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public DistUtil insert(DistUtil distUtil) {
        return null;
    }

    @Override
    public DistUtil update(DistUtil distUtil) {
        return null;
    }
}
