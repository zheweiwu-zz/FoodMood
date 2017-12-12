/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 *
 * @author nadaziab
 */
public class MainMenuView {
    
    private JFrame f;
    private JPanel p;
    
    private JButton addFoodBtn, addMoodBtn, viewProfileBtn, editEntriesBtn, viewRecommendationsBtn;
    
    /**
     * default constructor for MainMenuUI
     */
    public MainMenuView(){
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("FoodMood");
        f.setSize(500, 500); // default size is 0,0
        //f.setLocation(300, 300); // default is 0,0 (top left corner)
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        createComponents();
        
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
        
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        addFoodBtn = new JButton("Add Food Entry");
        c.gridx = 0;
        c.gridy = 0;
        p.add(addFoodBtn, c);
        
        addMoodBtn = new JButton("Add Mood Entry");
        c.gridx = 0;
        c.gridy = 1;
        p.add(addMoodBtn, c);
        
        editEntriesBtn = new JButton("Edit Food Entries / type 'delete' or new name in last column");
        c.gridx = 0;
        c.gridy = 2;
        p.add(editEntriesBtn, c);
        
        viewProfileBtn = new JButton("View Profile");
        c.gridx = 0;
        c.gridy = 3;
        p.add(viewProfileBtn, c);
        
        viewRecommendationsBtn = new JButton("View Food Recommendations");
        c.gridx = 0;
        c.gridy = 5;
        p.add(viewRecommendationsBtn, c);
        
        
    }

    public JButton getAddFoodBtn() {
        return addFoodBtn;
    }

    public JButton getAddMoodBtn() {
        return addMoodBtn;
    }

    public JButton getViewProfileBtn() {
        return viewProfileBtn;
    }

    public JButton getEditEntriesBtn() {
        return editEntriesBtn;
    }
    
//    public JButton getViewNotificationsBtn() {
//       return viewNotificationsBtn;
//    }
    
    public JButton getViewRecommendationsBtn() {
        return viewRecommendationsBtn;
    }
    
    public JFrame getF() {
        return f;
    }
}
