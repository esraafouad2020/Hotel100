package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.EditRoomTypeController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class EditRoomTypeUI extends JPanel implements Drawable {

    private JButton updateRoomTypeBtn;
    private JButton deleteRoomTypeBtn;
    private JScrollPane roomTypeTableScrollPane;
    private JTable roomTypeTable;

    private static EditRoomTypeUI editRoomTypeUI;
    private EditRoomTypeController editRoomTypeController;
    
    private JOptionPane theOptionPane;
    private JDialog theDialog;
    
    private EditRoomTypeUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {

        roomTypeTableScrollPane = new JScrollPane();
        roomTypeTable = new JTable();
        deleteRoomTypeBtn = new JButton();
        updateRoomTypeBtn = new JButton();
        editRoomTypeController = ControllerCreator1.getEditRoomTypeController();
    }

    @Override
    public void draw() {

        drawRoomTypeTable();
        drawBtn();

        GroupLayout editRoomTypePanelLayout = new GroupLayout(this);
        setLayout(editRoomTypePanelLayout);
        editRoomTypePanelLayout.setHorizontalGroup(
                editRoomTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editRoomTypePanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(updateRoomTypeBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219)
                                .addComponent(deleteRoomTypeBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(251, Short.MAX_VALUE))
                        .addGroup(editRoomTypePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(roomTypeTableScrollPane)
                                .addContainerGap())
        );
        editRoomTypePanelLayout.setVerticalGroup(
                editRoomTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editRoomTypePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(roomTypeTableScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(editRoomTypePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateRoomTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteRoomTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    public void drawRoomTypeTable() {
        roomTypeTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        roomTypeTable.getTableHeader().setOpaque(false);
        roomTypeTable.getTableHeader().setBackground(new Color(32, 136, 203));
        roomTypeTable.getTableHeader().setForeground(new Color(255, 255, 255));

        roomTypeTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Room Type Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        roomTypeTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        roomTypeTable.setFont(new Font("Tahoma", 0, 18));
        roomTypeTable.setModel(getTableModel());
        
        roomTypeTable.removeColumn(roomTypeTable.getColumnModel().getColumn(2));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        roomTypeTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 1; i < roomTypeTable.getColumnCount(); i++) {
            roomTypeTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        roomTypeTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        roomTypeTable.setRowHeight(35);
        roomTypeTable.setRowMargin(5);
        roomTypeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        roomTypeTableScrollPane.setViewportView(roomTypeTable);
    }

    private void drawBtn() {

        updateRoomTypeBtn.setFont(new Font("Tahoma", 1, 18));
        updateRoomTypeBtn.setText("Edit");
        updateRoomTypeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        updateRoomTypeBtn.addActionListener((ActionEvent) -> {
            editRoomTypeBtnActionPerformed();
        });

        deleteRoomTypeBtn.setFont(new Font("Tahoma", 1, 18));
        deleteRoomTypeBtn.setText("Delete");
        deleteRoomTypeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteRoomTypeBtn.addActionListener((ActionEvent) -> {
            deleteRoomTypeBtnActionPerformed();
        });
    }

    private DefaultTableModel getTableModel() {
        return new DefaultTableModel(getTableData(), getTableHeader()) {
            Class[] types = new Class[]{
                Integer.class, String.class, Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private Object[][] getTableData() {
        List<RoomTypeLookup> roomsType = editRoomTypeController.getAllRoomType();
        Object[][] result = new Object[roomsType.size()][3];

        for (int i = 0; i < roomsType.size(); i++) {
            result[i][0] = i + 1;
            result[i][1] = roomsType.get(i).getName();
            result[i][2] = roomsType.get(i).getId();
        }

        return result;
    }

    private Object[] getTableHeader() {
        return new String[]{
            "Column", "Name", "ID"
        };
    }

    public void displayUpdateDialog(RoomTypeLookup roomType, boolean firstTime) {

        AddRoomTypeUI updateDialog = AddRoomTypeUI.getInitiatedInstance();

        if (firstTime) {
            updateDialog.getAddRoomTypeBtn().setVisible(false);

            //Set Dialog With Data From Selected Row
            updateDialog.setRoomTypeNameTextField(roomType.getName());
        }

        getCustomeOptionPane(updateDialog, roomType);

        updateDialog.reset();

    }

    private JOptionPane getCustomeOptionPane(AddRoomTypeUI updateDialog, RoomTypeLookup roomType) {
        String[] options = {"Update", "Cancel"};
        theOptionPane = new JOptionPane(updateDialog, JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, new ImageIcon("src/imgs/updateImg.png"), options, options[1]);
        JPanel buttonsPanel = (JPanel) theOptionPane.getComponent(1);
        JButton buttonUpdate = (JButton) buttonsPanel.getComponent(0);
        JButton buttonCancel = (JButton) buttonsPanel.getComponent(1);

        buttonUpdate.setText(" Update ");
        buttonUpdate.setPreferredSize(new Dimension(193, 61));
        buttonUpdate.setFont(new Font("Tahoma", 1, 18));
        buttonUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonUpdate.validate();
        buttonUpdate.addActionListener((ActionEvent) -> {
            updateRoomTypeBtnActionPerformed(roomType);
        });

        buttonCancel.setText(" Cancel ");
        buttonCancel.setPreferredSize(new Dimension(193, 61));
        buttonCancel.setFont(new Font("Tahoma", 1, 18));
        buttonCancel.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonCancel.validate();

        if (theDialog == null) {
            theDialog = theOptionPane.createDialog(null, "Update Employee");
            theDialog.setVisible(true);
        } else {
            theDialog.setVisible(false);
            theDialog = theOptionPane.createDialog(null, "Update Employee");
            theDialog.setVisible(true);
        }

        return theOptionPane;
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
        drawRoomTypeTable();
    }

    public static EditRoomTypeUI getInitiatedInstance() {
        if (editRoomTypeUI == null) {
            editRoomTypeUI = new EditRoomTypeUI();
        }
        return editRoomTypeUI;
    }

    private void deleteRoomTypeBtnActionPerformed() {
        editRoomTypeController.deleteRoomType();
    }
    
    private void editRoomTypeBtnActionPerformed() {
        editRoomTypeController.editRoomTypeData();
    }
    
    private void updateRoomTypeBtnActionPerformed(RoomTypeLookup roomType) {
        editRoomTypeController.updateRoomType(roomType);
    }

    public JTable getRoomTypeTable() {
        return roomTypeTable;
    }

}
