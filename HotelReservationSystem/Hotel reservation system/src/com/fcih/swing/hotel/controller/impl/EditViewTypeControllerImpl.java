package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.EditViewTypeController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddViewTypeUI;
import com.fcih.swing.hotel.ui.admin.EditViewTypeUI;
import java.util.List;

public class EditViewTypeControllerImpl implements EditViewTypeController{
    AdminService adminService = ServiceCreator.getAdminService();
    
    @Override
    public List<ViewTypeLookup> getAllViewType() {
        return adminService.getAllViewType();
    }
    
    @Override
    public void deleteViewType() {
        int selectedRow = EditViewTypeUI.getInitiatedInstance().getViewTypeTable().getSelectedRow();

        if(selectedRow == -1) {
            EditViewTypeUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        Integer roomTypeId = (Integer) EditViewTypeUI.getInitiatedInstance().getViewTypeTable().getModel().getValueAt(selectedRow, 2);

        ViewTypeLookup viewType = new ViewTypeLookup();
        viewType.setId(roomTypeId);

        if (adminService.deleteViewType(viewType)) {
            EditViewTypeUI.getInitiatedInstance().drawViewTypeTable();
            EditViewTypeUI.getInitiatedInstance().displayCorrectDialog("Row deleted successfully");
        } else {
            EditViewTypeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
        }
    }
    
    @Override
    public void editViewTypeData() {
        EditViewTypeUI editViewTypeUI = EditViewTypeUI.getInitiatedInstance();

        int selectedRow = editViewTypeUI.getViewTypeTable().getSelectedRow();
        
        if(selectedRow == -1) {
            EditViewTypeUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        //Get Table Data
        String viewTypeName = editViewTypeUI.getViewTypeTable().getModel().getValueAt(selectedRow, 1).toString();
        Integer viewTypeId = (Integer) editViewTypeUI.getViewTypeTable().getModel().getValueAt(selectedRow, 2);

        ViewTypeLookup viewType = new ViewTypeLookup();
        viewType.setName(viewTypeName);
        viewType.setId(viewTypeId);
        
        editViewTypeUI.displayUpdateDialog(viewType, true);
    }
    
    @Override
    public void updateViewType(ViewTypeLookup viewType) {
        if (validData(viewType)) {
            AddViewTypeUI updateViewTypeUI = AddViewTypeUI.getInitiatedInstance();
            viewType.setId(viewType.getId());
            viewType.setName(updateViewTypeUI.getViewTypeNameTextField().getText());
            
            if (adminService.updateViewType(viewType)) {
                EditViewTypeUI.getInitiatedInstance().drawViewTypeTable();
                EditViewTypeUI.getInitiatedInstance().displayCorrectDialog("Row updated successfully");
            } else {
                EditViewTypeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
            }
        }
    }

    private boolean validData(ViewTypeLookup roomType) {
        AddViewTypeUI updateViewTypeUI = AddViewTypeUI.getInitiatedInstance();
        
        boolean isValid = true;
        
        if (updateViewTypeUI.getViewTypeNameTextField().getText() == null || updateViewTypeUI.getViewTypeNameTextField().getText().isEmpty()) {
            updateViewTypeUI.displayErrorDialog("Name is a mandatory field");
            isValid = false;
        }
        
        if(!isValid)
            EditViewTypeUI.getInitiatedInstance().displayUpdateDialog(roomType, false);

        return isValid;
    }
}
