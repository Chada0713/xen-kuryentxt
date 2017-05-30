package com.xenenergy.projects.dao.cum;

import com.xenenergy.projects.entities.cum.DistUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Daryll Sabate on 5/29/2017.
 */
@Repository
public interface DistUtilDao extends PagingAndSortingRepository<DistUtil, Long> {
}
