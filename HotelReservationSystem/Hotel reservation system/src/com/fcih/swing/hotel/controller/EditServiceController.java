package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.Service;
import java.util.List;

public interface EditServiceController {

    public List<Service> getAllService();

    public void deleteService();
    
    public void editServiceData();
    
    public void updateService(Service service);

}
