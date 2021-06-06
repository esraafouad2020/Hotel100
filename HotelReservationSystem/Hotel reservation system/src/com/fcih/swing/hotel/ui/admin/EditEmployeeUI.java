package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.EditEmployeeController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.Employee;
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

public final class EditEmployeeUI extends JPanel implements Drawable {

    private JButton editEmpBtn;
    private JButton deleteEmpBtn;
    private JScrollPane empTableScrollPane;
    private JTable employeeTable;
    private EditEmployeeController editEmployeeController;
    private static EditEmployeeUI editEmployeeUI;
    private JOptionPane theOptionPane;
    private JDialog theDialog;

    private EditEmployeeUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {

        empTableScrollPane = new JScrollPane();
        employeeTable = new JTable();
        deleteEmpBtn = new JButton();
        editEmpBtn = new JButton();
        editEmployeeController = ControllerCreator1.getEditEmployeeController();
    }

    @Override
    public void draw() {

        drawEmployeeTable();
        drawBtn();

        GroupLayout editEmployeePanelLayout = new GroupLayout(this);
        setLayout(editEmployeePanelLayout);
        editEmployeePanelLayout.setHorizontalGroup(
                editEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editEmployeePanelLayout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(editEmpBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addGap(219, 219, 219)
                                .addComponent(deleteEmpBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(251, Short.MAX_VALUE))
                        .addGroup(editEmployeePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(empTableScrollPane)
                                .addContainerGap())
        );
        editEmployeePanelLayout.setVerticalGroup(
                editEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(editEmployeePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(empTableScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(editEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(editEmpBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteEmpBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    public void drawEmployeeTable() {
        employeeTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        employeeTable.getTableHeader().setOpaque(false);
        employeeTable.getTableHeader().setBackground(new Color(32, 136, 203));
        employeeTable.getTableHeader().setForeground(new Color(255, 255, 255));

        empTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Employee Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        employeeTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        employeeTable.setFont(new Font("Tahoma", 0, 18));
        employeeTable.setModel(getTableModel());

        employeeTable.removeColumn(employeeTable.getColumnModel().getColumn(8));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        employeeTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 1; i < employeeTable.getColumnCount(); i++) {
            employeeTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        employeeTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        employeeTable.setRowHeight(35);
        employeeTable.setRowMargin(5);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        empTableScrollPane.setViewportView(employeeTable);
    }

    private void drawBtn() {

        editEmpBtn.setFont(new Font("Tahoma", 1, 18));
        editEmpBtn.setText("Edit");
        editEmpBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        editEmpBtn.addActionListener((ActionEvent) -> {
            editEmpBtnActionPerformed();
        });

        deleteEmpBtn.setFont(new Font("Tahoma", 1, 18));
        deleteEmpBtn.setText("Delete");
        deleteEmpBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteEmpBtn.addActionListener((ActionEvent) -> {
            deleteEmpBtnActionPerformed();
        });
    }

    private DefaultTableModel getTableModel() {
        return new DefaultTableModel(getTableData(), getTableHeader()) {
            Class[] types = new Class[]{
                Integer.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class, Boolean.class, Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false
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
        List<Employee> employees = editEmployeeController.getAllEmployee();
        Object[][] result = new Object[employees.size()][9];

        for (int i = 0; i < employees.size(); i++) {
            result[i][0] = i + 1;
            result[i][1] = employees.get(i).getName();
            result[i][2] = employees.get(i).getCode();
            result[i][3] = employees.get(i).getSalary();
            result[i][4] = employees.get(i).getPhone();
            result[i][5] = employees.get(i).getMail();
            result[i][6] = employees.get(i).getAddress();
            result[i][7] = employees.get(i).getSuperuser();
            result[i][8] = employees.get(i).getId();
        }

        return result;
    }

    private Object[] getTableHeader() {
        return new String[]{
            "Column", "Name", "Code", "Salary", "Phone", "Email", "Adrdress", "Is Superuser", "ID"
        };
    }

    public void displayUpdateDialog(Employee employee, boolean firstTime) {

        AddEmployeeUI updateDialog = AddEmployeeUI.getInitiatedInstance();
        updateDialog.getAddEmpBtn().setVisible(false);

        if (firstTime) {
            //Set Dialog With Data From Selected Row
            updateDialog.setEmpNameTextField(employee.getName());
            updateDialog.setSalaryTextField(employee.getSalary() != null ? employee.getSalary().toString() : null);
            updateDialog.setPhoneTextField(employee.getPhone() != null ? "0" + employee.getPhone().toString() : null);
            updateDialog.setEmailTextField(employee.getMail());
            updateDialog.setAddressTextField(employee.getAddress());
            if (employee.getSuperuser() != null && employee.getSuperuser().equalsIgnoreCase("Y")) {
                updateDialog.setIsSuperuserRadioButton(true);
            } else {
                updateDialog.setIsSuperuserRadioButton(false);
            }
        }

        getCustomeOptionPane(updateDialog, employee);

        updateDialog.reset();
    }

    private JOptionPane getCustomeOptionPane(AddEmployeeUI updateDialog, Employee employee) {
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
            updateEmpBtnActionPerformed(employee);
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
        JOptionPane.showMessageDialog(this, label, "Correct Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayValidationDialog(String msg) {
        JLabel label = new JLabel(msg);
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        label.setForeground(Color.red);
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 18)));
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(this, label, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
    
    public void reset() {
        drawEmployeeTable();
    }

    private void deleteEmpBtnActionPerformed() {
        editEmployeeController.deleteEmployee();
    }

    private void editEmpBtnActionPerformed() {
        editEmployeeController.editEmployeeData();
    }

    private void updateEmpBtnActionPerformed(Employee employee) {
        editEmployeeController.updateEmployee(employee);
    }

    public static EditEmployeeUI getInitiatedInstance() {
        if (editEmployeeUI == null) {
            editEmployeeUI = new EditEmployeeUI();
        }
        return editEmployeeUI;
    }

    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public void setEmployeeTable(JTable employeeTable) {
        this.employeeTable = employeeTable;
    }
}
