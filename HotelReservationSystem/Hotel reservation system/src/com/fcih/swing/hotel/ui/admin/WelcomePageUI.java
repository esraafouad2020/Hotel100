package com.fcih.swing.hotel.ui.admin;

import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public final class WelcomePageUI extends JPanel implements Drawable {

    private JLabel dukeIconLabel;
    private JLabel welomeLabel;

    public WelcomePageUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        dukeIconLabel = new JLabel();
        welomeLabel = new JLabel();
    }

    @Override
    public void draw() {
        prepareWelcomeImage();
        prepareWelcomeText();

        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED)), BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), BorderFactory.createBevelBorder(BevelBorder.LOWERED))));

        this.setPreferredSize(new Dimension(1052, 509));
        this.setBackground(Color.WHITE);

        GroupLayout jPanel1Layout = new GroupLayout(this);
        setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(welomeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(dukeIconLabel, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 334, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welomeLabel, GroupLayout.PREFERRED_SIZE, 226, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(dukeIconLabel, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
        );
    }

    private void prepareWelcomeImage() {
        dukeIconLabel.setIcon(new ImageIcon(getClass().getResource("/resources/imgs/dukeWelcomePageImg.png")));
        dukeIconLabel.setPreferredSize(new Dimension(462, 372));
    }

    private void prepareWelcomeText() {
        welomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welomeLabel.setIcon(new ImageIcon(getClass().getResource("/resources/imgs/Welcome.jpg")));
    }
}
