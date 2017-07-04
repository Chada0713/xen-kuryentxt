package com.xenenergy.projects.dao;

import com.xenenergy.projects.entities.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyDao extends PagingAndSortingRepository<Property, Long> {
    /* Uncomment this if you want to display the record in desc order*/
    List<Property> findAllByOrderByIdDesc();
    List<Property> findAllByOrderById();
    Property findByPropertyName(String propertyName);

    @Query("update Property a set a.propertyValue = ?1 where a.id = ?2")
    Property updatePropertyValue(String propertyValue, long id);

    @Query("select a from Property a where propertyName like 'DU%'")
    List<Property> getAllDuProperty();
}
