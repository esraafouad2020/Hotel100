package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.EditServiceController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Service;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddServiceUI;
import com.fcih.swing.hotel.ui.admin.EditServiceUI;
import java.util.List;

public class EditServiceControllerImpl implements EditServiceController{

    AdminService adminService = ServiceCreator.getAdminService();
    
    @Override
    public List<Service> getAllService() {
        return adminService.getAllService();
    }

    @Override
    public void deleteService() {
        int selectedRow = EditServiceUI.getInitiatedInstance().getServiceTable().getSelectedRow();

        if(selectedRow == -1) {
            EditServiceUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        Integer serviceId = (Integer) EditServiceUI.getInitiatedInstance().getServiceTable().getModel().getValueAt(selectedRow, 3);

        Service service = new Service();
        service.setId(serviceId);

        if (adminService.deleteService(service)) {
            EditServiceUI.getInitiatedInstance().drawServiceTable();
            EditServiceUI.getInitiatedInstance().displayCorrectDialog("Row deleted successfully");
        } else {
            EditServiceUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
        }
    }
    
    @Override
    public void editServiceData() {
        EditServiceUI editServiceUI = EditServiceUI.getInitiatedInstance();

        int selectedRow = editServiceUI.getServiceTable().getSelectedRow();
        
        if(selectedRow == -1) {
            EditServiceUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        //Get Table Data
        String serviceName = editServiceUI.getServiceTable().getModel().getValueAt(selectedRow, 1).toString();
        Float cost = (Float) editServiceUI.getServiceTable().getModel().getValueAt(selectedRow, 2);
        Integer serviceId = (Integer) editServiceUI.getServiceTable().getModel().getValueAt(selectedRow, 3);

        Service service = new Service();
        service.setName(serviceName);
        service.setCost(cost);
        service.setId(serviceId);
        
        editServiceUI.displayUpdateDialog(service, true);
    }

    @Override
    public void updateService(Service service) {
        if (validData(service)) {
            AddServiceUI updateServiceUI = AddServiceUI.getInitiatedInstance();
            service.setId(service.getId());
            service.setCost(service.getCost());
            service.setName(updateServiceUI.getServiceNameTextField().getText());
            service.setCost(new Float(updateServiceUI.getServiceCostTextField().getText()));
            
            if (adminService.updateService(service)) {
                EditServiceUI.getInitiatedInstance().drawServiceTable();
                EditServiceUI.getInitiatedInstance().displayCorrectDialog("Row updated successfully");
            } else {
                EditServiceUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
            }
        }
    }

    private boolean validData(Service service) {
        AddServiceUI updateServiceUI = AddServiceUI.getInitiatedInstance();
        
        boolean isValid = true;
        
        if (updateServiceUI.getServiceNameTextField().getText() == null || updateServiceUI.getServiceNameTextField().getText().isEmpty()) {
            updateServiceUI.displayErrorDialog("Service name is a mandatory field");
            isValid = false;
        }

        if (updateServiceUI.getServiceCostTextField().getText() == null || updateServiceUI.getServiceCostTextField().getText().isEmpty()) {
            updateServiceUI.displayErrorDialog("Cost is a mandatory field");
            isValid = false;
        } else {
            try {
                new Float(updateServiceUI.getServiceCostTextField().getText().trim());
            } catch (NumberFormatException ex) {
                updateServiceUI.displayErrorDialog("Please inter valid cost");
                isValid = false;
            }
        }
        
        if(!isValid)
            EditServiceUI.getInitiatedInstance().displayUpdateDialog(service, false);

        return isValid;
    }
    
}
