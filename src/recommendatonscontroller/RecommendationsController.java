/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendatonscontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;
import recommendationsview.RecommendationsView;

/**
 *
 * @author nadaziab
 */
public class RecommendationsController implements ActionListener {
    
    private RecommendationsView rv;
    private NavigationController nc;
    
    /**
     * constructor for RecommendationsController
     */
    public RecommendationsController(NavigationController nc) {
        this.nc = nc;
    }
    
    /**
     * sets RecommendationsView
     */
    public void setRv() {
        rv = new RecommendationsView();
        rv.getReturnBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource()==rv.getReturnBtn()) {
            nc.getMmv().getF().setVisible(true);
            rv.getF().dispose();
        }
    }
}
