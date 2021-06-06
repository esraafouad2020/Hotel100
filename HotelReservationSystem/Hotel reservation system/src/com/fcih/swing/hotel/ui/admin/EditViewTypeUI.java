package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.EditViewTypeController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
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

public final class EditViewTypeUI extends JPanel implements Drawable {

    private JButton updateViewTypeBtn;
    private JButton deleteViewTypeBtn;
    private JScrollPane viewTypeTableScrollPane;
    private JTable viewTypeTable;
    
    private static EditViewTypeUI editViewTypeUI;
    private EditViewTypeController editViewTypeController;
    
    private JOptionPane theOptionPane;
    private JDialog theDialog;

    private EditViewTypeUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {

        viewTypeTableScrollPane = new JScrollPane();
        viewTypeTable = new JTable();
        deleteViewTypeBtn = new JButton();
        updateViewTypeBtn = new JButton();
        
        editViewTypeController = ControllerCreator1.getEditViewTypeController();
    }

    @Override
    public void draw() {

        drawViewTypeTable();
        drawBtn();

        GroupLayout editViewTypePanelLayout = new GroupLayout(this);
        setLayout(editViewTypePanelLayout);
        editViewTypePanelLayout.setHorizontalGroup(
                editViewTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(editViewTypePanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(updateViewTypeBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(deleteViewTypeBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(251, Short.MAX_VALUE))
                .addGroup(editViewTypePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(viewTypeTableScrollPane)
                        .addContainerGap())
        );
        editViewTypePanelLayout.setVerticalGroup(
                editViewTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(editViewTypePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(viewTypeTableScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(editViewTypePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(updateViewTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteViewTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );
    }

    public void drawViewTypeTable() {
        viewTypeTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        viewTypeTable.getTableHeader().setOpaque(false);
        viewTypeTable.getTableHeader().setBackground(new Color(32, 136, 203));
        viewTypeTable.getTableHeader().setForeground(new Color(255, 255, 255));

        viewTypeTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "View Type Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        viewTypeTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        viewTypeTable.setFont(new Font("Tahoma", 0, 18));
        viewTypeTable.setModel(getTableModel());
        
        viewTypeTable.removeColumn(viewTypeTable.getColumnModel().getColumn(2));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        viewTypeTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 1; i < viewTypeTable.getColumnCount(); i++) {
            viewTypeTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        viewTypeTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        viewTypeTable.setRowHeight(35);
        viewTypeTable.setRowMargin(5);
        viewTypeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        viewTypeTableScrollPane.setViewportView(viewTypeTable);
    }

    private void drawBtn() {

        updateViewTypeBtn.setFont(new Font("Tahoma", 1, 18));
        updateViewTypeBtn.setText("Edit");
        updateViewTypeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        updateViewTypeBtn.addActionListener((ActionEvent) -> {
            editViewTypeBtnActionPerformed();
        });

        deleteViewTypeBtn.setFont(new Font("Tahoma", 1, 18));
        deleteViewTypeBtn.setText("Delete");
        deleteViewTypeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteViewTypeBtn.addActionListener((ActionEvent) -> {
            deleteViewTypeBtnActionPerformed();
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
        List<ViewTypeLookup> viewType = editViewTypeController.getAllViewType();
        Object[][] result = new Object[viewType.size()][3];

        for (int i = 0; i < viewType.size(); i++) {
            result[i][0] = i + 1;
            result[i][1] = viewType.get(i).getName();
            result[i][2] = viewType.get(i).getId();
        }

        return result;
    }

    private Object[] getTableHeader() {
        return new String[]{
            "Column", "Name", "ID"
        };
    }

    public void displayUpdateDialog(ViewTypeLookup viewType, boolean firstTime) {

        AddViewTypeUI updateDialog = AddViewTypeUI.getInitiatedInstance();

        if (firstTime) {
            updateDialog.getAddViewTypeBtn().setVisible(false);

            //Set Dialog With Data From Selected Row
            updateDialog.setViewTypeNameTextField(viewType.getName());
        }

        getCustomeOptionPane(updateDialog, viewType);

        updateDialog.reset();

    }

    private JOptionPane getCustomeOptionPane(AddViewTypeUI updateDialog, ViewTypeLookup viewType) {
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
            updateViewTypeBtnActionPerformed(viewType);
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
        drawViewTypeTable();
    }
    
    public static EditViewTypeUI getInitiatedInstance() {
        if (editViewTypeUI == null) {
            editViewTypeUI = new EditViewTypeUI();
        }
        return editViewTypeUI;
    }

    private void deleteViewTypeBtnActionPerformed() {
        editViewTypeController.deleteViewType();
    }
    
    private void editViewTypeBtnActionPerformed() {
        editViewTypeController.editViewTypeData();
    }
    
    private void updateViewTypeBtnActionPerformed(ViewTypeLookup viewType) {
        editViewTypeController.updateViewType(viewType);
    }

    public JTable getViewTypeTable() {
        return viewTypeTable;
    }
}
