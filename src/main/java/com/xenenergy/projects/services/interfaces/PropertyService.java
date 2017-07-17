package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Property;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by xesi on 09/06/2017.
 */
public interface PropertyService extends CRUDService<Property> {
    Property findByPropertyName(String propertyName);

    List<Property> findAllByOrderByIdDesc();
    List<Property> findAllByOrderById();

    Property updatePropertyValue(String propertyValue, long id);

    List<Property> getAllDuProperty();

    List<Property> getAllNotDuProperty();

    List<Property> getAllScProperty();
}
