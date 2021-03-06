/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendationsview;

import foodrecommendations.FoodRecommendations;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nadaziab
 */
public class RecommendationsView {
    
    private JFrame f;
    private JPanel p;
    
    private FoodRecommendations foodRecs;
    
    private JLabel placeholder;
    private JButton returnBtn;
    
    /**
     * default constructor for RecommendationsView
     */
    public RecommendationsView() {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        f.setTitle("Food Recommendations");
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
        
        placeholder = new JLabel("Food Recommendations to Improve Mood");
        c.gridx = 0;
        c.gridy = 0;
       // p.add(placeholder, c);
        
        foodRecs = new FoodRecommendations();
        
        for (int i = 0; i < foodRecs.getRecommendationsList().size(); i++) {
            c.gridx = 0;
            c.gridy = i + 1;
            
            String foodName = foodRecs.getRecommendationsList().get(i);
            String foodDesc = foodRecs.getRecommendatiosnMap().get(foodName).toString();
            JButton btn = new JButton(foodName);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RecommendationDetailedView rdv = new RecommendationDetailedView(foodName, foodDesc);
                }
                
            });
            p.add(btn, c);
        }
        
        returnBtn = new JButton("Return");
        c.gridx = 0;
        c.gridy = 10;
        p.add(returnBtn, c);
    }
    
    /**
     * 
     * @return JButton return
     */
    public JButton getReturnBtn() {
        return returnBtn;
    }
    
    /**
     * get the JFrame component
     * @return JFrame f
     */
    public JFrame getF() {
        return f;
    }
}
