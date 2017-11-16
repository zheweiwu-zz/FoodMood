/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationsview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nadaziab
 */
public class NotificationsView {
    
    private JFrame f;
    private JPanel p;
    
    private JLabel placeholder;
    private JButton returnBtn;
    
    /**
     * default constructor for NotificationsView
     */
    public NotificationsView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("Notifications");
        f.setSize(500, 500); // default size is 0,0
        //f.setLocation(300, 300); // default is 0,0 (top left corner)
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
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
        
        placeholder = new JLabel("** Notifications **");
        c.gridx = 0;
        c.gridy = 0;
        p.add(placeholder, c);
        
        returnBtn = new JButton("Return");
        c.gridx = 0;
        c.gridy = 1;
        p.add(returnBtn, c);
        
    }
    
    public JButton getReturnBtn() {
        return returnBtn;
    }
    
    public JFrame getF() {
        return f;
    }
}
