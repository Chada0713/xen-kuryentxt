package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.Coreloss;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by xesi on 16/05/2017.
 */
@Repository
public interface CorelossDao extends PagingAndSortingRepository<Coreloss, Long>{
}
