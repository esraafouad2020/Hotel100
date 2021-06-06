package com.fcih.swing.hotel.ui.receptionist;

import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class EditGuestUI extends JPanel implements Drawable {

    private JButton deleteGuestBtn;
    private JButton updateGuestBtn;
    private JScrollPane guestTableScrollPane;
    private JTable guestTable;

    public EditGuestUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {

        guestTableScrollPane = new JScrollPane();
        guestTable = new JTable();
        updateGuestBtn = new JButton();
        deleteGuestBtn = new JButton();
    }

    @Override
    public void draw() {

        setPreferredSize(new Dimension(1215, 473));
        
        drawGuestTable();
        drawBtn();
        
        GroupLayout editGuestPanelLayout = new GroupLayout(this);
        setLayout(editGuestPanelLayout);
        editGuestPanelLayout.setHorizontalGroup(
                editGuestPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(editGuestPanelLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(deleteGuestBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300)
                        .addComponent(updateGuestBtn, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(251, Short.MAX_VALUE))
                .addGroup(editGuestPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(guestTableScrollPane)
                        .addContainerGap())
        );
        editGuestPanelLayout.setVerticalGroup(
                editGuestPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(editGuestPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(guestTableScrollPane, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(editGuestPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteGuestBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addComponent(updateGuestBtn, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );
    }

    private void drawGuestTable() {
        guestTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        guestTable.getTableHeader().setOpaque(false);
        guestTable.getTableHeader().setBackground(new Color(32, 136, 203));
        guestTable.getTableHeader().setForeground(new Color(255, 255, 255));

        guestTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Guest Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        guestTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        guestTable.setFont(new Font("Tahoma", 0, 18));
        guestTable.setModel(new DefaultTableModel(
                new Object[][]{
                    {new Integer(1), "mustafa", "Egypt", "mustafaa.fcih@gmail.com", "01110335177", new Date(), new Date() , "Single", "Nile", new Integer(101)},
                    {new Integer(1), "ghada", "Egypt","ghada.fcih@gmail.com", "01110335177", new Date(), new Date() , "Single", "Nile", new Integer(101)},
                    {new Integer(1), "passant", "Egypt","passant.fcih@gmail.com", "01110335177", new Date(), new Date() , "double", "Sea", new Integer(101)},
                    {new Integer(1), "mo'men", "Egypt","moamen.fcih@gmail.com", "01110335177", new Date(), new Date() , "Single", "non-view", new Integer(101)}
                },
                new String[]{
                    "Column", "Name", "Country", "Email", "Phone", "Start Date", "End Date", "Room Type", "View Type", "Room Number"
                }
        ) {
            Class[] types = new Class[]{
                Integer.class, String.class, String.class, String.class, Long.class, Date.class, Date.class, String.class, String.class, Integer.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        guestTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 1; i < guestTable.getColumnCount(); i++) {
            guestTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        guestTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        guestTable.setRowHeight(35);
        guestTable.setRowMargin(5);
        guestTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        guestTableScrollPane.setViewportView(guestTable);
    }

    private void drawBtn() {

        deleteGuestBtn.setFont(new Font("Tahoma", 1, 18));
        deleteGuestBtn.setText("Update");
        deleteGuestBtn.setHorizontalTextPosition(SwingConstants.CENTER);

        updateGuestBtn.setFont(new Font("Tahoma", 1, 18));
        updateGuestBtn.setText("Delete");
        updateGuestBtn.setHorizontalTextPosition(SwingConstants.CENTER);
    }
}
