package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.AddRoomTypeController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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

public final class AddRoomTypeUI extends JPanel implements Drawable {
    
    private JLabel roomTypeNameLabel;

    private JTextField roomTypeNameTextField;

    private JButton addRoomTypeBtn;
    
    private static AddRoomTypeUI addRoomTypeUI;
    
    private AddRoomTypeController addRoomTypeController;

    private AddRoomTypeUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        roomTypeNameLabel = new JLabel();
        roomTypeNameTextField = new JTextField();
        addRoomTypeBtn = new JButton();
        addRoomTypeController = ControllerCreator1.getAddRoomTypeController();
    }

    @Override
    public void draw() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Room Type Data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        preparePanelComponent();

        GroupLayout addRoomTypePanelLayout = new GroupLayout(this);
        setLayout(addRoomTypePanelLayout);
        addRoomTypePanelLayout.setHorizontalGroup(
                addRoomTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addRoomTypePanelLayout.createSequentialGroup()
                                .addComponent(roomTypeNameLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(roomTypeNameTextField, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                        .addGroup(addRoomTypePanelLayout.createSequentialGroup()
                                .addGap(401, 401, 401)
                                .addComponent(addRoomTypeBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(409, Short.MAX_VALUE))
        );
        addRoomTypePanelLayout.setVerticalGroup(
                addRoomTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, addRoomTypePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addRoomTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(roomTypeNameLabel, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(roomTypeNameTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addRoomTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    private void preparePanelComponent() {

        roomTypeNameLabel.setFont(new Font("Tahoma", 1, 18));
        roomTypeNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roomTypeNameLabel.setText("Name");

        roomTypeNameTextField.setFont(new Font("Tahoma", 0, 18));
        roomTypeNameTextField.setHorizontalAlignment(JTextField.CENTER);
        roomTypeNameTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        addRoomTypeBtn.setFont(new Font("Tahoma", 1, 18));
        addRoomTypeBtn.setText("Add");
        addRoomTypeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addRoomTypeBtn.addActionListener(((ActionEvent) -> {
            addRoomTypeBtnActionPerformed();
        }));
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
    
    private void addRoomTypeBtnActionPerformed() {
        addRoomTypeController.addRoomType();
    }
    
    public void reset() {
        roomTypeNameTextField.setText(null);
    }

    public static AddRoomTypeUI getInitiatedInstance() {
        if (addRoomTypeUI == null) {
            addRoomTypeUI = new AddRoomTypeUI();
        }
        return addRoomTypeUI;
    }

    public JTextField getRoomTypeNameTextField() {
        return roomTypeNameTextField;
    }

    public void setRoomTypeNameTextField(String name) {
        this.roomTypeNameTextField.setText(name);
    }

    public JButton getAddRoomTypeBtn() {
        return addRoomTypeBtn;
    }
}
