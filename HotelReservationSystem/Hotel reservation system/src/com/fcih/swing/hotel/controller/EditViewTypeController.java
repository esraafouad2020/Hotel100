package com.fcih.swing.hotel.controller;

import com.fcih.swing.hotel.model.ViewTypeLookup;
import java.util.List;

public interface EditViewTypeController {

    public List<ViewTypeLookup> getAllViewType();
    
    public void deleteViewType();
    
    public void editViewTypeData();
    
    public void updateViewType(ViewTypeLookup viewType);
}
