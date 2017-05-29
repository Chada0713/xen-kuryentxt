package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.Du;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xenuser on 5/17/2017.
 */
@Repository
public interface DuDao extends JpaRepository<Du, Long> {

}
