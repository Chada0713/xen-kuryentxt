package com.xenenergy.projects.dao.dependence;

import com.xenenergy.projects.entities.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReadersDao extends CrudRepository<Reader, Long> {
}
