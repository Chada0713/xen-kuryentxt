package com.xenenergy.projects.entities.arm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arm_du_property")
public class Property {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "PROPERTY_DESCRIPTION")
    private String propertyDescription;

    @Column(name = "PROPERTY_VALUE")
    private String propertyValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyDescription() {
        return propertyDescription;
    }

    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }
}
