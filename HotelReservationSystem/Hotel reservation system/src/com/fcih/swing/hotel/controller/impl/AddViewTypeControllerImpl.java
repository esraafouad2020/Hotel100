package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.AddViewTypeController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddViewTypeUI;

public class AddViewTypeControllerImpl implements AddViewTypeController{
    AdminService adminService = ServiceCreator.getAdminService();
    
    @Override
    public void addViewType() {
        if (validData()) {
            AddViewTypeUI addViewTypeUI = AddViewTypeUI.getInitiatedInstance();
            ViewTypeLookup viewTypeLookup = new ViewTypeLookup();

            viewTypeLookup.setName(addViewTypeUI.getViewTypeNameTextField().getText().trim());

            if (adminService.addViewType(viewTypeLookup)) {
                addViewTypeUI.reset();
                addViewTypeUI.displayCorrectDialog("View Type added successfully");
            } else {
                addViewTypeUI.displayErrorDialog("Operation failed ,,, Please contact administrator !!!!");
            }
        }
    }

    private boolean validData() {
        AddViewTypeUI addViewTypeUI = AddViewTypeUI.getInitiatedInstance();

        boolean isValid = true;

        if (addViewTypeUI.getViewTypeNameTextField().getText() == null || addViewTypeUI.getViewTypeNameTextField().getText().isEmpty()) {
            addViewTypeUI.displayErrorDialog("Name is a mandatory field");
            isValid = false;
        }

        return isValid;
    }
}
