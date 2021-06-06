package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.controller.AddViewTypeController;
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

public final class AddViewTypeUI extends JPanel implements Drawable {

    private JLabel viewTypeNameLabel;
    private JTextField viewTypeNameTextField;

    private JButton addViewTypeBtn;

    private static AddViewTypeUI addViewTypeUI;

    private AddViewTypeController addViewTypeController;

    private AddViewTypeUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        viewTypeNameLabel = new JLabel();
        viewTypeNameTextField = new JTextField();
        addViewTypeBtn = new JButton();

        addViewTypeController = ControllerCreator1.getAddViewTypeController();
    }

    @Override
    public void draw() {
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "View Type Data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        preparePanelComponent();

        GroupLayout addViewTypePanelLayout = new GroupLayout(this);
        setLayout(addViewTypePanelLayout);
        addViewTypePanelLayout.setHorizontalGroup(
                addViewTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addViewTypePanelLayout.createSequentialGroup()
                                .addComponent(viewTypeNameLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(viewTypeNameTextField, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                        .addGroup(addViewTypePanelLayout.createSequentialGroup()
                                .addGap(401, 401, 401)
                                .addComponent(addViewTypeBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(409, Short.MAX_VALUE))
        );
        addViewTypePanelLayout.setVerticalGroup(
                addViewTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, addViewTypePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addViewTypePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(viewTypeNameLabel, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                        .addComponent(viewTypeNameTextField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addViewTypeBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    private void preparePanelComponent() {

        viewTypeNameLabel.setFont(new Font("Tahoma", 1, 18));
        viewTypeNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        viewTypeNameLabel.setText("Name");

        viewTypeNameTextField.setFont(new Font("Tahoma", 0, 18));
        viewTypeNameTextField.setHorizontalAlignment(JTextField.CENTER);
        viewTypeNameTextField.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        addViewTypeBtn.setFont(new Font("Tahoma", 1, 18));
        addViewTypeBtn.setText("Add");
        addViewTypeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        addViewTypeBtn.addActionListener(((ActionEvent) -> {
            addViewTypeBtnActionPerformed();
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

    private void addViewTypeBtnActionPerformed() {
        addViewTypeController.addViewType();
    }

    public void reset() {
        viewTypeNameTextField.setText(null);
    }

    public static AddViewTypeUI getInitiatedInstance() {
        if (addViewTypeUI == null) {
            addViewTypeUI = new AddViewTypeUI();
        }
        return addViewTypeUI;
    }

    public JTextField getViewTypeNameTextField() {
        return viewTypeNameTextField;
    }

    public void setViewTypeNameTextField(String viewTypeName) {
        this.viewTypeNameTextField.setText(viewTypeName);
    }

    public JButton getAddViewTypeBtn() {
        return addViewTypeBtn;
    }
}
