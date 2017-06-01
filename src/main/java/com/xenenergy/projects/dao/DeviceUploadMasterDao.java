package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.DeviceUploadMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 31/05/2017.
 */
@Repository
public interface DeviceUploadMasterDao extends PagingAndSortingRepository<DeviceUploadMaster, Long>{
    Page<DeviceUploadMaster> findAllByOrderByIdDesc(Pageable pageable);
}
