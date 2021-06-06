package com.fcih.swing.hotel.ui.receptionist;

import com.fcih.swing.hotel.ui.admin.*;
import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public final class NavigationUI extends JPanel implements Drawable {

    private JSeparator guestFilterRoomSeparator;
    private JSeparator filterRoomCheckoutDetailsSeparator;
    private JSeparator checkoutDetailsServicesChartSeparator;
    private JSeparator addGuestEditGuestSeparator;

    private JLabel addGuestLabel;
    private JLabel editGuestLabel;
    private JLabel filterRoom;
    private JLabel checkoutDetails;
    private JLabel servicesChart;

    public NavigationUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        guestFilterRoomSeparator = new JSeparator();
        filterRoomCheckoutDetailsSeparator = new JSeparator();
        checkoutDetailsServicesChartSeparator = new JSeparator();
        addGuestEditGuestSeparator = new JSeparator();

        addGuestLabel = new JLabel();
        editGuestLabel = new JLabel();
        filterRoom = new JLabel();
        checkoutDetails = new JLabel();
        servicesChart = new JLabel();
    }

    @Override
    public void draw() {
        setBackground(new Color(255, 255, 255));

        prepareMenuComponent();

        GroupLayout menuPanelLayout = new GroupLayout(this);
        setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(guestFilterRoomSeparator, GroupLayout.Alignment.TRAILING)
                .addComponent(filterRoomCheckoutDetailsSeparator, GroupLayout.Alignment.TRAILING)
                .addComponent(checkoutDetailsServicesChartSeparator, GroupLayout.Alignment.TRAILING)
                .addComponent(addGuestEditGuestSeparator, GroupLayout.Alignment.TRAILING)
                .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addGuestLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(editGuestLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(filterRoom, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkoutDetails, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(servicesChart, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))
        );

        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(addGuestLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(addGuestEditGuestSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(editGuestLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(guestFilterRoomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(filterRoom, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(filterRoomCheckoutDetailsSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(checkoutDetails, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(checkoutDetailsServicesChartSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(servicesChart, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
        );
    }

    private void prepareMenuComponent() {
        addGuestFunctionality();
        
        addGuestEditGuestSeparator.setBackground(new Color(153, 153, 153));
        addGuestEditGuestSeparator.setForeground(new Color(153, 153, 153));
        
        editGuestFunctionality();

        guestFilterRoomSeparator.setBackground(new Color(153, 153, 153));
        guestFilterRoomSeparator.setForeground(new Color(153, 153, 153));

        drawFilterRoomFunctionality();

        filterRoomCheckoutDetailsSeparator.setBackground(new Color(153, 153, 153));
        filterRoomCheckoutDetailsSeparator.setForeground(new Color(153, 153, 153));

        drawCheckoutDetailsFunctionality();

        checkoutDetailsServicesChartSeparator.setBackground(new Color(153, 153, 153));
        checkoutDetailsServicesChartSeparator.setForeground(new Color(153, 153, 153));

        drawServicesChartFunctionality();
    }

    private void addGuestFunctionality() {
        addGuestLabel.setFont(new Font("Tahoma", 0, 18));
        addGuestLabel.setForeground(new Color(0, 102, 204));
        addGuestLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addGuestLabel.setText("Add Guest");
        addGuestLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addGuestLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addGuestLabelMouseClicked(evt);
            }
        });
    }
    
     private void editGuestFunctionality() {
        
        editGuestLabel.setFont(new Font("Tahoma", 0, 18));
        editGuestLabel.setForeground(new Color(0, 102, 204));
        editGuestLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editGuestLabel.setText("Edit Guest");
        editGuestLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editGuestLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editGuestLabelMouseClicked(evt);
            }
        });
    }

    private void drawFilterRoomFunctionality() {
        filterRoom.setFont(new Font("Tahoma", 0, 18));
        filterRoom.setForeground(new Color(0, 102, 204));
        filterRoom.setHorizontalAlignment(SwingConstants.CENTER);
        filterRoom.setText("Filter Room");
        filterRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        filterRoom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                filterRoomLabelMouseClicked(evt);
            }
        });
    }

    private void drawCheckoutDetailsFunctionality() {
        checkoutDetails.setFont(new Font("Tahoma", 0, 18));
        checkoutDetails.setForeground(new Color(0, 102, 204));
        checkoutDetails.setHorizontalAlignment(SwingConstants.CENTER);
        checkoutDetails.setText("Checkout Detials");
        checkoutDetails.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkoutDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                checkoutDetailsLabelMouseClicked(evt);
            }
        });
    }

    private void drawServicesChartFunctionality() {
        servicesChart.setFont(new Font("Tahoma", 0, 18));
        servicesChart.setForeground(new Color(0, 102, 204));
        servicesChart.setHorizontalAlignment(SwingConstants.CENTER);
        servicesChart.setText("Services's Chart");
        servicesChart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        servicesChart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                servicesChartLabelMouseClicked(evt);
            }
        });
    }

    private void addGuestLabelMouseClicked(MouseEvent evt) {
        try {

            ReceptionistUI.setRightPanel(new AddGuestUI());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void editGuestLabelMouseClicked(MouseEvent evt) {
        try {
            ReceptionistUI.setRightPanel(new EditGuestUI());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void filterRoomLabelMouseClicked(MouseEvent evt) {
        try {
            FilterRoomUI.getInitiatedInstance().reset();
            ReceptionistUI.setRightPanel(FilterRoomUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void checkoutDetailsLabelMouseClicked(MouseEvent evt) {
        try {
            CheckoutDetailsUI.getInitiatedInstance().reset();
            ReceptionistUI.setRightPanel(CheckoutDetailsUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void servicesChartLabelMouseClicked(MouseEvent evt) {
        try {
            ReceptionistUI.setRightPanel(new ServicesStatisticsUI());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
