package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.EditRoomTypeController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddRoomTypeUI;
import com.fcih.swing.hotel.ui.admin.EditRoomTypeUI;
import java.util.List;

public class EditRoomTypeControllerImpl implements EditRoomTypeController{
    AdminService adminService = ServiceCreator.getAdminService();
    
    @Override
    public List<RoomTypeLookup> getAllRoomType() {
        return adminService.getAllRoomType();
    }

    @Override
    public void deleteRoomType() {
        int selectedRow = EditRoomTypeUI.getInitiatedInstance().getRoomTypeTable().getSelectedRow();

        if(selectedRow == -1) {
            EditRoomTypeUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        Integer roomTypeId = (Integer) EditRoomTypeUI.getInitiatedInstance().getRoomTypeTable().getModel().getValueAt(selectedRow, 2);

        RoomTypeLookup roomType = new RoomTypeLookup();
        roomType.setId(roomTypeId);

        if (adminService.deleteRoomType(roomType)) {
            EditRoomTypeUI.getInitiatedInstance().drawRoomTypeTable();
            EditRoomTypeUI.getInitiatedInstance().displayCorrectDialog("Row deleted successfully");
        } else {
            EditRoomTypeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
        }
    }
    
    @Override
    public void editRoomTypeData() {
        EditRoomTypeUI editRoomTypeUI = EditRoomTypeUI.getInitiatedInstance();

        int selectedRow = editRoomTypeUI.getRoomTypeTable().getSelectedRow();
        
        if(selectedRow == -1) {
            EditRoomTypeUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        //Get Table Data
        String roomTypeName = editRoomTypeUI.getRoomTypeTable().getModel().getValueAt(selectedRow, 1).toString();
        Integer roomTypeId = (Integer) editRoomTypeUI.getRoomTypeTable().getModel().getValueAt(selectedRow, 2);

        RoomTypeLookup roomType = new RoomTypeLookup();
        roomType.setName(roomTypeName);
        roomType.setId(roomTypeId);
        
        editRoomTypeUI.displayUpdateDialog(roomType, true);
    }

    @Override
    public void updateRoomType(RoomTypeLookup roomType) {
        if (validData(roomType)) {
            AddRoomTypeUI updateRoomTypeUI = AddRoomTypeUI.getInitiatedInstance();
            roomType.setId(roomType.getId());
            roomType.setName(updateRoomTypeUI.getRoomTypeNameTextField().getText());
            
            if (adminService.updateRoomType(roomType)) {
                EditRoomTypeUI.getInitiatedInstance().drawRoomTypeTable();
                EditRoomTypeUI.getInitiatedInstance().displayCorrectDialog("Row updated successfully");
            } else {
                EditRoomTypeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
            }
        }
    }

    private boolean validData(RoomTypeLookup roomType) {
        AddRoomTypeUI updateRoomTypeUI = AddRoomTypeUI.getInitiatedInstance();
        
        boolean isValid = true;
        
        if (updateRoomTypeUI.getRoomTypeNameTextField().getText() == null || updateRoomTypeUI.getRoomTypeNameTextField().getText().isEmpty()) {
            updateRoomTypeUI.displayErrorDialog("Name is a mandatory field");
            isValid = false;
        }
        
        if(!isValid)
            EditRoomTypeUI.getInitiatedInstance().displayUpdateDialog(roomType, false);

        return isValid;
    }
}
