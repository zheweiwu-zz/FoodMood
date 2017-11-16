/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendationsview;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nadaziab
 */
public class RecommendationDetailedView {
    
    private JFrame f;
    private JPanel p;
    
    private String food, description;
    
    public RecommendationDetailedView(String food, String description) {
        f = new JFrame();
        p = new JPanel();
        f.setLayout(new BorderLayout());
        p.setLayout(new GridBagLayout());
        
        this.food = food;
        this.description = description;
        
        f.setTitle(food);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        
        createComponents();
        
        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }
    
    private void createComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        
        JLabel foodDesc = new JLabel(food + ": " + description);
        c.gridx = 0;
        c.gridy = 0;
        p.add(foodDesc, c);
    }
}
