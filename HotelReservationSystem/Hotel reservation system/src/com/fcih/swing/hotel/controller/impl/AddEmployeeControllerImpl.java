package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.AddEmployeeController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Employee;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddEmployeeUI;
import java.util.regex.Pattern;

public class AddEmployeeControllerImpl implements AddEmployeeController {

    AdminService adminService = ServiceCreator.getAdminService();

    @Override
    public void addEmployee() {
        if (validateData()) {
            Employee emp = new Employee();
            emp.setName(AddEmployeeUI.getInitiatedInstance().getEmpNameTextField().getText());
            emp.setPassword(new String(AddEmployeeUI.getInitiatedInstance().getPasswordField().getPassword()));
            emp.setAddress(AddEmployeeUI.getInitiatedInstance().getAddressTextField().getText());
            emp.setSuperuser(AddEmployeeUI.getInitiatedInstance().getIsSuperuserRadioButton().isSelected() == true ? "Y" : "N");
            emp.setMail(AddEmployeeUI.getInitiatedInstance().getEmailTextField().getText());
            
            if(AddEmployeeUI.getInitiatedInstance().getSalaryTextField().getText()!= null && !AddEmployeeUI.getInitiatedInstance().getSalaryTextField().getText().isEmpty())
                emp.setSalary(new Float(AddEmployeeUI.getInitiatedInstance().getSalaryTextField().getText()));
            
            if(AddEmployeeUI.getInitiatedInstance().getPhoneTextField().getText() != null && !AddEmployeeUI.getInitiatedInstance().getPhoneTextField().getText().isEmpty())
                emp.setPhone(new Long(AddEmployeeUI.getInitiatedInstance().getPhoneTextField().getText()));
            

            if (adminService.addEmployee(emp) != -1) {
                AddEmployeeUI.getInitiatedInstance().reset();
                AddEmployeeUI.getInitiatedInstance().displayCorrectDialog("Employee added successfully");
                AddEmployeeUI.getInitiatedInstance().displayCodeDialog(emp.getCode());
            } else {
                AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,, Please contact administrator");
            }
        }

    }

    private boolean validateData() {
        String empName = AddEmployeeUI.getInitiatedInstance().getEmpNameTextField().getText();
        boolean isValid = true;
        
        if (empName == null || empName.isEmpty()) {
            AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Name is mandatory field");
            isValid = false;
        }
        
        String password = new String(AddEmployeeUI.getInitiatedInstance().getPasswordField().getPassword());

        if (password == null || password.isEmpty()) {
            AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Password is mandatory field");
            isValid = false;
        }
        
        String salary = AddEmployeeUI.getInitiatedInstance().getSalaryTextField().getText();
        if (salary != null && !salary.isEmpty()) {
            try {
                new Float(salary);
            } catch (NumberFormatException ex) {
                AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Please insert valid salary");
                isValid = false;
            }
        }

        String phone = AddEmployeeUI.getInitiatedInstance().getPhoneTextField().getText();
        if (phone != null && !phone.isEmpty()) {
            if (!phone.startsWith("010") && !phone.startsWith("011") && !phone.startsWith("012") && !phone.startsWith("015") && phone.length() != 11) {
                AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Please insert valid phone number");
                isValid = false;
            }
            else {
                try {
                    new Long(phone);
                } catch (NumberFormatException ex) {
                    AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Please insert valid phone number");
                    isValid = false;
                }
            }
        }

        String email = AddEmployeeUI.getInitiatedInstance().getEmailTextField().getText();
        if (email != null && !email.isEmpty()) {
            String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
            if (!Pattern.compile(emailRegex).matcher(email).matches()) {
                AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Please insert valid value for email");
                isValid = false;
            }
        }

        return isValid;
    }

}
