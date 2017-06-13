package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Property;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDao extends PagingAndSortingRepository<Property, Long> {
    /* Uncomment this if you want to display the record in desc order*/
   // List<Property> findAllByOrderByIdDesc();
    Property findByPropertyName(String propertyName);
}
