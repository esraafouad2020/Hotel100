package com.fcih.swing.hotel.model;

import com.fcih.swing.hotel.entity.annotation.Column;
import com.fcih.swing.hotel.entity.annotation.Join;
import java.sql.Date;

public class Guest implements Model{

    private Integer id;
    
    private String name;
    
    private Integer phone;
    
    private String email;
    
    @Column(value = "NATIONAL_ID")
    private String nationalId;
    
    @Column(value = "START_DATE")
    private Date startDate;
    
    @Column(value = "END_DATE")
    private Date endDate;
    
    @Join(value = "Room")
    @Column(value = "ROOM_ID")
    private Room room;

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
