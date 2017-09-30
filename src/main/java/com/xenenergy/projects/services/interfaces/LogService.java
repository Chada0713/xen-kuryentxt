package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.LogMsg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daryll Sabate on 10/25/2017.
 */
@Transactional
@Service
public interface LogService extends CRUDService<LogMsg> {
    List<LogMsg> findAllByOrderById();
}
