package com.xenenergy.projects.dao.arm;

import com.xenenergy.projects.entities.arm.Rdm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xenuser on 5/11/2017.
 */
public interface RouteDefinitionDao extends PagingAndSortingRepository<Rdm, Long>{
    Page<Rdm> findAllByOrderByIdDesc(Pageable pageable);
     /* Uncomment this if you want to display the record in desc order*/
    // List<Rdm> findAllByOrderByIdDesc();
}
