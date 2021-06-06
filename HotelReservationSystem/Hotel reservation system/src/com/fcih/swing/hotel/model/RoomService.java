package com.fcih.swing.hotel.model;

import com.fcih.swing.hotel.entity.annotation.Entity;
import com.fcih.swing.hotel.entity.annotation.Join;

@Entity(value = "ROOM_SERVICE")
public class RoomService implements Model {

    private Integer id;
    
    @Join(value = "ROOM")
    private Room room;
    
    @Join(value = "Service")
    private Service service;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

}
