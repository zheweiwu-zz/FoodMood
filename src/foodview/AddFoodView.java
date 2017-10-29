/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodview;

import databasecontroller.Database;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

/**
 *
 * @author nadaziab
 */
public class AddFoodView {
    
    private JFrame f;
    private JPanel p;
    
    private JLabel foodNameLabel, foodDateLabel, foodTimeLabel;
    private JTextField foodNameField, foodDateField;
    
    private final String[] MONTHARRAY = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private final String[] TIMEPERIOD = {"AM", "PM"};
    private JComboBox months, timePeriod;
    
    private JTextField dateNumField, yearField, timeHourField, timeMinuteField;
    
    private Calendar calendar;
    
    private JButton addBtn;
    
    /**
     * default constructor for AddFoodUI
     */
    public AddFoodView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("Add Food");
        f.setSize(500, 500); // default size is 0,0
        //f.setLocation(300, 300); // default is 0,0 (top left corner)
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        calendar = new GregorianCalendar();
        createComponents();
        
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
    
    /**
     * create UI components
     */
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        foodNameLabel = new JLabel("Food Name");
        c.gridx = 0;
        c.gridy = 0;
        p.add(foodNameLabel, c);
        
        foodNameField = new JTextField("");
        foodNameField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 0;
        p.add(foodNameField, c);
        
        foodDateLabel = new JLabel("Date Consumed");
        c.gridx = 0;
        c.gridy = 1;
        p.add(foodDateLabel, c);
        
        months = new JComboBox(MONTHARRAY);
        months.setSelectedIndex(calendar.get(Calendar.MONTH)); //defaults to current month
        c.gridx = 1;
        c.gridy = 1;
        p.add(months, c);
        
        String date = String.valueOf(calendar.get(Calendar.DATE));
        
        dateNumField = new JTextField(date);
        c.gridx = 2;
        c.gridy = 1;
        p.add(dateNumField, c);
        
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        
        yearField = new JTextField(year);
        c.gridx = 3;
        c.gridy = 1;
        p.add(yearField, c);
        
        foodTimeLabel = new JLabel("Time Consumed");
        c.gridx = 0;
        c.gridy = 2;
        p.add(foodTimeLabel, c);
        
        timeHourField = new JTextField(String.valueOf(calendar.get(Calendar.HOUR)));
        c.gridx = 1;
        c.gridy = 2;
        p.add(timeHourField, c);
        
        timeMinuteField = new JTextField(String.valueOf(calendar.get(Calendar.MINUTE)));
        c.gridx = 2;
        c.gridy = 2;
        p.add(timeMinuteField, c);
        
        timePeriod = new JComboBox(TIMEPERIOD);
        c.gridx = 3;
        c.gridy = 2;
        p.add(timePeriod, c);
        
        /*
        foodDateField = new JTextField("");
        foodDateField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 1;
        p.add(foodDateField, c);
        */
        
        addBtn = new JButton("Add Food");
        c.gridx = 1;
        c.gridy = 3;
        p.add(addBtn, c);
    }
    
    /**
     * gets food name input
     * @return food name as a String
     */
    public String getFoodName() {
        return foodNameField.getText();
    }
    
    /**
     * gets food date input
     * @return food date as a String
     */
    public String getFoodDate() {
        return foodDateField.getText();
    }
    
    public JFrame getF() {
        return f;
    }

    public JButton getAddBtn() {
        return addBtn;
    }
    
    
}
