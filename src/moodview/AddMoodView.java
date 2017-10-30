/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Zhewei
 */
public class AddMoodView {
    
    private JFrame f;
    private JPanel p;
    
    private Calendar calendar;
    
    private JLabel moodDescrLabel, moodDateLabel, moodTimeLabel;
    private JTextField moodDescrField, moodDateField, dateNumField, yearField, timeHourField, timeMinuteField;
    private final String[] MONTHARRAY = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private final String[] TIMEPERIOD = {"AM", "PM"};
    private JComboBox months, timePeriod;
    private JButton addBtn;
    private JButton returnButton;
    
    /**
     * default constructor for AddMoodUI
     */
    public AddMoodView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("Add Mood");
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
     * method to create UI components
     */
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        moodDescrLabel = new JLabel("Mood Description");
        c.gridx = 0;
        c.gridy = 0;
        p.add(moodDescrLabel, c);
        
        moodDescrField = new JTextField("");
        moodDescrField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 0;
        p.add(moodDescrField, c);
        
        moodDateLabel = new JLabel("Date Recorded");
        c.gridx = 0;
        c.gridy = 1;
        p.add(moodDateLabel, c);
        
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
        
        moodTimeLabel = new JLabel("Time Recorded");
        c.gridx = 0;
        c.gridy = 2;
        p.add(moodTimeLabel, c);
        
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
        moodDateField = new JTextField("");
        moodDateField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 1;
        p.add(moodDateField, c);
        */
        
        addBtn = new JButton("Add Mood");
        c.gridx = 1;
        c.gridy = 3;
        p.add(addBtn, c);
        
        returnButton = new JButton("Return");
        c.gridx = 3;
        c.gridy = 3;
        p.add(returnButton, c);
    }
    
    /**
     * gets mood description input
     * @return mood description as a String
     */
    public String getMoodDescription() {
        return moodDescrField.getText();
    }
    
    /**
     * gets mood date input
     * @return mood date as a String
     */
    public String getMoodDate() {
        return moodDateField.getText();
    }
    
    public JButton getAddBtn() {
        return addBtn;
    }
    
    public JFrame getF() {
        return f;
    }
    
    public JButton getReturn() {
        return returnButton;
    }
}
