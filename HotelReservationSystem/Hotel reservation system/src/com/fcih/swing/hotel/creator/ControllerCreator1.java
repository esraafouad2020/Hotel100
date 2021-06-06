package com.fcih.swing.hotel.creator;

import com.fcih.swing.hotel.controller.AddEmployeeController;
import com.fcih.swing.hotel.controller.AddGuestController;
import com.fcih.swing.hotel.controller.AddRoomController;
import com.fcih.swing.hotel.controller.AddRoomTypeController;
import com.fcih.swing.hotel.controller.AddServiceController;
import com.fcih.swing.hotel.controller.AddViewTypeController;
import com.fcih.swing.hotel.controller.AdminController;
import com.fcih.swing.hotel.controller.CheckoutsDetailsController;
import com.fcih.swing.hotel.controller.EditEmployeeController;
import com.fcih.swing.hotel.controller.EditGuestController;
import com.fcih.swing.hotel.controller.EditRoomController;
import com.fcih.swing.hotel.controller.EditRoomTypeController;
import com.fcih.swing.hotel.controller.EditServiceController;
import com.fcih.swing.hotel.controller.EditViewTypeController;
import com.fcih.swing.hotel.controller.FilterRoomsController;
import com.fcih.swing.hotel.controller.LoginController;
import com.fcih.swing.hotel.controller.impl.AddEmployeeControllerImpl;
import com.fcih.swing.hotel.controller.impl.AddGuestControllerImpl;
import com.fcih.swing.hotel.controller.impl.AddRoomControllerImpl;
import com.fcih.swing.hotel.controller.impl.AddRoomTypeControllerImpl;
import com.fcih.swing.hotel.controller.impl.AddServiceControllerImpl;
import com.fcih.swing.hotel.controller.impl.AddViewTypeControllerImpl;
import com.fcih.swing.hotel.controller.impl.AdminControllerImpl;
import com.fcih.swing.hotel.controller.impl.CheckoutsDetailsControllerImpl;
import com.fcih.swing.hotel.controller.impl.EditEmployeeControllerImpl;
import com.fcih.swing.hotel.controller.impl.EditGuestControllerImpl;
import com.fcih.swing.hotel.controller.impl.EditRoomControllerImpl;
import com.fcih.swing.hotel.controller.impl.EditRoomTypeControllerImpl;
import com.fcih.swing.hotel.controller.impl.EditServiceControllerImpl;
import com.fcih.swing.hotel.controller.impl.EditViewTypeControllerImpl;
import com.fcih.swing.hotel.controller.impl.FilterRoomsControllerImpl;
import com.fcih.swing.hotel.controller.impl.LoginControllerImpl;

public class ControllerCreator1 {

    public static LoginController getLoginController() {
        return new LoginControllerImpl();
    }
    
    public static AddEmployeeController getAddEmployeeController() {
        return new AddEmployeeControllerImpl();
    }
    
    public static EditEmployeeController getEditEmployeeController() {
        return new EditEmployeeControllerImpl();
    }
    
    public static AddRoomController getAddRoomController() {
        return new AddRoomControllerImpl();
    }
    
    public static EditRoomController getEditRoomController() {
        return new EditRoomControllerImpl();
    }
    
    public static AddRoomTypeController getAddRoomTypeController() {
        return new AddRoomTypeControllerImpl();
    }
    
    public static EditRoomTypeController getEditRoomTypeController() {
        return new EditRoomTypeControllerImpl();
    }
    
    public static AddServiceController getAddServiceController() {
        return new AddServiceControllerImpl();
    }
    
    public static EditServiceController getEditServiceController() {
        return new EditServiceControllerImpl();
    }
    
    public static AddViewTypeController getAddViewTypeController() {
        return new AddViewTypeControllerImpl();
    }
    
    public static EditViewTypeController getEditViewTypeController() {
        return new EditViewTypeControllerImpl();
    }
    
    public static AdminController getAdminController() {
        return new AdminControllerImpl();
    }
    
    public static AddGuestController getAddGuestController(){
        return new AddGuestControllerImpl();
    }
    
    public static EditGuestController getEditGuestController(){
        return new EditGuestControllerImpl();
    }
    
    public static FilterRoomsController getFilterRoomsController(){
        return new FilterRoomsControllerImpl();
    }
    
    public static CheckoutsDetailsController getCheckoutsDetailsController(){
        return new CheckoutsDetailsControllerImpl();
    }
}