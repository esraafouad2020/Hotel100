package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.AddRoomController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddRoomUI;
import java.util.List;

public class AddRoomControllerImpl implements AddRoomController {

    AdminService adminService = ServiceCreator.getAdminService();

    @Override
    public List<RoomTypeLookup> getAllRoomTypes() {
        return adminService.getAllRoomType();
    }

    @Override
    public List<ViewTypeLookup> getAllViewTypes() {
        return adminService.getAllViewType();
    }

    @Override
    public void addRoom() {
        if (validData()) {
            AddRoomUI addRoomUI = AddRoomUI.getInitiatedInstance();
            Room room = new Room();
            room.setCost(new Float(addRoomUI.getCostTextField().getText().trim()));
            room.setRoomNumber(new Integer(addRoomUI.getRoomNumberTextField().getText().trim()));
            room.setRoomTypeLookup((RoomTypeLookup) addRoomUI.getRoomTypeComboBox().getSelectedItem());
            room.setViewTypeLookup((ViewTypeLookup) addRoomUI.getViewTypeComboBox().getSelectedItem());

            if (adminService.addRoom(room)) {
                AddRoomUI.getInitiatedInstance().reset();
                addRoomUI.displayCorrectDialog("Room added successfully");
            } else {
                addRoomUI.displayErrorDialog("Operation failed ,,, Please contact administrator !!!!");
            }
        }
    }

    private boolean validData() {
        AddRoomUI addRoomUI = AddRoomUI.getInitiatedInstance();
        
        boolean isValid = true;
        
        if (addRoomUI.getRoomNumberTextField().getText() == null || addRoomUI.getRoomNumberTextField().getText().isEmpty()) {
            addRoomUI.displayErrorDialog("Room number is a mandatory field");
            isValid = false;
        } else {
            try {
                new Integer(addRoomUI.getRoomNumberTextField().getText().trim());
            } catch (NumberFormatException ex) {
                addRoomUI.displayErrorDialog("Please inter valid room number");
                isValid = false;
            }
        }

        if (addRoomUI.getCostTextField().getText() == null || addRoomUI.getCostTextField().getText().isEmpty()) {
            addRoomUI.displayErrorDialog("Cost is a mandatory field");
            isValid = false;
        } else {
            try {
                new Float(addRoomUI.getCostTextField().getText().trim());
            } catch (NumberFormatException ex) {
                addRoomUI.displayErrorDialog("Please inter valid cost");
                isValid = false;
            }
        }

        if ("-- Please Select --".equalsIgnoreCase(addRoomUI.getViewTypeComboBox().getSelectedItem().toString().trim())) {
            addRoomUI.displayErrorDialog("Please select view type");
            isValid = false;
        }

        if ("-- Please Select --".equalsIgnoreCase(addRoomUI.getRoomTypeComboBox().getSelectedItem().toString().trim())) {
            addRoomUI.displayErrorDialog("Please select room type");
            isValid = false;
        }

        return isValid;
    }

}
