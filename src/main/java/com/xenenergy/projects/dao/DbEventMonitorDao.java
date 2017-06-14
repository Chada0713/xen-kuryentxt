package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.DbEventMonitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 13/06/2017.
 */
@Repository
public interface DbEventMonitorDao extends PagingAndSortingRepository<DbEventMonitor, Long>{
}
