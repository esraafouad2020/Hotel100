package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.EditRoomController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddRoomUI;
import com.fcih.swing.hotel.ui.admin.EditRoomUI;
import java.util.List;

public class EditRoomControllerImpl implements EditRoomController{
    AdminService adminService = ServiceCreator.getAdminService();

    @Override
    public List<Room> getAllRoom() {
        return adminService.getAllRoom();
    }

    @Override
    public void deleteRoom() {
        int selectedRow = EditRoomUI.getInitiatedInstance().getRoomTable().getSelectedRow();

        if(selectedRow == -1) {
            EditRoomUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        Integer empId = (Integer) EditRoomUI.getInitiatedInstance().getRoomTable().getModel().getValueAt(selectedRow, 5);

        Room emp = new Room();
        emp.setId(empId);

        if (adminService.deleteRoom(emp)) {
            EditRoomUI.getInitiatedInstance().displayCorrectDialog("Row deleted successfully");
            EditRoomUI.getInitiatedInstance().drawRoomTable();
        } else {
            EditRoomUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
        }
    }

    @Override
    public void editRoomData() {
        EditRoomUI editRoomUI = EditRoomUI.getInitiatedInstance();

        int selectedRow = editRoomUI.getRoomTable().getSelectedRow();
        
        if(selectedRow == -1) {
            EditRoomUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        //Get Table Data
        Integer roomNumber = (Integer) editRoomUI.getRoomTable().getModel().getValueAt(selectedRow, 1);
        Float cost = (Float) editRoomUI.getRoomTable().getModel().getValueAt(selectedRow, 2);
        ViewTypeLookup viewTypeLookup = (ViewTypeLookup) editRoomUI.getRoomTable().getModel().getValueAt(selectedRow, 3);
        RoomTypeLookup roomTypeLookup = (RoomTypeLookup) editRoomUI.getRoomTable().getModel().getValueAt(selectedRow, 4);
        Integer roomId = (Integer) editRoomUI.getRoomTable().getModel().getValueAt(selectedRow, 5);

        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setCost(cost);
        room.setId(roomId);
        room.setViewTypeLookup(viewTypeLookup);
        room.setRoomTypeLookup(roomTypeLookup);
        
        editRoomUI.displayUpdateDialog(room, true);
    }

    @Override
    public void updateRoom(Room room) {
        if (validData(room)) {
            AddRoomUI addRoomUI = AddRoomUI.getInitiatedInstance();
            room.setId(room.getId());
            room.setCost(room.getCost());
            room.setRoomNumber(new Integer(addRoomUI.getRoomNumberTextField().getText()));
            room.setCost(new Float(addRoomUI.getCostTextField().getText()));
            room.setRoomTypeLookup((RoomTypeLookup) addRoomUI.getRoomTypeComboBox().getSelectedItem());
            room.setViewTypeLookup((ViewTypeLookup) addRoomUI.getViewTypeComboBox().getSelectedItem());

            if (adminService.updateRoom(room)) {
                EditRoomUI.getInitiatedInstance().drawRoomTable();
                EditRoomUI.getInitiatedInstance().displayCorrectDialog("Row updated successfully");
            } else {
                EditRoomUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
            }
        }
    }

    private boolean validData(Room room) {
        AddRoomUI addRoomUI = AddRoomUI.getInitiatedInstance();
        boolean isValid = true;
        if (addRoomUI.getRoomNumberTextField().getText() == null || addRoomUI.getRoomNumberTextField().getText().isEmpty()) {
            addRoomUI.displayErrorDialog("Room number is a mandatory field");
            isValid =  false;
        } else {
            try {
                new Integer(addRoomUI.getRoomNumberTextField().getText().trim());
            } catch (NumberFormatException ex) {
                addRoomUI.displayErrorDialog("Please inter valid room number");
                isValid =  false;
            }
        }
        
        if (addRoomUI.getCostTextField().getText() == null || addRoomUI.getCostTextField().getText().isEmpty()) {
            addRoomUI.displayErrorDialog("Cost is a mandatory field");
            isValid =  false;
        } else {
            try {
                new Float(addRoomUI.getCostTextField().getText().trim());
            } catch (NumberFormatException ex) {
                addRoomUI.displayErrorDialog("Please inter valid cost");
                isValid =  false;
            }
        }

        if ("-- Please Select --".equalsIgnoreCase(addRoomUI.getViewTypeComboBox().getSelectedItem().toString().trim())) {
            addRoomUI.displayErrorDialog("Please select view type");
            isValid =  false;
        }

        if ("-- Please Select --".equalsIgnoreCase(addRoomUI.getRoomTypeComboBox().getSelectedItem().toString().trim())) {
            addRoomUI.displayErrorDialog("Please select room type");
            isValid =  false;
        }
        
        if(!isValid)
            EditRoomUI.getInitiatedInstance().displayUpdateDialog(room, false);

        return isValid;
    }
}
