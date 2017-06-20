package com.xenenergy.projects.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xesi on 19/06/2017.
 */
public class PropertyWrapper {
    List<Property> properties;

    List<String> propertyName = new ArrayList<>();

    public PropertyWrapper() {
    }

    public PropertyWrapper(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<String> getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(List<String> propertyName) {
        this.propertyName = propertyName;
    }
}
