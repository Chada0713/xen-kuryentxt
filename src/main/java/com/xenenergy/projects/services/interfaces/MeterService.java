package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Meter;
import com.xenenergy.projects.entities.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xesi on 27/07/2017.
 */
@Transactional
public interface MeterService extends CRUDService<Meter> {
    Page<Meter> findByIdRoute(long idRoute, Pageable pageable);

    List<Meter> findAllByOrderById();

    @Query("select a from Meter a where idRoute in (select id from Route b where idArea = ?1)")
    List<Meter> findAllByAreaId(long id);

    /*select a from Meter a where idRoute in (select id from Route b where idArea = ?1)*/
}
