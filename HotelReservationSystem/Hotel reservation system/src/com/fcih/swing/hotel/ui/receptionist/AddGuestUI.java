package com.fcih.swing.hotel.ui.receptionist;

import com.fcih.swing.hotel.ui.Drawable;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public final class AddGuestUI extends JPanel implements Drawable {

    private JLabel guestNameLabel;
    private JLabel countryLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JLabel roomTypeLabel;
    private JLabel viewTypeLabel;
    private JLabel roomNumberLabel;
    private JLabel priceLabel;
    private JLabel totalCostLabel;

    private JTextField guestNameTextField;
    private JTextField countryTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;

    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;

    private JComboBox roomTypeComboBox;
    private JComboBox viewTypeComboBox;
    private JComboBox roomNumberComboBox;

    private JButton addGuestBtn;
    private JButton printDetailstBtn;

    public AddGuestUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        guestNameLabel = new JLabel();
        countryLabel = new JLabel();
        startDateLabel = new JLabel();
        phoneLabel = new JLabel();
        emailLabel = new JLabel();
        startDateLabel = new JLabel();
        endDateLabel = new JLabel();
        roomTypeLabel = new JLabel();
        viewTypeLabel = new JLabel();
        roomNumberLabel = new JLabel();
        priceLabel = new JLabel();
        totalCostLabel = new JLabel();

        guestNameTextField = new JTextField();
        countryTextField = new JTextField();
        phoneTextField = new JTextField();
        emailTextField = new JTextField();

        startDateChooser = new JDateChooser();
        endDateChooser = new JDateChooser();

        roomTypeComboBox = new JComboBox();
        viewTypeComboBox = new JComboBox();
        roomNumberComboBox = new JComboBox();

        addGuestBtn = new JButton();
        printDetailstBtn = new JButton();
    }

    @Override
    public void draw() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Guest Data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));
        setPreferredSize(new Dimension(1215, 473));
        
        preparePanelComponent();

        javax.swing.GroupLayout addGuestPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(addGuestPanelLayout);
        addGuestPanelLayout.setHorizontalGroup(
                addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addGuestPanelLayout.createSequentialGroup()
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guestNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addComponent(guestNameTextField)
                                .addComponent(emailTextField)
                                .addComponent(roomTypeComboBox)
                                .addComponent(roomNumberComboBox))
                        .addGap(135, 135, 135)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(endDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(countryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(viewTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                .addComponent(totalCostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(countryTextField)
                                .addComponent(phoneTextField)
                                .addComponent(endDateChooser)
                                .addComponent(viewTypeComboBox)
                                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addGap(40, 40, 40))
                .addGroup(addGuestPanelLayout.createSequentialGroup()
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addGuestPanelLayout.createSequentialGroup()
                                        .addGap(300, 300, 300)
                                        .addComponent(printDetailstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(300, 300, 300)
                                        .addComponent(addGuestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(200, Short.MAX_VALUE))
        );
        
        addGuestPanelLayout.setVerticalGroup(
                addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGuestPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(countryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guestNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(countryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addComponent(guestNameTextField))
                        .addGap(70, 70, 70)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(startDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(endDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roomTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(addGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roomNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomNumberComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalCostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(addGuestPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(printDetailstBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addGuestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );
    }

    private void preparePanelComponent() {

        guestNameLabel.setFont(new Font("Tahoma", 1, 18));
        guestNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        guestNameLabel.setText("Name");

        guestNameTextField.setFont(new Font("Tahoma", 0, 18));
        guestNameTextField.setHorizontalAlignment(JTextField.CENTER);
        guestNameTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        countryLabel.setFont(new Font("Tahoma", 1, 18));
        countryLabel.setHorizontalAlignment(SwingConstants.LEFT);
        countryLabel.setText("Country");

        countryTextField.setFont(new Font("Tahoma", 0, 18));
        countryTextField.setHorizontalAlignment(JTextField.CENTER);
        countryTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        phoneLabel.setFont(new Font("Tahoma", 1, 18));
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setText("Phone");

        phoneTextField.setFont(new Font("Tahoma", 0, 18));
        phoneTextField.setHorizontalAlignment(JTextField.CENTER);
        phoneTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        emailLabel.setFont(new Font("Tahoma", 1, 18));
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setText("Email");

        emailTextField.setFont(new Font("Tahoma", 0, 18));
        emailTextField.setHorizontalAlignment(JTextField.CENTER);
        emailTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        startDateLabel.setFont(new Font("Tahoma", 1, 18));
        startDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        startDateLabel.setText("Start Date");

        startDateChooser.setFont(new Font("Tahoma", 1, 18));

        endDateLabel.setFont(new Font("Tahoma", 1, 18));
        endDateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        endDateLabel.setText("End Date");

        endDateChooser.setFont(new Font("Tahoma", 1, 18));

        viewTypeLabel.setFont(new Font("Tahoma", 1, 18));
        viewTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        viewTypeLabel.setText("View Type");

        viewTypeComboBox.setFont(new Font("Tahoma", 1, 18));
        viewTypeComboBox.setModel(new DefaultComboBoxModel(new String[]{"  -- Please Select Value --", "View_1", "View_2", "View_3", "View_4"}));
        viewTypeComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED)), BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1))));
        viewTypeComboBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        roomTypeLabel.setFont(new Font("Tahoma", 1, 18));
        roomTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomTypeLabel.setText("Room Type");

        roomTypeComboBox.setFont(new Font("Tahoma", 1, 18));
        roomTypeComboBox.setModel(new DefaultComboBoxModel(new String[]{"  -- Please Select Value --", "View_1", "View_2", "View_3", "View_4"}));
        roomTypeComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED)), BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1))));
        roomTypeComboBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        roomNumberLabel.setFont(new Font("Tahoma", 1, 18));
        roomNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomNumberLabel.setText("Room Number");

        roomNumberComboBox.setFont(new Font("Tahoma", 1, 18));
        roomNumberComboBox.setModel(new DefaultComboBoxModel(new String[]{"  -- Please Select Value --", "View_1", "View_2", "View_3", "View_4"}));
        roomNumberComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED)), BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1))));
        roomNumberComboBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        totalCostLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        totalCostLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCostLabel.setForeground(Color.red);
        totalCostLabel.setText("Total Cost Is :");

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel.setForeground(Color.blue);
        priceLabel.setText("2000");

        addGuestBtn.setFont(new Font("Tahoma", 1, 18));
        addGuestBtn.setText("Add");
        addGuestBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addGuestBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        printDetailstBtn.setFont(new Font("Tahoma", 1, 18));
        printDetailstBtn.setText("Print Details");
        printDetailstBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        printDetailstBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
