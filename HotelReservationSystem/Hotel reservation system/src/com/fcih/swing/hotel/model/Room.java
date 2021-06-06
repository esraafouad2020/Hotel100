package com.fcih.swing.hotel.model;

import com.fcih.swing.hotel.entity.annotation.Column;
import com.fcih.swing.hotel.entity.annotation.Entity;
import com.fcih.swing.hotel.entity.annotation.Join;

@Entity("ROOM")
public class Room implements Model{

    private Integer id;
    
    @Column(value = "ROOM_NUMBER")
    private Integer RoomNumber;
    
    private Float cost;
    
    @Join(value = "ROOM_TYPE_LOOKUP")
    @Column(value = "ROOM_TYPE_ID")
    private RoomTypeLookup roomTypeLookup;
    
    @Join(value = "VIEW_TYPE_LOOKUP")
    @Column(value = "VIEW_TYPE_ID")
    private ViewTypeLookup viewTypeLookup;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public RoomTypeLookup getRoomTypeLookup() {
        return roomTypeLookup;
    }

    public void setRoomTypeLookup(RoomTypeLookup roomTypeLookup) {
        this.roomTypeLookup = roomTypeLookup;
    }

    public ViewTypeLookup getViewTypeLookup() {
        return viewTypeLookup;
    }

    public void setViewTypeLookup(ViewTypeLookup viewTypeLookup) {
        this.viewTypeLookup = viewTypeLookup;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
