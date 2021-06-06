package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.AddServiceController;
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

public final class AddServiceUI extends JPanel implements Drawable {

    private JLabel serviceCostLabel;
    private JLabel serviceNameLabel;

    private JTextField serviceNameTextField;
    private JTextField serviceCostTextField;

    private JButton addServiceBtn;

    private static AddServiceUI addServiceUI;
    
    private AddServiceController addServiceController;

    private AddServiceUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        serviceNameLabel = new JLabel();
        serviceCostLabel = new JLabel();
        serviceNameTextField = new JTextField();
        serviceCostTextField = new JTextField();
        addServiceBtn = new JButton();
        addServiceController = ControllerCreator1.getAddServiceController();
    }

    @Override
    public void draw() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Service Data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        preparePanelComponent();

        GroupLayout addServicePanelLayout = new GroupLayout(this);
        setLayout(addServicePanelLayout);
        addServicePanelLayout.setHorizontalGroup(
                addServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addServicePanelLayout.createSequentialGroup()
                                .addComponent(serviceNameLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(serviceNameTextField, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202)
                                .addComponent(serviceCostLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(serviceCostTextField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(addServicePanelLayout.createSequentialGroup()
                                .addGap(401, 401, 401)
                                .addComponent(addServiceBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(409, Short.MAX_VALUE))
        );
        addServicePanelLayout.setVerticalGroup(
                addServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, addServicePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(serviceCostLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(serviceNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(serviceCostTextField, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(serviceNameTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addServiceBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    private void preparePanelComponent() {

        serviceNameLabel.setFont(new Font("Tahoma", 1, 18));
        serviceNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        serviceNameLabel.setText("Name");

        serviceNameTextField.setFont(new Font("Tahoma", 0, 18));
        serviceNameTextField.setHorizontalAlignment(JTextField.CENTER);
        serviceNameTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        serviceCostLabel.setFont(new Font("Tahoma", 1, 18));
        serviceCostLabel.setHorizontalAlignment(SwingConstants.LEFT);
        serviceCostLabel.setText("Cost");

        serviceCostTextField.setFont(new Font("Tahoma", 0, 18));
        serviceCostTextField.setHorizontalAlignment(JTextField.CENTER);
        serviceCostTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        addServiceBtn.setFont(new Font("Tahoma", 1, 18));
        addServiceBtn.setText("Add");
        addServiceBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addServiceBtn.addActionListener(((ActionEvent) -> {
            addServiceBtnActionPerformed();
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
    
    public void reset() {
        serviceCostTextField.setText(null);
        serviceNameTextField.setText(null);
        addServiceBtn.setVisible(true);
    }

    public static AddServiceUI getInitiatedInstance() {
        if (addServiceUI == null) {
            addServiceUI = new AddServiceUI();
        }
        return addServiceUI;
    }

    private void addServiceBtnActionPerformed() {
        addServiceController.addService();
    }

    public JTextField getServiceNameTextField() {
        return serviceNameTextField;
    }

    public void setServiceNameTextField(String name) {
        this.serviceNameTextField.setText(name);
    }

    public JTextField getServiceCostTextField() {
        return serviceCostTextField;
    }

    public void setServiceCostTextField(String cost) {
        this.serviceCostTextField.setText(cost);
    }

    public JButton getAddServiceBtn() {
        return addServiceBtn;
    }
}
