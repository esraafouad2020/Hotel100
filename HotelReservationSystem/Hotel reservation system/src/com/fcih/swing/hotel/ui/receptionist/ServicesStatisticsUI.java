package com.fcih.swing.hotel.ui.receptionist;

import com.fcih.swing.hotel.ui.Drawable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public final class ServicesStatisticsUI extends JPanel implements Drawable{

    public ServicesStatisticsUI() {
        initComponents();
        draw();
    }
    
    @Override
    public void initComponents() {
    }

    @Override
    public void draw() {
        setBackground(new Color(255, 255, 255));
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), BorderFactory.createBevelBorder(BevelBorder.LOWERED)), BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createBevelBorder(BevelBorder.RAISED))), "Services Statistics  ", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 3, 18)));
        setPreferredSize(new Dimension(1215, 473));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        removeAll();
        add(drawChart());
        updateUI();
    }
    
    private ChartPanel drawChart() {
        
        JFreeChart barChart3D = ChartFactory.createBarChart3D("", "Service Name", "Usage", prepareChart(), PlotOrientation.VERTICAL, true, true, false);
        
        CategoryPlot plot = barChart3D.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        plot.getRenderer().setSeriesPaint(0, new Color(50,205,50));
        return new ChartPanel(barChart3D);
    }
    
    private DefaultCategoryDataset prepareChart() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        defaultCategoryDataset.setValue(70, "Services", "Services_1");
        defaultCategoryDataset.setValue(10, "Services", "Services_2");
        defaultCategoryDataset.setValue(50, "Services", "Services_3");
        defaultCategoryDataset.setValue(30, "Services", "Services_4");
        defaultCategoryDataset.setValue(40, "Services", "Services_5");
        defaultCategoryDataset.setValue(20, "Services", "Services_6");
        defaultCategoryDataset.setValue(60, "Services", "Services_7");
        return defaultCategoryDataset;
    }
}
