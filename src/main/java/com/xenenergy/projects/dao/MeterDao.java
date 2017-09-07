package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Meter;
import com.xenenergy.projects.entities.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xesi on 27/07/2017.
 */
@Repository
public interface MeterDao extends PagingAndSortingRepository<Meter, Long> {
    Page<Meter> findByIdRoute(long idRoute, Pageable pageable);
    List<Meter> findAllByOrderById();

    @Query("select a from Meter a where idRoute in (select id from Route b where idArea = ?1)")
    List<Meter> findAllByAreaId(long id);
}
