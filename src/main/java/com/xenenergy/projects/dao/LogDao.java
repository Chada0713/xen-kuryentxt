package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.LogMsg;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Daryll Sabate on 10/25/2017.
 */
@Repository
public interface LogDao extends PagingAndSortingRepository<LogMsg, Long> {
    List<LogMsg> findAllByOrderById();
}
