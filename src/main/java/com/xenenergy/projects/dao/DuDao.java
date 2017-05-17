package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Du;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by xenuser on 5/17/2017.
 */
@Repository
public interface DuDao extends JpaRepository<Du, Long> {

}
