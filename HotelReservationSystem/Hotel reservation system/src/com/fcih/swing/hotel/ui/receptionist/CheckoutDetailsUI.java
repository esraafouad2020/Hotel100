package com.fcih.swing.hotel.ui.receptionist;

import com.fcih.swing.hotel.controller.CheckoutsDetailsController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.Guest;
import com.fcih.swing.hotel.ui.Drawable;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class CheckoutDetailsUI extends JPanel implements Drawable {

    private JPanel filtrationCriteriaPanel;
    private JLabel toDateLabel;
    private JLabel fromDateLabel;
    private JDateChooser toDateChooser;
    private JDateChooser fromDateChooser;

    private JScrollPane searchTableScrollPane;
    private JTable searchResultTable;
    private JButton searchButton;

    private static CheckoutDetailsUI checkoutDetailsUI;
    private CheckoutsDetailsController checkoutsDetailsController;
    
    private CheckoutDetailsUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        filtrationCriteriaPanel = new JPanel();
        toDateLabel = new JLabel();
        fromDateLabel = new JLabel();
        toDateChooser = new JDateChooser();
        fromDateChooser = new JDateChooser();
        searchButton = new JButton();
        searchTableScrollPane = new JScrollPane();
        searchResultTable = new JTable();
        
        checkoutsDetailsController = ControllerCreator1.getCheckoutsDetailsController();
    }

    @Override
    public void draw() {
        this.setPreferredSize(new Dimension(1215, 473));
        preparefilterRoomPanelComponent();

        GroupLayout filterRoomPanelLayout = new GroupLayout(this);
        setLayout(filterRoomPanelLayout);
        filterRoomPanelLayout.setHorizontalGroup(
                filterRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(filterRoomPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(filterRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(filterRoomPanelLayout.createSequentialGroup()
                                        .addComponent(filtrationCriteriaPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                                .addGroup(filterRoomPanelLayout.createSequentialGroup()
                                        .addComponent(searchTableScrollPane)
                                        .addContainerGap())))
        );
        
        filterRoomPanelLayout.setVerticalGroup(
                filterRoomPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(filterRoomPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filtrationCriteriaPanel, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTableScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
        );
    }

    private void preparefilterRoomPanelComponent() {

        drawFiltrationCriteriaPanel();
        drawResultTableScrollPane(true);
    }

    private void drawFiltrationCriteriaPanel() {

        prepareFiltrationCriteriaPanelComponent();

        filtrationCriteriaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Filtration Criteria", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        GroupLayout filtrationCriteriaPanelLayout = new GroupLayout(filtrationCriteriaPanel);
        filtrationCriteriaPanel.setLayout(filtrationCriteriaPanelLayout);
        filtrationCriteriaPanelLayout.setHorizontalGroup(filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(filtrationCriteriaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(filtrationCriteriaPanelLayout.createSequentialGroup()
                                        .addComponent(fromDateLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                        .addComponent(toDateLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78))
                                .addGroup(GroupLayout.Alignment.TRAILING, filtrationCriteriaPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                        .addGap(510, 510, 510))))
        );
        
        filtrationCriteriaPanelLayout.setVerticalGroup(filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(filtrationCriteriaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(fromDateLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                .addComponent(toDateChooser, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addComponent(fromDateChooser, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addComponent(toDateLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
    }

    private void prepareFiltrationCriteriaPanelComponent() {
        toDateLabel.setFont(new Font("Tahoma", 1, 18));
        toDateLabel.setText("To");
        toDateLabel.setToolTipText("");

        fromDateLabel.setFont(new Font("Tahoma", 1, 18));
        fromDateLabel.setText("From");

        searchButton.setFont(new Font("Tahoma", 1, 18));
        searchButton.setText("Search");
        searchButton.addActionListener((ActionEvent) -> {
            drawResultTableScrollPane(false);
        });

        toDateChooser.setFont(new Font("Tahoma", 1, 18));
        
        fromDateChooser.setFont(new Font("Tahoma", 1, 18));
    }

    private void drawResultTableScrollPane(boolean isFirstTime) {
        searchTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Checkout Detials", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

        searchResultTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        searchResultTable.getTableHeader().setOpaque(false);
        searchResultTable.getTableHeader().setBackground(new Color(32, 136, 203));
        searchResultTable.getTableHeader().setForeground(new Color(255, 255, 255));

        searchResultTable.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        searchResultTable.setRowHeight(35);
        searchResultTable.setRowMargin(5);
        searchResultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchResultTable.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
        searchResultTable.setFont(new Font("Tahoma", 0, 18));
        searchResultTable.setModel(getTableModel(isFirstTime));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        searchResultTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (int i = 1; i < searchResultTable.getColumnCount(); i++) {
            searchResultTable.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }

        searchTableScrollPane.setViewportView(searchResultTable);
    }

    private DefaultTableModel getTableModel(boolean isFirstTime) {
        return new DefaultTableModel(getTableData(isFirstTime), getTableHeader()) {
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
        };
    }

    private Object[][] getTableData(boolean isFirstTime) {
        if (!isFirstTime) {
            List<Guest> guest = checkoutsDetailsController.getCheckoutsDetails();
            Object[][] result = new Object[guest.size()][10];

            for (int i = 0; i < guest.size(); i++) {
                result[i][0] = i + 1;
                result[i][1] = guest.get(i).getName();
                result[i][2] = guest.get(i).getNationalId();
                result[i][3] = guest.get(i).getEmail();
                result[i][4] = guest.get(i).getPhone();
                result[i][5] = guest.get(i).getStartDate();
                result[i][6] = guest.get(i).getEndDate();
                result[i][7] = guest.get(i).getRoom().getRoomTypeLookup();
                result[i][8] = guest.get(i).getRoom().getViewTypeLookup();
                result[i][9] = guest.get(i).getRoom().getRoomNumber();
            }

            return result;
        }

        return null;
    }

    private Object[] getTableHeader() {
        return new String[]{
            "Column", "Name", "National ID", "Email", "Phone", "Start Date", "End Date", "Room Type", "View Type", "Room Number"
         };
    }
    
    public void displayErrorDialog(String msg) {
        JLabel label = new JLabel(msg);
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("Tahoma", Font.PLAIN, 18)));
        UIManager.put("OptionPane.okButtonText", "OK");
        JOptionPane.showMessageDialog(this, label, "Error Message", JOptionPane.ERROR_MESSAGE);
    }
    
    public void reset() {
        toDateChooser.setDate(null);
        fromDateChooser.setDate(null);
        drawResultTableScrollPane(true);
    }
    
    public static CheckoutDetailsUI getInitiatedInstance() {
        if (checkoutDetailsUI == null) {
            checkoutDetailsUI = new CheckoutDetailsUI();
        }
        
        return checkoutDetailsUI;
    }
    
    public JDateChooser getToDateChooser() {
        return toDateChooser;
    }

    public JDateChooser getFromDateChooser() {
        return fromDateChooser;
    }
}
