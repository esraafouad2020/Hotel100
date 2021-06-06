package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.Room;
import java.util.List;


public interface EditRoomController {
   
    public List<Room> getAllRoom();
    
    public void deleteRoom();
    
    public void editRoomData();
    
    public void updateRoom(Room room);
}
