package com.xenenergy.projects.services.interfaces;

import com.xenenergy.projects.entities.Property;

/**
 * Created by xesi on 09/06/2017.
 */
public interface PropertyService extends CRUDService<Property> {
    Property findByPropertyName(String propertyName);
}
