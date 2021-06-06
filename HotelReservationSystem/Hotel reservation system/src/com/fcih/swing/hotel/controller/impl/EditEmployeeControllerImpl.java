package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.EditEmployeeController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Employee;
import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.ui.admin.AddEmployeeUI;
import com.fcih.swing.hotel.ui.admin.EditEmployeeUI;
import java.util.List;
import java.util.regex.Pattern;

public class EditEmployeeControllerImpl implements EditEmployeeController {

    AdminService adminService = ServiceCreator.getAdminService();

    @Override
    public List<Employee> getAllEmployee() {
        return adminService.getAllEmployee();
    }

    @Override
    public void deleteEmployee() {
        int selectedRow = EditEmployeeUI.getInitiatedInstance().getEmployeeTable().getSelectedRow();

        if(selectedRow == -1) {
            EditEmployeeUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }
        
        Integer empId = (Integer) EditEmployeeUI.getInitiatedInstance().getEmployeeTable().getModel().getValueAt(selectedRow, 8);

        Employee emp = new Employee();
        emp.setId(empId);

        if (adminService.deleteEmployee(emp)) {
            EditEmployeeUI.getInitiatedInstance().displayCorrectDialog("Row deleted successfully");
            EditEmployeeUI.getInitiatedInstance().drawEmployeeTable();
        } else {
            EditEmployeeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
        }
    }

    @Override
    public void editEmployeeData() {
        EditEmployeeUI editEmployeeUI = EditEmployeeUI.getInitiatedInstance();

        int selectedRow = editEmployeeUI.getEmployeeTable().getSelectedRow();

        if (selectedRow == -1) {
            EditEmployeeUI.getInitiatedInstance().displayErrorDialog("Please select row !!!");
            return;
        }

        //Get Table Data
        String name = (String) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 1);
        Integer code = (Integer) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 2);
        Float salary = (Float) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 3);
        Long phone = (Long) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 4);
        String email = (String) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 5);
        String address = (String) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 6);
        String isSuperuser = (String) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 7);
        Integer empId = (Integer) editEmployeeUI.getEmployeeTable().getModel().getValueAt(selectedRow, 8);

        Employee employee = new Employee();
        employee.setName(name);
        employee.setCode(code);
        employee.setId(empId);
        employee.setSalary(salary);
        employee.setPhone(phone);
        employee.setMail(email);
        employee.setAddress(address);
        employee.setSuperuser(isSuperuser);

        editEmployeeUI.displayUpdateDialog(employee, true);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (validData(employee)) {
            employee.setId(employee.getId());
            employee.setCode(employee.getCode());
            AddEmployeeUI addEmployeeUI = AddEmployeeUI.getInitiatedInstance();
            employee.setName(addEmployeeUI.getEmpNameTextField().getText());
            
            employee.setPhone(!addEmployeeUI.getPhoneTextField().getText().isEmpty() ? new Long(addEmployeeUI.getPhoneTextField().getText()) : null);
            employee.setSalary(new Float(addEmployeeUI.getSalaryTextField().getText()));
            employee.setMail(addEmployeeUI.getEmailTextField().getText());
            employee.setAddress(addEmployeeUI.getAddressTextField().getText());
            employee.setPassword(new String(addEmployeeUI.getPasswordField().getPassword()));
            employee.setSuperuser(addEmployeeUI.getIsSuperuserRadioButton().isSelected() ? "Y" : "N");

            if (adminService.updateEmployee(employee)) {
                EditEmployeeUI.getInitiatedInstance().drawEmployeeTable();
                EditEmployeeUI.getInitiatedInstance().displayCorrectDialog("Row updated successfully");
            } else {
                EditEmployeeUI.getInitiatedInstance().displayErrorDialog("Operation failed !!! ,,, Please contact administrator");
            }
        }
    }

    private boolean validData(Employee employee) {

        boolean isValid = true;

        String empName = AddEmployeeUI.getInitiatedInstance().getEmpNameTextField().getText();
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
            try {
                new Long(phone);
            } catch (NumberFormatException ex) {
                AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Please insert valid phone number");
                isValid = false;
            }
        }

        String email = AddEmployeeUI.getInitiatedInstance().getEmailTextField().getText();
        if (email != null && !email.isEmpty()) {
            String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
            if (!Pattern.compile(emailRegex).matcher(email).matches()) {
                AddEmployeeUI.getInitiatedInstance().displayErrorDialog("Please insert valid email");
                isValid = false;
            }
        }

        if (!isValid) {
            EditEmployeeUI.getInitiatedInstance().displayUpdateDialog(employee, false);
        }

        return isValid;
    }

}
