package com.xenenergy.projects.services.impl;

import com.xenenergy.projects.dao.DeviceUploadDetailDao;
import com.xenenergy.projects.entities.DeviceUploadDetail;
import com.xenenergy.projects.services.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 01/06/2017.
 */
@Service
@Transactional
public class DeviceUploadDetailServiceImpl implements CRUDService<DeviceUploadDetail> {

    @Autowired
    private DeviceUploadDetailDao deviceUploadDetailDao;

    @Override
    public Page<DeviceUploadDetail> findAllPageable(Pageable pageable) {
        return deviceUploadDetailDao.findAll(pageable);
    }

    @Override
    public DeviceUploadDetail getById(long id) {
        return deviceUploadDetailDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        deviceUploadDetailDao.delete(id);
        return true;
    }

    @Override
    public DeviceUploadDetail insert(DeviceUploadDetail deviceUploadDetail) {
        return deviceUploadDetailDao.save(deviceUploadDetail);
    }

    @Override
    public DeviceUploadDetail update(DeviceUploadDetail deviceUploadDetail) {
        return deviceUploadDetailDao.save(deviceUploadDetail);
    }
}
