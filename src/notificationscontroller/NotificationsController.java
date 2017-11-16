/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationscontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;
import notificationsview.NotificationsView;

/**
 *
 * @author nadaziab
 */
public class NotificationsController implements ActionListener {
    
    private NotificationsView nv;
    private NavigationController nc;
    
    /**
     * constructor for NotificationsController
     */
    public NotificationsController(NavigationController nc) {
        this.nc = nc;
    }
    
    /**
     * sets NotificationsView
     */
    public void setNv() {
        nv = new NotificationsView();
        nv.getReturnBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == nv.getReturnBtn()) {
            nc.getMmv().getF().setVisible(true);
            nv.getF().dispose();
        }
    }
}
