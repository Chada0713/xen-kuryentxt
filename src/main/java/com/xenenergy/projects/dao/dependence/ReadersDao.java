package com.xenenergy.projects.dao.dependence;

import com.xenenergy.projects.entities.MeterReader;
import org.springframework.data.repository.CrudRepository;

public interface ReadersDao extends CrudRepository<MeterReader, Long> {
}
