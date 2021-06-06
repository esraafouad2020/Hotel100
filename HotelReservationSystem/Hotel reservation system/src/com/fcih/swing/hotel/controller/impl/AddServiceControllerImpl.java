package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.AddServiceController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Service;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddServiceUI;


public class AddServiceControllerImpl implements AddServiceController{
    
    private AdminService adminService = ServiceCreator.getAdminService();

    @Override
    public void addService() {
        if (validData()) {
            AddServiceUI addServiceUI = AddServiceUI.getInitiatedInstance();
            Service service = new Service();
            service.setName(addServiceUI.getServiceNameTextField().getText().trim());
            service.setCost(new Float(addServiceUI.getServiceCostTextField().getText().trim()));
            
            if (adminService.addService(service)) {
                AddServiceUI.getInitiatedInstance().reset();
                addServiceUI.displayCorrectDialog("Service added successfully");
            } else {
                addServiceUI.displayErrorDialog("Operation failed ,,, Please contact administrator !!!!");
            }
        }
    }

    private boolean validData() {
        AddServiceUI addServiceUI = AddServiceUI.getInitiatedInstance();
        
        boolean isValid = true;
        
        if (addServiceUI.getServiceNameTextField().getText() == null || addServiceUI.getServiceNameTextField().getText().isEmpty()) {
            addServiceUI.displayErrorDialog("Service name is a mandatory field");
            isValid = false;
        }

        if (addServiceUI.getServiceCostTextField().getText() == null || addServiceUI.getServiceCostTextField().getText().isEmpty()) {
            addServiceUI.displayErrorDialog("Cost is a mandatory field");
            isValid = false;
        } else {
            try {
                new Float(addServiceUI.getServiceCostTextField().getText().trim());
            } catch (NumberFormatException ex) {
                addServiceUI.displayErrorDialog("Please inter valid cost");
                isValid = false;
            }
        }

        return isValid;
    }
    
    
}
