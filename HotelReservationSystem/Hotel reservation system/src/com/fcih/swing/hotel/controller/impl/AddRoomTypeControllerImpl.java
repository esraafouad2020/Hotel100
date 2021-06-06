package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.AddRoomTypeController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddRoomTypeUI;

public class AddRoomTypeControllerImpl implements AddRoomTypeController {

    AdminService adminService = ServiceCreator.getAdminService();

    @Override
    public void addRoomType() {
        if (validData()) {
            AddRoomTypeUI addRoomTypeUI = AddRoomTypeUI.getInitiatedInstance();
            RoomTypeLookup roomTypeLookup = new RoomTypeLookup();

            roomTypeLookup.setName(addRoomTypeUI.getRoomTypeNameTextField().getText().trim());

            if (adminService.addRoomType(roomTypeLookup)) {
                addRoomTypeUI.reset();
                addRoomTypeUI.displayCorrectDialog("Room added successfully");
            } else {
                addRoomTypeUI.displayErrorDialog("Operation failed ,,, Please contact administrator !!!!");
            }
        }
    }

    private boolean validData() {
        AddRoomTypeUI addRoomTypeUI = AddRoomTypeUI.getInitiatedInstance();

        boolean isValid = true;

        if (addRoomTypeUI.getRoomTypeNameTextField().getText() == null || addRoomTypeUI.getRoomTypeNameTextField().getText().isEmpty()) {
            addRoomTypeUI.displayErrorDialog("Name is a mandatory field");
            isValid = false;
        }

        return isValid;
    }

}
