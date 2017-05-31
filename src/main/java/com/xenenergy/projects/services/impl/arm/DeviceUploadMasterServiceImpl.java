package com.xenenergy.projects.services.impl.arm;

import com.xenenergy.projects.dao.arm.DeviceUploadMasterDao;
import com.xenenergy.projects.entities.arm.DeviceUploadMaster;
import com.xenenergy.projects.services.interfaces.CRUDService;
import com.xenenergy.projects.services.interfaces.arm.DeviceUploadMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 31/05/2017.
 */
@Service
@Transactional
public class DeviceUploadMasterServiceImpl implements DeviceUploadMasterService{

    @Autowired
    private DeviceUploadMasterDao deviceUploadMasterDao;

    @Override
    public Page<DeviceUploadMaster> findAllPageable(Pageable pageable) {
        return deviceUploadMasterDao.findAll(pageable);
    }

    @Override
    public DeviceUploadMaster getById(long id) {
        return deviceUploadMasterDao.findOne(id);
    }

    @Override
    public boolean deleteById(long id) {
        deviceUploadMasterDao.delete(id);
        return true;
    }

    @Override
    public DeviceUploadMaster insert(DeviceUploadMaster deviceUploadMaster) {
        return deviceUploadMasterDao.save(deviceUploadMaster);
    }

    @Override
    public DeviceUploadMaster update(DeviceUploadMaster deviceUploadMaster) {
        return deviceUploadMasterDao.save(deviceUploadMaster);
    }

    @Override
    public Page<DeviceUploadMaster> findAllByOrderByIdDesc(Pageable pageable) {
        return deviceUploadMasterDao.findAllByOrderByIdDesc(pageable);
    }
}
