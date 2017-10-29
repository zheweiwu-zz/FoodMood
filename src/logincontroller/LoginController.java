/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logincontroller;

import databasecontroller.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import loginview.*;
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
            
        }
        else if (ae.getSource()==lv.loginBtn) {
            Database.authProfile(lv.getUsername(), lv.getPassword());
        }
    }
}
