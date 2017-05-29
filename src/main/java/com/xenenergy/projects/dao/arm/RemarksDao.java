package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.Remarks;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xenuser on 5/11/2017.
 */
@Repository
public interface RemarksDao extends PagingAndSortingRepository<Remarks, Long> {
}
