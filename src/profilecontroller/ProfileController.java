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
import logincontroller.LoginController;
import loginview.LoginView;
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
             
            if (Database.checkProfile(cpv.getUsername())) {
                System.out.println("Error: profile already exists");
            }
            else {
                try { 
                Database.POSTProfile(cpv.getUsername(), cpv.getPassword(), cpv.getAge(), cpv.getWeight());
                cpv.getF().dispose();
                LoginView lv = new LoginView();
                LoginController lc = new LoginController(lv);
            } catch (Exception ex) {
                Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
