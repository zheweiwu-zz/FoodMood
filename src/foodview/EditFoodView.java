/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodview;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zhewei
 */
public class EditFoodView {
    
    private JFrame frame;
    private JPanel panel;
    private Object[] columnNames = {"Food", "Date entered", "New food"};
    private JTable foodEntries;
    private DefaultTableModel model;
    private JButton saveChanges;
    
    public EditFoodView() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(1,1));
        frame.setSize(500, 500);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BorderLayout());
        model = new DefaultTableModel(columnNames, 0);
        foodEntries = new JTable(model);
        panel.add(foodEntries, BorderLayout.CENTER);
        saveChanges = new JButton("Save changes");
        panel.add(saveChanges, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    public JTable getFoods() {
        return foodEntries;
    }

    public DefaultTableModel getModel() {
        return model;
    }
    
    public JButton getSave() {
        return saveChanges;
    }
}
