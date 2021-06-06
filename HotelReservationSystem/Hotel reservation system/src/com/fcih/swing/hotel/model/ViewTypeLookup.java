package com.fcih.swing.hotel.model;

import com.fcih.swing.hotel.entity.annotation.Entity;

@Entity(value = "VIEW_TYPE_LOOKUP")
public class ViewTypeLookup implements Model {

    private Integer id;
    
    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
