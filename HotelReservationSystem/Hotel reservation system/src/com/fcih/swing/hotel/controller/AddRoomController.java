package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import java.util.List;

public interface AddRoomController {

    List<RoomTypeLookup> getAllRoomTypes();

    List<ViewTypeLookup> getAllViewTypes();
    
    void addRoom();
}
