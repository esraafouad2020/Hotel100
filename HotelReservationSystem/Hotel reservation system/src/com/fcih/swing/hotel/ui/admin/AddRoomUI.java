package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.AddRoomController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public final class AddRoomUI extends JPanel implements Drawable {

    private JLabel roomNumberLabel;
    private JTextField roomNumberTextField;

    private JLabel costLabel;
    private JTextField costTextField;

    private JComboBox roomTypeComboBox;
    private JLabel roomTypeLabel;

    private JComboBox viewTypeComboBox;
    private JLabel viewTypeLabel;

    private JButton addRoomBtn;
    private AddRoomController addRoomController;
    
    private static AddRoomUI addRoomUI;

    private AddRoomUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        roomNumberLabel = new JLabel();
        roomNumberTextField = new JTextField();

        costLabel = new JLabel();
        costTextField = new JTextField();

        viewTypeLabel = new JLabel();
        viewTypeComboBox = new JComboBox();

        roomTypeLabel = new JLabel();
        roomTypeComboBox = new JComboBox();

        addRoomBtn = new JButton();
        
        addRoomController = ControllerCreator1.getAddRoomController();
    }

    @Override
    public void draw() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Room Data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        preparePanelComponent();

        GroupLayout addRoomPanelLayout = new GroupLayout(this);
        setLayout(addRoomPanelLayout);
        addRoomPanelLayout.setHorizontalGroup(
                addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(addRoomPanelLayout.createSequentialGroup()
                        .addGroup(addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(viewTypeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomNumberLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(roomNumberTextField)
                                .addComponent(viewTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(202, 202, 202)
                        .addGroup(addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(roomTypeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(costLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(costTextField)
                                .addComponent(roomTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(addRoomPanelLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(addRoomBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(432, Short.MAX_VALUE))
        );
        addRoomPanelLayout.setVerticalGroup(
                addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, addRoomPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(costLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(roomNumberLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(costTextField, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addComponent(roomNumberTextField))
                        .addGap(110, 110, 110)
                        .addGroup(addRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(viewTypeLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomTypeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addComponent(viewTypeComboBox, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomTypeComboBox, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addRoomBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
    }

    private void preparePanelComponent() {
        roomNumberLabel.setFont(new Font("Tahoma", 1, 18));
        roomNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomNumberLabel.setText("Room Number");

        roomNumberTextField.setFont(new Font("Tahoma", 0, 18));
        roomNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        roomNumberTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        costLabel.setFont(new Font("Tahoma", 1, 18));
        costLabel.setHorizontalAlignment(SwingConstants.LEFT);
        costLabel.setText("Cost");

        costTextField.setFont(new Font("Tahoma", 0, 18));
        costTextField.setHorizontalAlignment(JTextField.CENTER);
        costTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        viewTypeLabel.setFont(new Font("Tahoma", 1, 18));
        viewTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        viewTypeLabel.setText("View Type");
        viewTypeLabel.setToolTipText("");

        roomTypeLabel.setFont(new Font("Tahoma", 1, 18));
        roomTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomTypeLabel.setText("Room Type");

        addRoomBtn.setFont(new Font("Tahoma", 1, 18));
        addRoomBtn.setText("Add");
        addRoomBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addRoomBtn.addActionListener(((ActionEvent evt) -> {
            addRoomBtnActionPerformed(evt);
        }));

        viewTypeComboBox.setFont(new Font("Tahoma", 1, 18));
        viewTypeComboBox.setModel(getViewTypeComboBoxModel());
        viewTypeComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED)), BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1))));
        viewTypeComboBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        
        roomTypeComboBox.setFont(new Font("Tahoma", 1, 18));
        roomTypeComboBox.setModel(getRoomTypeComboBoxModel());
        roomTypeComboBox.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED)), BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), BorderFactory.createEmptyBorder(1, 1, 1, 1))));
        roomTypeComboBox.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    private DefaultComboBoxModel getViewTypeComboBoxModel() {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement("    -- Please Select --  ");
        
        for(ViewTypeLookup viewType : addRoomController.getAllViewTypes()) {
            defaultComboBoxModel.addElement(viewType);
        }
        
        return defaultComboBoxModel;
    }
    
    private DefaultComboBoxModel getRoomTypeComboBoxModel() {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement("    -- Please Select --  ");
        
        for(RoomTypeLookup roomType : addRoomController.getAllRoomTypes()) {
            defaultComboBoxModel.addElement(roomType);
        }
        
        return defaultComboBoxModel;
    }
    
    public void displayErrorDialog(String msg) {
        JLabel label = new JLabel(msg);
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 18)));
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(this, label, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
    
    public void displayCorrectDialog(String msg) {
        JLabel label = new JLabel(msg);
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 18)));
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(this, label, "Information Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void reset() {
        costTextField.setText(null);
        roomNumberTextField.setText(null);
        viewTypeComboBox.setModel(getViewTypeComboBoxModel());
        roomTypeComboBox.setModel(getRoomTypeComboBoxModel());
        addRoomBtn.setVisible(true);
    }
    
    public static AddRoomUI getInitiatedInstance() {
        if (addRoomUI == null) {
            addRoomUI = new AddRoomUI();
        }
        return addRoomUI;
    }

    private void addRoomBtnActionPerformed(ActionEvent evt) {
        addRoomController.addRoom();
    }

    public JTextField getRoomNumberTextField() {
        return roomNumberTextField;
    }

    public void setRoomNumberTextField(String roomNumber) {
        roomNumberTextField.setText(roomNumber);
    }

    public JTextField getCostTextField() {
        return costTextField;
    }

    public void setCostTextField(String cost) {
        this.costTextField.setText(cost);
    }

    public JComboBox getRoomTypeComboBox() {
        return roomTypeComboBox;
    }

    public JComboBox getViewTypeComboBox() {
        return viewTypeComboBox;
    }
    
    public void setRoomTypeComboBox(int selectedRoomType) {
        roomTypeComboBox.setSelectedIndex(selectedRoomType);
    }
    
    public void setViewTypeComboBox(int selectedViewType) {
        viewTypeComboBox.setSelectedIndex(selectedViewType);
    }

    public JButton getAddRoomBtn() {
        return addRoomBtn;
    }
}
