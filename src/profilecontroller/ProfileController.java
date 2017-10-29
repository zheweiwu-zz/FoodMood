/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profilecontroller;

import databasecontroller.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import profileview.*;

/**
 *
 * @author Zhewei
 */
public class ProfileController implements ActionListener {
        
    CreateProfileView cpv;
        
    public ProfileController(CreateProfileView cpv) {
        this.cpv = cpv;
        this.cpv.createBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==cpv.createBtn) {
            try { 
                Database.POSTProfile();
            } catch (Exception ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
