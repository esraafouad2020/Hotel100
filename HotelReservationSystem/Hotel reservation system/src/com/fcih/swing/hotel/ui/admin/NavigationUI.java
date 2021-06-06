package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public final class NavigationUI extends JPanel implements Drawable {

    private JSeparator empServSeparator;
    private JSeparator servRoomSeparator;
    private JSeparator viewTypeRoomSeparator;
    private JSeparator viewTypeRoomTypeSeparator;

    private JLabel addEmployeeLabel;
    private JLabel editEmployeeLabel;
    private JLabel addService;
    private JLabel editServiceLabel;
    private JLabel addRoomLabel;
    private JLabel editRoomLabel;

    private JLabel addViewTypeLabel;
    private JLabel editViewTypeLabel;
    private JLabel addRoomTypeLabel;
    private JLabel editRoomTypeLabel;

    public NavigationUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        empServSeparator = new JSeparator();
        servRoomSeparator = new JSeparator();

        viewTypeRoomSeparator = new JSeparator();
        viewTypeRoomTypeSeparator = new JSeparator();

        addService = new JLabel();
        addEmployeeLabel = new JLabel();
        editServiceLabel = new JLabel();
        addRoomLabel = new JLabel();
        editRoomLabel = new JLabel();
        editEmployeeLabel = new JLabel();

        addViewTypeLabel = new JLabel();
        editViewTypeLabel = new JLabel();
        addRoomTypeLabel = new JLabel();
        editRoomTypeLabel = new JLabel();
    }

    @Override
    public void draw() {
        setBackground(new Color(255, 255, 255));

        prepareMenuComponent();

        GroupLayout menuPanelLayout = new GroupLayout(this);
        setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(empServSeparator, GroupLayout.Alignment.TRAILING)
                        .addComponent(servRoomSeparator, GroupLayout.Alignment.TRAILING)
                        .addComponent(viewTypeRoomSeparator, GroupLayout.Alignment.TRAILING)
                        .addComponent(viewTypeRoomTypeSeparator, GroupLayout.Alignment.TRAILING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(addEmployeeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editEmployeeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addService, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editServiceLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addRoomLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editRoomLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addViewTypeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editViewTypeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addRoomTypeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editRoomTypeLabel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 11, Short.MAX_VALUE))
        );

        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(addEmployeeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editEmployeeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(empServSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(addService, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editServiceLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(servRoomSeparator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addRoomLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editRoomLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(viewTypeRoomSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(addRoomTypeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editRoomTypeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(viewTypeRoomTypeSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(addViewTypeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editViewTypeLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void prepareMenuComponent() {
        drawEmployeeFunctionality();

        empServSeparator.setBackground(new Color(153, 153, 153));
        empServSeparator.setForeground(new Color(153, 153, 153));

        drawServiceFunctionality();

        servRoomSeparator.setBackground(new Color(153, 153, 153));
        servRoomSeparator.setForeground(new Color(153, 153, 153));

        drawRoomFunctionality();

        viewTypeRoomSeparator.setBackground(new Color(153, 153, 153));
        viewTypeRoomSeparator.setForeground(new Color(153, 153, 153));

        drawViewTypeFunctionality();

        viewTypeRoomTypeSeparator.setBackground(new Color(153, 153, 153));
        viewTypeRoomTypeSeparator.setForeground(new Color(153, 153, 153));

        drawRoomTypeFunctionality();
    }

    private void drawEmployeeFunctionality() {
        addEmployeeLabel.setFont(new Font("Tahoma", 0, 18));
        addEmployeeLabel.setForeground(new Color(0, 102, 204));
        addEmployeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addEmployeeLabel.setText("Add Employee");
        addEmployeeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addEmployeeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addEmployeeLabelMouseClicked(evt);
            }
        });

        editEmployeeLabel.setFont(new Font("Tahoma", 0, 18));
        editEmployeeLabel.setForeground(new Color(0, 102, 204));
        editEmployeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editEmployeeLabel.setText("Edit Employee");
        editEmployeeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editEmployeeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editEmployeeLabelMouseClicked(evt);
            }
        });

    }

    private void drawServiceFunctionality() {
        addService.setFont(new Font("Tahoma", 0, 18));
        addService.setForeground(new Color(0, 102, 204));
        addService.setHorizontalAlignment(SwingConstants.CENTER);
        addService.setText("Add Service");
        addService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addService.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addServiceLabelMouseClicked(evt);
            }
        });

        editServiceLabel.setFont(new Font("Tahoma", 0, 18));
        editServiceLabel.setForeground(new Color(0, 102, 204));
        editServiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editServiceLabel.setText("Edit Service");
        editServiceLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editServiceLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editServiceLabelMouseClicked(evt);
            }
        });
    }

    private void drawRoomFunctionality() {
        addRoomLabel.setFont(new Font("Tahoma", 0, 18));
        addRoomLabel.setForeground(new Color(0, 102, 204));
        addRoomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addRoomLabel.setText("Add Room");
        addRoomLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addRoomLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addRoomLabelMouseClicked(evt);
            }
        });

        editRoomLabel.setFont(new Font("Tahoma", 0, 18));
        editRoomLabel.setForeground(new Color(0, 102, 204));
        editRoomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editRoomLabel.setText("Edit Room");
        editRoomLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editRoomLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editRoomLabelMouseClicked(evt);
            }
        });
    }

    private void drawViewTypeFunctionality() {
        addViewTypeLabel.setFont(new Font("Tahoma", 0, 18));
        addViewTypeLabel.setForeground(new Color(0, 102, 204));
        addViewTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addViewTypeLabel.setText("Add View Type");
        addViewTypeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addViewTypeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addViewTypeLabelMouseClicked(evt);
            }
        });

        editViewTypeLabel.setFont(new Font("Tahoma", 0, 18));
        editViewTypeLabel.setForeground(new Color(0, 102, 204));
        editViewTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editViewTypeLabel.setText("Edit View Type");
        editViewTypeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editViewTypeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editViewTypeLabelMouseClicked(evt);
            }
        });

    }

    private void drawRoomTypeFunctionality() {
        addRoomTypeLabel.setFont(new Font("Tahoma", 0, 18));
        addRoomTypeLabel.setForeground(new Color(0, 102, 204));
        addRoomTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addRoomTypeLabel.setText("Add Room Type");
        addRoomTypeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addRoomTypeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                addRoomTypeLabelMouseClicked(evt);
            }
        });

        editRoomTypeLabel.setFont(new Font("Tahoma", 0, 18));
        editRoomTypeLabel.setForeground(new Color(0, 102, 204));
        editRoomTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        editRoomTypeLabel.setText("Edit Room Type");
        editRoomTypeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        editRoomTypeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editRoomTypeLabelMouseClicked(evt);
            }
        });

    }

    private void addEmployeeLabelMouseClicked(MouseEvent evt) {
        try {
            AddEmployeeUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(AddEmployeeUI.getInitiatedInstance());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void editEmployeeLabelMouseClicked(MouseEvent evt) {
        try {
            EditEmployeeUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(EditEmployeeUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addServiceLabelMouseClicked(MouseEvent evt) {
        try {
            AddServiceUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(AddServiceUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editServiceLabelMouseClicked(MouseEvent evt) {
        try {
            EditServiceUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(EditServiceUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addRoomLabelMouseClicked(MouseEvent evt) {
        try {
            AddRoomUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(AddRoomUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editRoomLabelMouseClicked(MouseEvent evt) {
        try {
            EditRoomUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(EditRoomUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addViewTypeLabelMouseClicked(MouseEvent evt) {
        try {
            AddViewTypeUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(AddViewTypeUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editViewTypeLabelMouseClicked(MouseEvent evt) {
        try {
            EditViewTypeUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(EditViewTypeUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addRoomTypeLabelMouseClicked(MouseEvent evt) {
        try {
            AddRoomTypeUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(AddRoomTypeUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void editRoomTypeLabelMouseClicked(MouseEvent evt) {
        try {
            EditRoomTypeUI.getInitiatedInstance().reset();
            AdminUI.setRightPanel(EditRoomTypeUI.getInitiatedInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
