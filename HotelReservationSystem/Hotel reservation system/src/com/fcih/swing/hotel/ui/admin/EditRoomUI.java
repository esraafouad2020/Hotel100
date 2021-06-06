package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.EditRoomController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
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

public final class EditRoomUI extends JPanel implements Drawable {

    private JButton updateRoomBtn;
    private JButton deleteRoomBtn;
    private JScrollPane roomTableScrollPane;
    private JTable roomTable;
    
    private JOptionPane theOptionPane;
    private JDialog theDialog;
    
    private static EditRoomUI editRoomUI;
    private EditRoomController editRoomController;

    private EditRoomUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {

        roomTableScrollPane = new JScrollPane();
        roomTable = new JTable();
        deleteRoomBtn = new JButton();
        updateRoomBtn = new JButton();
        editRoomController = ControllerCreator1.getEditRoomController();
    }

    @Override
    public void draw() {

        drawRoomTable();
        drawBtn();

        GroupLayout editRoomPanelLayout = new GroupLayout(this);
        setLayout(editRoomPanelLayout);
        editRoomPanelLayout.setHorizontalGroup(
                editRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editRoomPanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(updateRoomBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219)
                                .addComponent(deleteRoomBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(251, Short.MAX_VALUE))
                        .addGroup(editRoomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(roomTableScrollPane)
                                .addContainerGap())
        );
        editRoomPanelLayout.setVerticalGroup(
                editRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editRoomPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(roomTableScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(editRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateRoomBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteRoomBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    public void drawRoomTable() {
        roomTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        roomTable.getTableHeader().setOpaque(false);
        roomTable.getTableHeader().setBackground(new Color(32, 136, 203));
        roomTable.getTableHeader().setForeground(new Color(255, 255, 255));

        roomTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Room Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        roomTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        roomTable.setFont(new Font("Tahoma", 0, 18));
        roomTable.setModel(getTableModel());

        roomTable.removeColumn(roomTable.getColumnModel().getColumn(5));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        roomTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        
        for (int i = 1; i < roomTable.getColumnCount(); i++) {
            roomTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        roomTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        roomTable.setRowHeight(35);
        roomTable.setRowMargin(5);
        roomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        roomTableScrollPane.setViewportView(roomTable);
    }

    private void drawBtn() {

        updateRoomBtn.setFont(new Font("Tahoma", 1, 18));
        updateRoomBtn.setText("Edit");
        updateRoomBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        updateRoomBtn.addActionListener((ActionEvent) -> {
            editRoomBtnActionPerformed();
        });

        deleteRoomBtn.setFont(new Font("Tahoma", 1, 18));
        deleteRoomBtn.setText("Delete");
        deleteRoomBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteRoomBtn.addActionListener((ActionEvent) -> {
            deleteRoomBtnActionPerformed();
        });
    }

    private DefaultTableModel getTableModel() {
        return new DefaultTableModel(getTableData(), getTableHeader()) {
            Class[] types = new Class[]{
                Integer.class, String.class, Integer.class, String.class, String.class, Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
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
        List<Room> rooms = editRoomController.getAllRoom();
        Object[][] result = new Object[rooms.size()][6];

        for (int i = 0; i < rooms.size(); i++) {
            result[i][0] = i + 1;
            result[i][1] = rooms.get(i).getRoomNumber();
            result[i][2] = rooms.get(i).getCost();
            result[i][3] = rooms.get(i).getViewTypeLookup();
            result[i][4] = rooms.get(i).getRoomTypeLookup();
            result[i][5] = rooms.get(i).getId();
        }

        return result;
    }

    private Object[] getTableHeader() {
        return new String[]{
            "Column", "Name", "Cost", "Room Type", "View Type", "ID"
        };
    }

    public void displayUpdateDialog(Room room, boolean firstTime) {

        AddRoomUI updateDialog = AddRoomUI.getInitiatedInstance();

        if (firstTime) {
            updateDialog.getAddRoomBtn().setVisible(false);

            //Set Dialog With Data From Selected Row
            updateDialog.setRoomNumberTextField(room.getRoomNumber().toString());
            updateDialog.setCostTextField(room.getCost().toString());
            for (int i = 1; i < updateDialog.getRoomTypeComboBox().getItemCount(); i++) {
                RoomTypeLookup roomTypeLookup = (RoomTypeLookup) updateDialog.getRoomTypeComboBox().getItemAt(i);

                if (roomTypeLookup.getId().equals(room.getRoomTypeLookup().getId())) {
                    updateDialog.setRoomTypeComboBox(i);
                    break;
                }
            }

            for (int i = 1; i < updateDialog.getViewTypeComboBox().getItemCount(); i++) {
                ViewTypeLookup viewTypeLookup = (ViewTypeLookup) updateDialog.getViewTypeComboBox().getItemAt(i);

                if (viewTypeLookup.getId().equals(room.getViewTypeLookup().getId())) {
                    updateDialog.setViewTypeComboBox(i);
                    break;
                }
            }
        }

        getCustomeOptionPane(updateDialog, room);

        updateDialog.reset();

    }

    private JOptionPane getCustomeOptionPane(AddRoomUI updateDialog, Room room) {
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
            updateRoomBtnActionPerformed(room);
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
        drawRoomTable();
    }

    public static EditRoomUI getInitiatedInstance() {
        if (editRoomUI == null) {
            editRoomUI = new EditRoomUI();
        }
        return editRoomUI;
    }

    public JTable getRoomTable() {
        return roomTable;
    }

    private void deleteRoomBtnActionPerformed() {
        editRoomController.deleteRoom();
    }

    private void editRoomBtnActionPerformed() {
        editRoomController.editRoomData();
    }

    private void updateRoomBtnActionPerformed(Room room) {
        editRoomController.updateRoom(room);
    }
}
