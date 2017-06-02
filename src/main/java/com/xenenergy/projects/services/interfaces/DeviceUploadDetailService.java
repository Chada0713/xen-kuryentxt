package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.DeviceUploadDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 02/06/2017.
 */
@Transactional
public interface DeviceUploadDetailService extends CRUDService<DeviceUploadDetail>{
    Page<DeviceUploadDetail> findAllByIdMasterOrderByIdDesc(long idMaster, Pageable pageable);
}