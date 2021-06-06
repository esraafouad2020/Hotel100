package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.LoginController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Employee;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AdminUI;
import com.fcih.swing.hotel.ui.login.LoginUI;
import com.fcih.swing.hotel.ui.receptionist.ReceptionistUI;

public class LoginControllerImpl implements LoginController {

    AdminService adminService;

    public LoginControllerImpl() {
        adminService = ServiceCreator.getAdminService();
    }

    @Override
    public void login(Integer code, String password) {
        Employee emp = adminService.login(code, password);
        if (emp == null) {
            LoginUI.getInitiatedInstance().displayErrorDialog();
        } 
        
        else {
            if (emp.isSuperuser()) {
                LoginUI.getInitiatedInstance().setVisible(false);
                AdminUI.run();
            } else {
                LoginUI.getInitiatedInstance().setVisible(false);
                ReceptionistUI.run();
            }
        }
    }
    
    @Override
    public boolean validData() {
        if(LoginUI.getInitiatedInstance().getCodeTextField().getText() == null || LoginUI.getInitiatedInstance().getCodeTextField().getText().equals("") || LoginUI.getInitiatedInstance().getPasswordField().getPassword() == null || LoginUI.getInitiatedInstance().getPasswordField().getPassword().length == 0)
            return false;
        else {
            try {
                new Integer(LoginUI.getInitiatedInstance().getCodeTextField().getText());
            } catch(NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}
