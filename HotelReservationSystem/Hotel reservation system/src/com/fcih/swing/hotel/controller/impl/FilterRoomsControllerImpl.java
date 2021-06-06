package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.FilterRoomsController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.ReceptionistService;
import com.fcih.swing.hotel.ui.receptionist.FilterRoomUI;
import java.util.List;

public class FilterRoomsControllerImpl implements FilterRoomsController {

    ReceptionistService receptionistService = ServiceCreator.getReceptionistService();

    @Override
    public List<RoomTypeLookup> getAllRoomTypes() {
        return receptionistService.getAllRoomType();
    }

    @Override
    public List<ViewTypeLookup> getAllViewTypes() {
        return receptionistService.getAllViewType();
    }

    @Override
    public List<Room> getFilteredRooms() {
        FilterRoomUI filterRoomUI = FilterRoomUI.getInitiatedInstance();

        RoomTypeLookup roomTypeLookup = null;
        ViewTypeLookup viewTypeLookup = null;
        
        try {
            roomTypeLookup = (RoomTypeLookup) filterRoomUI.getRoomTypeComboBox().getSelectedItem();
        } catch(Exception ex) {}
        
        try {
            viewTypeLookup = (ViewTypeLookup) filterRoomUI.getViewTypeComboBox().getSelectedItem();
        }catch(Exception ex) {}
        
        boolean isBusy = filterRoomUI.getIsBusyRoomRadioButton().isSelected();

        return receptionistService.getFilteredRooms(roomTypeLookup, viewTypeLookup, isBusy);
    }
}
