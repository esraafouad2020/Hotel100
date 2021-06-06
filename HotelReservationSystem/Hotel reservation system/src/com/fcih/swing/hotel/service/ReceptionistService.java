package com.fcih.swing.hotel.service;

import com.fcih.swing.hotel.model.Guest;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import java.sql.Date;
import java.util.List;

public interface ReceptionistService {

    public List<RoomTypeLookup> getAllRoomType();

    public List<ViewTypeLookup> getAllViewType();
    
    public List<Room> getFilteredRooms(RoomTypeLookup roomTypeLookup, ViewTypeLookup viewTypeLookup, boolean isBusy);

    public List<Guest> getCheckoutsDetails(Date from, Date to);
}
