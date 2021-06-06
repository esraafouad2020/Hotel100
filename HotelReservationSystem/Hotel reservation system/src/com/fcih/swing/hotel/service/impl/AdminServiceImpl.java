package com.fcih.swing.hotel.service.impl;

import com.fcih.swing.hotel.dao.factory.EntityFactory;
import com.fcih.swing.hotel.model.Employee;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.Service;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.AdminService;
import java.util.List;
import java.util.Random;

public class AdminServiceImpl implements AdminService {

    @Override
    public Employee login(Integer code, String password) {
        Employee emp = null;
        try {
            String query = "SELECT * FROM EMPLOYEE WHERE Code = " + code + "AND password = " + password;
            List<Employee> results = EntityFactory.getEntityManager().executeQuery(query);

            if (results != null && results.size() == 1) {
                emp = results.get(0);
            } else {
                if (results == null || results.isEmpty()) {
                    throw new Exception("this account are not exist");
                } else {
                    throw new Exception("Multiple results found please contact administrator");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return emp;
    }

    @Override
    public Integer addEmployee(Employee emp) {
        try {
            emp.setCode(10000 + (int) (new Random().nextFloat() * 90000));
            EntityFactory.getEntityManager().add(emp);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        return emp.getCode();
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = null;
        try {
            employeeList = EntityFactory.getEntityManager().viewAll(Employee.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(Employee emp) {
        boolean isDeleted = false;
        try {
            if (EntityFactory.getEntityManager().delete(emp) > 0) {
                isDeleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean isUpdated = false;
        try {
            if (EntityFactory.getEntityManager().update(employee) > 0) {
                isUpdated = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean addRoom(Room room) {
        try {
            EntityFactory.getEntityManager().add(room);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<Room> getAllRoom() {
        List<Room> rooms = null;
        try {
            rooms = EntityFactory.getEntityManager().viewAll(Room.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rooms;
    }
    
    @Override
    public boolean deleteRoom(Room room) {
        boolean isDeleted = false;
        try {
            if (EntityFactory.getEntityManager().delete(room) > 0) {
                isDeleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean updateRoom(Room room) {
        boolean isUpdated = false;
        try {
            if (EntityFactory.getEntityManager().update(room) > 0) {
                isUpdated = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean addService(Service service) {
        try {
            EntityFactory.getEntityManager().add(service);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = null;
        try {
            serviceList = EntityFactory.getEntityManager().viewAll(Service.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(Service service) {
        boolean isDeleted = false;
        try {
            if (EntityFactory.getEntityManager().delete(service) > 0) {
                isDeleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean updateService(Service service) {
        boolean isUpdated = false;
        try {
            if (EntityFactory.getEntityManager().update(service) > 0) {
                isUpdated = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isUpdated;
    }

    @Override
    public boolean addRoomType(RoomTypeLookup roomTypeLookup) {
        try {
            EntityFactory.getEntityManager().add(roomTypeLookup);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<RoomTypeLookup> getAllRoomType() {
        List<RoomTypeLookup> roomTypeList = null;
        try {
            roomTypeList = EntityFactory.getEntityManager().viewAll(RoomTypeLookup.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return roomTypeList;
    }
    
    @Override
    public boolean deleteRoomType(RoomTypeLookup roomType) {
        boolean isDeleted = false;
        try {
            if (EntityFactory.getEntityManager().delete(roomType) > 0) {
                isDeleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean updateRoomType(RoomTypeLookup roomType) {
        boolean isUpdated = false;
        try {
            if (EntityFactory.getEntityManager().update(roomType) > 0) {
                isUpdated = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isUpdated;
    }
    
    @Override
    public boolean addViewType(ViewTypeLookup viewType) {
        try {
            EntityFactory.getEntityManager().add(viewType);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public List<ViewTypeLookup> getAllViewType() {
        List<ViewTypeLookup> viewTypeList = null;
        try {
            viewTypeList = EntityFactory.getEntityManager().viewAll(ViewTypeLookup.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return viewTypeList;
    }
    
    @Override
    public boolean deleteViewType(ViewTypeLookup viewType) {
        boolean isDeleted = false;
        try {
            if (EntityFactory.getEntityManager().delete(viewType) > 0) {
                isDeleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public boolean updateViewType(ViewTypeLookup viewType) {
        boolean isUpdated = false;
        try {
            if (EntityFactory.getEntityManager().update(viewType) > 0) {
                isUpdated = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isUpdated;
    }
}
