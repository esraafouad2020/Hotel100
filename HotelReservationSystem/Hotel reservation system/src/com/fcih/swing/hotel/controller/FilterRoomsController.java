package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import java.util.List;

public interface FilterRoomsController {

    public List<RoomTypeLookup> getAllRoomTypes();

    public List<ViewTypeLookup> getAllViewTypes();

    public List<Room> getFilteredRooms();
}
