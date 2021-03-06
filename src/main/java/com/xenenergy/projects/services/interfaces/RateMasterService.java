package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.RateMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Transactional
public interface RateMasterService extends CRUDService<RateMaster>{
    Page<RateMaster> findAllWithFixCharge(Pageable pageable);
    List<RateMaster> findAllByOrderById();
}
