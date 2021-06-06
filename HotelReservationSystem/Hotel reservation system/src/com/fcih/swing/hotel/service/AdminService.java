package com.fcih.swing.hotel.service;

import com.fcih.swing.hotel.model.Employee;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.Service;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import java.util.List;

public interface AdminService {

    
    public Employee login(Integer username, String password);

    public Integer addEmployee(Employee emp);

    public List<Employee> getAllEmployee();

    public boolean deleteEmployee(Employee emp);

    public boolean updateEmployee(Employee employee);

    public boolean addRoom(Room room);

    public List<Room> getAllRoom();

    public boolean deleteRoom(Room emp);

    public boolean updateRoom(Room room);

    public boolean addService(Service service);

    public List<Service> getAllService();

    public boolean deleteService(Service service);

    public boolean updateService(Service service);

    public boolean addRoomType(RoomTypeLookup roomTypeLookup);

    public List<RoomTypeLookup> getAllRoomType();

    public boolean deleteRoomType(RoomTypeLookup roomType);

    public boolean updateRoomType(RoomTypeLookup roomType);

    public boolean addViewType(ViewTypeLookup viewType);

    public List<ViewTypeLookup> getAllViewType();

    public boolean deleteViewType(ViewTypeLookup viewType);

    public boolean updateViewType(ViewTypeLookup viewType);
}
