package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.Employee;
import java.util.List;

public interface EditEmployeeController {

    List<Employee> getAllEmployee();
    
    void deleteEmployee();
    
    void updateEmployee(Employee emp);

    void editEmployeeData();
}
