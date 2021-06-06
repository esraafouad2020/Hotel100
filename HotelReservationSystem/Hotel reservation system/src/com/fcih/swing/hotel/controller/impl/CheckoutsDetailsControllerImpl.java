package com.fcih.swing.hotel.controller.impl;

import com.fcih.swing.hotel.controller.CheckoutsDetailsController;
import com.fcih.swing.hotel.creator.ServiceCreator;
import com.fcih.swing.hotel.model.Guest;
import com.fcih.swing.hotel.service.ReceptionistService;
import com.fcih.swing.hotel.ui.receptionist.CheckoutDetailsUI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckoutsDetailsControllerImpl implements CheckoutsDetailsController {

    ReceptionistService receptionistService = ServiceCreator.getReceptionistService();

    @Override
    public List<Guest> getCheckoutsDetails() {
        List<Guest> checkoutList = new ArrayList<>();
        if (validData()) {
            CheckoutDetailsUI checkoutDetailsUI = CheckoutDetailsUI.getInitiatedInstance();

            Date to = checkoutDetailsUI.getToDateChooser().getDate();
            Date from = checkoutDetailsUI.getFromDateChooser().getDate();

            checkoutList = receptionistService.getCheckoutsDetails(new java.sql.Date(from.getTime()), new java.sql.Date(to.getTime()));
        }

        return checkoutList;
    }

    private boolean validData() {
        CheckoutDetailsUI checkoutDetailsUI = CheckoutDetailsUI.getInitiatedInstance();
        boolean isValid = true;

        Date from = checkoutDetailsUI.getToDateChooser().getDate();
        Date to = checkoutDetailsUI.getFromDateChooser().getDate();

        if (from == null) {
            checkoutDetailsUI.displayErrorDialog(" Please select \"from date\"");
            isValid = false;
        }

        if (to == null) {
            checkoutDetailsUI.displayErrorDialog(" Please select \"to date\"");
            isValid = false;
        }

        if (isValid && from.before(to)) {
            checkoutDetailsUI.displayErrorDialog(" \"From date\" must be before \"to date\"");
            isValid = false;
        }

        return isValid;
    }
}
