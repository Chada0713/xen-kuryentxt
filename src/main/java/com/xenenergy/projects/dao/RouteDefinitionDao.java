package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Rdm;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by xenuser on 5/11/2017.
 */
public interface RouteDefinitionDao extends PagingAndSortingRepository<Rdm, Long>{
     /* Uncomment this if you want to display the record in desc order*/
    // List<Rdm> findAllByOrderByIdDesc();
}
