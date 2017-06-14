package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.DbEventMonitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xesi on 14/06/2017.
 */
@Transactional
public interface DbEventMonitorService extends CRUDService<DbEventMonitor>{
}
