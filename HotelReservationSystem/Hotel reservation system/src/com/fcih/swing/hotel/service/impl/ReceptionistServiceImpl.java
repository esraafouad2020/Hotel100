package com.fcih.swing.hotel.service.impl;

import com.fcih.swing.hotel.dao.factory.EntityFactory;
import com.fcih.swing.hotel.model.Guest;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.service.ReceptionistService;
import java.sql.Date;
import java.util.List;

public class ReceptionistServiceImpl implements ReceptionistService{
    
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
    public List<Room> getFilteredRooms(RoomTypeLookup roomTypeLookup, ViewTypeLookup viewTypeLookup, boolean isBusy) {
        List<Room> room = null;
        try {
            
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM ROOM WHERE 1=1");
            if(roomTypeLookup != null) {
                query.append(" AND room_type_id = ").append(roomTypeLookup.getId());
            }
            
            if(viewTypeLookup != null) {
                query.append(" AND view_type_id = ").append(viewTypeLookup.getId());
            }
            
            if(isBusy) {
                query.append(" AND id IN (SELECT room_id FROM GUEST WHERE TO_DATE(end_date) > TO_DATE ( '").append(new Date(System.currentTimeMillis())).append("', 'YYYY-MM-DD'))");
            } else {
                query.append(" AND id NOT IN (SELECT room_id FROM GUEST WHERE TO_DATE(end_date) > TO_DATE ( '").append(new Date(System.currentTimeMillis())).append("', 'YYYY-MM-DD'))");
            }
            
            room = EntityFactory.getEntityManager().executeQuery(query.toString());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return room;
    }

    @Override
    public List<Guest> getCheckoutsDetails(Date from, Date to) {
        List<Guest> guest = null;
        try {
            
            String query = "SELECT * FROM GUEST WHERE TO_DATE(end_date) BETWEEN TO_DATE ( '" + from + "', 'YYYY-MM-DD') AND TO_DATE ( '" + to + "', 'YYYY-MM-DD')";
            
            guest = EntityFactory.getEntityManager().executeQuery(query);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return guest;
    }
}
