package com.fcih.swing.hotel.model;

import com.fcih.swing.hotel.entity.annotation.Entity;

@Entity(value = "ROOM_TYPE_LOOKUP")
public class RoomTypeLookup implements Model {

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
