package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.AddEmployeeController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

public final class AddEmployeeUI extends JPanel implements Drawable {

    private JLabel empNameLabel;
    private JLabel passwordLabel;
    private JLabel salaryLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;

    private JTextField empNameTextField;
    private JTextField salaryTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;

    private JPasswordField passwordField;

    private JRadioButton isSuperuserRadioButton;

    private JButton addEmpBtn;

    private AddEmployeeController addEmployeeController;
    
    private static AddEmployeeUI addEmployeeUI;
    
    private AddEmployeeUI() {
        
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        empNameLabel = new JLabel();
        passwordLabel = new JLabel();
        salaryLabel = new JLabel();
        phoneLabel = new JLabel();
        addressLabel = new JLabel();
        emailLabel = new JLabel();
        empNameTextField = new JTextField();
        salaryTextField = new JTextField();
        phoneTextField = new JTextField();
        addressTextField = new JTextField();
        emailTextField = new JTextField();
        passwordField = new JPasswordField();
        isSuperuserRadioButton = new JRadioButton();
        addEmpBtn = new JButton();
        
        addEmployeeController = ControllerCreator1.getAddEmployeeController();
    }

    @Override
    public void draw() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Employee Data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        preparePanelComponent();

        GroupLayout addEmployeePanelLayout = new GroupLayout(this);
        setLayout(addEmployeePanelLayout);
        addEmployeePanelLayout.setHorizontalGroup(
                addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(addEmployeePanelLayout.createSequentialGroup()
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(salaryLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(empNameLabel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                .addComponent(addressLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(addressTextField, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addComponent(empNameTextField)
                                .addComponent(salaryTextField))
                        .addGap(202, 202, 202)
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordField)
                                .addComponent(phoneTextField)
                                .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(addEmployeePanelLayout.createSequentialGroup()
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(isSuperuserRadioButton)
                                .addGroup(addEmployeePanelLayout.createSequentialGroup()
                                        .addGap(401, 401, 401)
                                        .addComponent(addEmpBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(409, Short.MAX_VALUE))
        );

        addEmployeePanelLayout.setVerticalGroup(
                addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, addEmployeePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(empNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addComponent(empNameTextField))
                        .addGap(110, 110, 110)
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(salaryLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(salaryTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneTextField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addGroup(addEmployeePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addComponent(isSuperuserRadioButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addEmpBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
    }

    private void preparePanelComponent() {

        empNameLabel.setFont(new Font("Tahoma", 1, 18));
        empNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        empNameLabel.setText("Username");

        empNameTextField.setFont(new Font("Tahoma", 0, 18));
        empNameTextField.setHorizontalAlignment(JTextField.CENTER);
        empNameTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        passwordLabel.setFont(new Font("Tahoma", 1, 18));
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setText("Password");

        passwordField.setFont(new Font("Tahoma", 0, 18));
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        salaryLabel.setFont(new Font("Tahoma", 1, 18));
        salaryLabel.setHorizontalAlignment(SwingConstants.LEFT);
        salaryLabel.setText("Salary");

        salaryTextField.setFont(new Font("Tahoma", 0, 18));
        salaryTextField.setHorizontalAlignment(JTextField.CENTER);
        salaryTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        phoneLabel.setFont(new Font("Tahoma", 1, 18));
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setText("Phone");

        phoneTextField.setFont(new Font("Tahoma", 0, 18));
        phoneTextField.setHorizontalAlignment(JTextField.CENTER);
        phoneTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        addressLabel.setFont(new Font("Tahoma", 1, 18));
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setText("Address");

        addressTextField.setFont(new Font("Tahoma", 0, 18));
        addressTextField.setHorizontalAlignment(JTextField.CENTER);
        addressTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        emailLabel.setFont(new Font("Tahoma", 1, 18));
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setText("Email");

        emailTextField.setFont(new Font("Tahoma", 0, 18));
        emailTextField.setHorizontalAlignment(JTextField.CENTER);
        emailTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        isSuperuserRadioButton.setFont(new Font("Tahoma", 1, 18));
        isSuperuserRadioButton.setText("Superuser");

        addEmpBtn.setFont(new Font("Tahoma", 1, 18));
        addEmpBtn.setText("Add");
        addEmpBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addEmpBtn.addActionListener((ActionEvent evt) -> {
            addEmpBtnActionPerformed(evt);
        });
    }

    private void addEmpBtnActionPerformed(ActionEvent evt) {
        addEmployeeController.addEmployee();
    }
    
    public static AddEmployeeUI getInitiatedInstance() {
        if (addEmployeeUI == null) {
            addEmployeeUI = new AddEmployeeUI();
        }
        return addEmployeeUI;
    }
    
    public void reset() {
        empNameTextField.setText(null);
        passwordField.setText(null);
        phoneTextField.setText(null);
        addressTextField.setText(null);
        salaryTextField.setText(null);
        emailTextField.setText(null);
        isSuperuserRadioButton.setSelected(false);
        addEmpBtn.setVisible(true);
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
    
    public void displayCodeDialog(Integer code) {
        JLabel label = new JLabel("Your code is " + code);
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 18)));
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(this, label, "Generated Code Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public JTextField getEmpNameTextField() {
        return empNameTextField;
    }

    public void setEmpNameTextField(String empName) {
        this.empNameTextField.setText(empName);
    }

    public JTextField getSalaryTextField() {
        return salaryTextField;
    }

    public void setSalaryTextField(String salary) {
        this.salaryTextField.setText(salary);
    }

    public JTextField getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(String phone) {
        this.phoneTextField.setText(phone);
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(String email) {
        this.emailTextField.setText(email);
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public void setAddressTextField(String address) {
        this.addressTextField.setText(address);
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(String password) {
        this.passwordField.setText(password);
    }

    public JRadioButton getIsSuperuserRadioButton() {
        return isSuperuserRadioButton;
    }

    public void setIsSuperuserRadioButton(boolean isSelected) {
        this.isSuperuserRadioButton.setSelected(isSelected);
    }

    public JButton getAddEmpBtn() {
        return addEmpBtn;
    }

    public void setAddEmpBtn(JButton addEmpBtn) {
        this.addEmpBtn = addEmpBtn;
    }
}
