package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Meter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 27/07/2017.
 */
@Transactional
public interface MeterService extends CRUDService<Meter> {
    Page<Meter> findByIdRoute(long idRoute, Pageable pageable);
}
