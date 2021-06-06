package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public final class AdminUI extends JFrame implements Drawable {

    private JPanel menuPanel;
    private JPanel rightPanel = new WelcomePageUI();
    private JLayeredPane containerPanel;
    private JSeparator leftRightMenuSeparator;
    private static AdminUI adminView;
    
    private AdminUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        menuPanel = new NavigationUI();
        containerPanel = new JLayeredPane();
        leftRightMenuSeparator = new JSeparator();
    }

    @Override
    public void draw() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(new java.awt.Dimension(1092, 829));
        setLocationRelativeTo(null);
        
        leftRightMenuSeparator.setBackground(new Color(153, 153, 153));
        leftRightMenuSeparator.setForeground(new Color(153, 153, 153));
        leftRightMenuSeparator.setOrientation(SwingConstants.VERTICAL);

        GroupLayout containerPanelLayout = new GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
                containerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(containerPanelLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(leftRightMenuSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerPanelLayout.setVerticalGroup(
                containerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(leftRightMenuSeparator, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGroup(containerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        containerPanel.setLayer(leftRightMenuSeparator, JLayeredPane.DEFAULT_LAYER);
        containerPanel.setLayer(rightPanel, JLayeredPane.DEFAULT_LAYER);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(containerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(menuPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(containerPanel)
        );

        pack();
    }

    public static void setRightPanel(JPanel rightPanel) throws Exception {
        if(adminView == null)
            throw new Exception("Illegal call exception ,,Please Run Your View First");
        
        adminView.rightPanel = rightPanel;
        adminView.containerPanel.removeAll();
        adminView.containerPanel.add(adminView.rightPanel);
        adminView.initComponents();
        adminView.draw();
       
    }
    
    public static AdminUI run() {
        if(adminView == null) {
            adminView =  new AdminUI();
        }
        return adminView;
    }
    
}
