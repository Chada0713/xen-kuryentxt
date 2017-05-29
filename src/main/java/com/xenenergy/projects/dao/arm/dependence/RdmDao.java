package com.xenenergy.projects.dao.arm.dependence;

import com.xenenergy.projects.entities.arm.Rdm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RdmDao extends CrudRepository<Rdm, Long> {

}
