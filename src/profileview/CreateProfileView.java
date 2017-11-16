/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileview;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author nadaziab
 */
public class CreateProfileView {
    
    private JFrame f;
    private JPanel p;
    
    private JLabel usernameLabel, passwordLabel, ageLabel, weightLabel;
    private JTextField usernameField, passwordField, ageField, weightField;
    public JButton createBtn;
    
    /**
     * Default constructor for CreateProfileUI
     */
    public CreateProfileView() {
        
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("Create User Profile");
        f.setSize(500, 500); // default size is 0,0
        //f.setLocation(300, 300); // default is 0,0 (top left corner)
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
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
        
        usernameLabel = new JLabel("Username");
        c.gridx = 0;
        c.gridy = 0;
        p.add(usernameLabel, c);
        
        usernameField = new JTextField("");
        usernameField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 0;
        p.add(usernameField, c);
        
        passwordLabel = new JLabel("Password");
        c.gridx = 0;
        c.gridy = 1;
        p.add(passwordLabel, c);
        
        passwordField = new JTextField("");
        passwordField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 1;
        p.add(passwordField, c);
        
        ageLabel = new JLabel("Age");
        c.gridx = 0;
        c.gridy = 2;
        p.add(ageLabel, c);
        
        ageField = new JTextField("");
        ageField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 2;
        p.add(ageField, c);
        
        weightLabel = new JLabel("Weight");
        c.gridx = 0;
        c.gridy = 3;
        p.add(weightLabel, c);
        
        weightField = new JTextField("");
        weightField.setPreferredSize(new Dimension(100, 30));
        c.gridx = 1;
        c.gridy = 3;
        p.add(weightField, c);
        
        createBtn = new JButton("Create Profile");
        c.gridx = 1;
        c.gridy = 4;
        p.add(createBtn, c);
    }
    
    /**
     * gets username input
     * @return username as a String
     */
    public String getUsername() {
        return usernameField.getText();
    }
    
    /**
     * gets password input
     * @return password as a String
     */
    public String getPassword() {
        return passwordField.getText();
    }
    
    /**
     * gets age input
     * @return age as a String
     */
    public String getAge() {
        return ageField.getText();
    }
    
    /**
     * gets weight input
     * @return weight as a String
     */
    public String getWeight() {
        return weightField.getText();
    }
    
    public JFrame getF() {
        return f;
    }
}
