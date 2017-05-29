package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.AddOnKwh;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 16/05/2017.
 */
@Repository
public interface AddOnKwhDao extends PagingAndSortingRepository<AddOnKwh, Long> {
}
