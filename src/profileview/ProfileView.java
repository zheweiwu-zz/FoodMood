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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
    private String[] columnNames = {"userid", "age", "weight"};
    private JTable profileEntries;
    private DefaultTableModel model;
    private TableColumnModel columnModel;
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
        createComponents();
        getModel().addRow(columnNames);
   
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
    
    /**
     * creates UI components
     */
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        
       usernameLabel = new JLabel(Database.username + "'s Profile");
        c.gridx = 0;
        c.gridy = 0;
        p.add(usernameLabel, c);
        
        
        
        model = new DefaultTableModel(columnNames, 0);
        profileEntries = new JTable(model);
        c.gridx = 0;
        c.gridy = 2;
        p.add(profileEntries, c); 
        
        
        
        returnBtn = new JButton("Return");
        c.gridx = 0;
        c.gridy = 3;
        p.add(returnBtn, c);
        
    }
    
    public JButton getReturnBtn() {
        return returnBtn;
    }
    
    public DefaultTableModel getModel() {
        return model;
    }
    
    public JFrame getF() {
        return f;
    }
}
