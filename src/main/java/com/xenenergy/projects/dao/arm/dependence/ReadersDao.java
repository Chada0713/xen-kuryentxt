package com.xenenergy.projects.dao.arm.dependence;

import com.xenenergy.projects.entities.arm.MeterReader;
import org.springframework.data.repository.CrudRepository;

public interface ReadersDao extends CrudRepository<MeterReader, Long> {
}
