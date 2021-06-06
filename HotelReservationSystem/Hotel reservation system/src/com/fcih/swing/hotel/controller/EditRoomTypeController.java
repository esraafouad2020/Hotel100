package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.RoomTypeLookup;
import java.util.List;


public interface EditRoomTypeController {
    public List<RoomTypeLookup> getAllRoomType();
    
    public void deleteRoomType();
    
    public void editRoomTypeData();
    
    public void updateRoomType(RoomTypeLookup roomType);
}
