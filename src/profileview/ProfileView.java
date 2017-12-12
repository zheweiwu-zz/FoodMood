/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profileview;

/**
 *
 * @author Nate
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import databasecontroller.Database;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import profilecontroller.ProfileViewController;

public class ProfileView {
    
    private JFrame f;
    private JPanel p;
    
    private JLabel username;
    private JLabel usernameLabel;
    private JLabel ageLabel;
    private JLabel age;
    private JLabel weightLabel;
    private JLabel weight;
    private JButton returnBtn;
    private Object[] columnNames = {"Food", "Date entered", "Mood", "Date entered"};
    private JTable entries;
    private DefaultTableModel model;
    private ProfileViewController pvc;
    
    /**
     * default constructor for PrifleView
     */
    public ProfileView(ProfileViewController pvc){
        this.pvc = pvc;
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle(Database.username + "'s Profile");
        f.setSize(500, 500); // default size is 0,0
        
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        model = new DefaultTableModel(columnNames, 0);
        entries = new JTable(model);
        p.add(entries);
        createComponents();
        
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
    
    /**
     * creates UI components
     */
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        
        usernameLabel = new JLabel("Username: ");
        c.gridx = 0;
        c.gridy = 0;
        p.add(usernameLabel, c);
        
        username = new JLabel(pvc.pm.getUsername());
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.WEST;
        p.add(username, c);
        
        ageLabel = new JLabel("Age: ");
        c.gridx = 0;
        c.gridy = 1;
        p.add(ageLabel, c);
        
        age = new JLabel(pvc.pm.getAge());
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.WEST;
        p.add(age, c);
        
        weightLabel = new JLabel("Weight: ");
        c.gridx = 0;
        c.gridy = 2;
        p.add(weightLabel, c);
        
        weight = new JLabel(pvc.pm.getUsername());
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.WEST;
        p.add(weight, c);
        
        
        
        returnBtn = new JButton("Return");
        c.gridx = 0;
        c.gridy = 3;
        p.add(returnBtn, c);
        
    }
    
    public JButton getReturnBtn() {
        return returnBtn;
    }
    
    public JFrame getF() {
        return f;
    }
}
