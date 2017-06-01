package com.xenenergy.projects.dao.dependence;

import com.xenenergy.projects.entities.Rdm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RdmDao extends CrudRepository<Rdm, Long> {

}
