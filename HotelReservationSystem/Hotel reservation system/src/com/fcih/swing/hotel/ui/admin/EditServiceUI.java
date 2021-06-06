package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.EditServiceController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.Service;
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

public final class EditServiceUI extends JPanel implements Drawable {

    private JButton updateServiceBtn;
    private JButton deleteServiceBtn;
    private JScrollPane serviceTableScrollPane;
    private JTable serviceTable;

    private static EditServiceUI editServiceUI;
    private EditServiceController editServiceController;
    
    private JOptionPane theOptionPane;
    private JDialog theDialog;

    private EditServiceUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {

        serviceTableScrollPane = new JScrollPane();
        serviceTable = new JTable();
        deleteServiceBtn = new JButton();
        updateServiceBtn = new JButton();
        editServiceController = ControllerCreator1.getEditServiceController();
    }

    @Override
    public void draw() {

        drawServiceTable();
        drawBtn();

        GroupLayout editServicePanelLayout = new GroupLayout(this);
        setLayout(editServicePanelLayout);
        editServicePanelLayout.setHorizontalGroup(
                editServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editServicePanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(updateServiceBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219)
                                .addComponent(deleteServiceBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(251, Short.MAX_VALUE))
                        .addGroup(editServicePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(serviceTableScrollPane)
                                .addContainerGap())
        );
        editServicePanelLayout.setVerticalGroup(
                editServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editServicePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(serviceTableScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(editServicePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateServiceBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteServiceBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    public void drawServiceTable() {
        serviceTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        serviceTable.getTableHeader().setOpaque(false);
        serviceTable.getTableHeader().setBackground(new Color(32, 136, 203));
        serviceTable.getTableHeader().setForeground(new Color(255, 255, 255));

        serviceTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Service Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        serviceTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        serviceTable.setFont(new Font("Tahoma", 0, 18));
        serviceTable.setModel(getTableModel());
        
        serviceTable.removeColumn(serviceTable.getColumnModel().getColumn(3));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        serviceTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 1; i < serviceTable.getColumnCount(); i++) {
            serviceTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        serviceTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        serviceTable.setRowHeight(35);
        serviceTable.setRowMargin(5);
        serviceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        serviceTableScrollPane.setViewportView(serviceTable);
    }

    private void drawBtn() {

        updateServiceBtn.setFont(new Font("Tahoma", 1, 18));
        updateServiceBtn.setText("Edit");
        updateServiceBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        updateServiceBtn.addActionListener((ActionEvent) -> {
            editServiceBtnActionPerformed();
        });

        deleteServiceBtn.setFont(new Font("Tahoma", 1, 18));
        deleteServiceBtn.setText("Delete");
        deleteServiceBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteServiceBtn.addActionListener((ActionEvent) -> {
            deleteServiceBtnActionPerformed();
        });
    }

    private DefaultTableModel getTableModel() {
        return new DefaultTableModel(getTableData(), getTableHeader()) {
            Class[] types = new Class[]{
                Integer.class, String.class, Integer.class, Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
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
        List<Service> service = editServiceController.getAllService();
        Object[][] result = new Object[service.size()][4];

        for (int i = 0; i < service.size(); i++) {
            result[i][0] = i + 1;
            result[i][1] = service.get(i).getName();
            result[i][2] = service.get(i).getCost();
            result[i][3] = service.get(i).getId();
        }

        return result;
    }

    private Object[] getTableHeader() {

        return new String[]{
            "Column", "Name", "Cost", "ID"
        };
    }
    
    public void displayUpdateDialog(Service service, boolean firstTime) {

        AddServiceUI updateDialog = AddServiceUI.getInitiatedInstance();

        if (firstTime) {
            updateDialog.getAddServiceBtn().setVisible(false);

            //Set Dialog With Data From Selected Row
            updateDialog.setServiceNameTextField(service.getName());
            updateDialog.setServiceCostTextField(service.getCost().toString());
        }

        getCustomeOptionPane(updateDialog, service);

        updateDialog.reset();

    }

    private JOptionPane getCustomeOptionPane(AddServiceUI updateDialog, Service service) {
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
            updateServiceBtnActionPerformed(service);
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
        drawServiceTable();
    }

    public static EditServiceUI getInitiatedInstance() {
        if (editServiceUI == null) {
            editServiceUI = new EditServiceUI();
        }
        return editServiceUI;
    }

    private void deleteServiceBtnActionPerformed() {
        editServiceController.deleteService();
    }

    private void editServiceBtnActionPerformed() {
        editServiceController.editServiceData();
    }
    
    private void updateServiceBtnActionPerformed(Service service) {
        editServiceController.updateService(service);
    }

    public JTable getServiceTable() {
        return serviceTable;
    }
}
