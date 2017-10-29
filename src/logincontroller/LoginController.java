/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logincontroller;

import databasecontroller.Database;
import foodmodel.FoodList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import loginview.*;
import moodmodel.MoodList;
import navigationcontroller.NavigationController;
import navigationview.MainMenuView;
import profilecontroller.ProfileController;
import profileview.*;
/**
 *
 * @author Zhewei
 */
public class LoginController implements ActionListener {
    
    LoginView lv;
    
    public LoginController(LoginView lv) {
        this.lv = lv;
        this.lv.createProfileBtn.addActionListener(this);
        this.lv.loginBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==lv.createProfileBtn) {
             CreateProfileView cpv = new CreateProfileView();
             ProfileController pc = new ProfileController(cpv);
             lv.getF().dispose();
        }
        else if (ae.getSource()==lv.loginBtn) {
            if (Database.authProfile(lv.getUsername(), lv.getPassword())) {
                MainMenuView mmv = new MainMenuView();
                NavigationController nc = new NavigationController(mmv, new FoodList(), new MoodList());
                lv.getF().dispose();
            }
            else {
                System.out.println("Error authenticating");
            }
        }
    }
}
