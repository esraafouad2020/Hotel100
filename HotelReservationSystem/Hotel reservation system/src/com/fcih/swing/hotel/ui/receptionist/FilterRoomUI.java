package com.fcih.swing.hotel.ui.receptionist;

import com.fcih.swing.hotel.controller.FilterRoomsController;
import com.fcih.swing.hotel.creator.ControllerCreator1;
import com.fcih.swing.hotel.model.Room;
import com.fcih.swing.hotel.model.RoomTypeLookup;
import com.fcih.swing.hotel.model.ViewTypeLookup;
import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class FilterRoomUI extends JPanel implements Drawable {

    private JPanel filtrationCriteriaPanel;
    private JLabel roomTypeLabel;
    private JLabel viewTypeLabel;
    private JComboBox roomTypeComboBox;
    private JComboBox viewTypeComboBox;
    private JRadioButton isBusyRoomRadioButton;

    private JScrollPane searchTableScrollPane;
    private JTable searchResultTable;
    private JButton searchButton;

    private static FilterRoomUI filterRoomUI;

    private FilterRoomsController filterRoomsController;

    private FilterRoomUI() {
        initComponents();
        draw();
    }

    @Override
    public void initComponents() {
        filtrationCriteriaPanel = new JPanel();
        roomTypeLabel = new JLabel();
        viewTypeLabel = new JLabel();
        roomTypeComboBox = new JComboBox();
        viewTypeComboBox = new JComboBox();
        isBusyRoomRadioButton = new JRadioButton();
        searchButton = new JButton();
        searchTableScrollPane = new JScrollPane();
        searchResultTable = new JTable();

        filterRoomsController = ControllerCreator1.getFilterRoomsController();
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
        filtrationCriteriaPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Filtration Criteria", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));
        filtrationCriteriaPanel.setPreferredSize(new Dimension(1215, 173));

        prepareFiltrationCriteriaPanelComponent();

        GroupLayout filtrationCriteriaPanelLayout = new GroupLayout(filtrationCriteriaPanel);
        filtrationCriteriaPanel.setLayout(filtrationCriteriaPanelLayout);
        filtrationCriteriaPanelLayout.setHorizontalGroup(
                filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(filtrationCriteriaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(isBusyRoomRadioButton)
                                        .addGroup(filtrationCriteriaPanelLayout.createSequentialGroup()
                                                .addComponent(viewTypeLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(viewTypeComboBox, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                                .addComponent(roomTypeLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(roomTypeComboBox, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                                .addGap(78, 78, 78))
                                        .addGroup(GroupLayout.Alignment.TRAILING, filtrationCriteriaPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                                .addGap(510, 510, 510))))
        );

        filtrationCriteriaPanelLayout.setVerticalGroup(
                filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(filtrationCriteriaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(filtrationCriteriaPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(viewTypeLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roomTypeComboBox, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewTypeComboBox, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roomTypeLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addComponent(isBusyRoomRadioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }

    private void prepareFiltrationCriteriaPanelComponent() {
        roomTypeLabel.setFont(new Font("Tahoma", 1, 18));
        roomTypeLabel.setText("Room Type");
        roomTypeLabel.setToolTipText("");

        viewTypeLabel.setFont(new Font("Tahoma", 1, 18));
        viewTypeLabel.setText("View Type");
        viewTypeLabel.setToolTipText("");

        roomTypeComboBox.setFont(new Font("Tahoma", 1, 18));
        roomTypeComboBox.setModel(getRoomTypeComboBoxModel());

        viewTypeComboBox.setFont(new Font("Tahoma", 1, 18));
        viewTypeComboBox.setModel(getViewTypeComboBoxModel());

        isBusyRoomRadioButton.setFont(new Font("Tahoma", 1, 18));
        isBusyRoomRadioButton.setText("Busy Room");

        searchButton.setFont(new Font("Tahoma", 1, 18));
        searchButton.setText("Search");
        searchButton.addActionListener((ActionEvent) -> {
            drawResultTableScrollPane(false);
        });

    }

    private void drawResultTableScrollPane(boolean isFirstTime) {
        searchTableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), "Room Filtration Result", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));

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
                Integer.class, Integer.class, String.class, String.class, Boolean.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
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
            List<Room> rooms = filterRoomsController.getFilteredRooms();
            Object[][] result = new Object[rooms.size()][6];

            for (int i = 0; i < rooms.size(); i++) {
                result[i][0] = i + 1;
                result[i][1] = rooms.get(i).getRoomNumber();
                result[i][2] = rooms.get(i).getCost();
                result[i][3] = rooms.get(i).getViewTypeLookup();
                result[i][4] = rooms.get(i).getRoomTypeLookup();
                result[i][5] = isBusyRoomRadioButton.isSelected() ? "Y" : "N";
            }

            return result;
        }

        return null;
    }

    private Object[] getTableHeader() {
        return new String[]{
            "Column", "Number", "Cost", "View Type", "Room Type", "Is Busy"
        };
    }

    private DefaultComboBoxModel getViewTypeComboBoxModel() {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement("    -- Please Select --  ");

        for (ViewTypeLookup viewType : filterRoomsController.getAllViewTypes()) {
            defaultComboBoxModel.addElement(viewType);
        }

        return defaultComboBoxModel;
    }

    private DefaultComboBoxModel getRoomTypeComboBoxModel() {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel.addElement("    -- Please Select --  ");

        for (RoomTypeLookup roomType : filterRoomsController.getAllRoomTypes()) {
            defaultComboBoxModel.addElement(roomType);
        }

        return defaultComboBoxModel;
    }

    public void reset() {
        viewTypeComboBox.setSelectedIndex(0);
        roomTypeComboBox.setSelectedIndex(0);
        isBusyRoomRadioButton.setSelected(false);
        drawResultTableScrollPane(true);
    }

    public static FilterRoomUI getInitiatedInstance() {
        if (filterRoomUI == null) {
            filterRoomUI = new FilterRoomUI();
        }
        return filterRoomUI;
    }

    public JComboBox getRoomTypeComboBox() {
        return roomTypeComboBox;
    }

    public JComboBox getViewTypeComboBox() {
        return viewTypeComboBox;
    }

    public JRadioButton getIsBusyRoomRadioButton() {
        return isBusyRoomRadioButton;
    }
}