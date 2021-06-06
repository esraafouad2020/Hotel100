package com.fcih.swing.hotel.creator;

import com.fcih.swing.hotel.service.AdminService;
import com.fcih.swing.hotel.service.ReceptionistService;
import com.fcih.swing.hotel.service.impl.AdminServiceImpl;
import com.fcih.swing.hotel.service.impl.ReceptionistServiceImpl;

public class ServiceCreator {
    
    public static AdminService getAdminService() {
        return new AdminServiceImpl();
    }
    
    public static ReceptionistService getReceptionistService() {
        return new ReceptionistServiceImpl();
    }
}
