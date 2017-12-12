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
import navigationcontroller.NavigationController;
import profilemodel.ProfileModel;
import profileview.*;

/**
 *
 * @author Zhewei
 */
public class ProfileViewController implements ActionListener {
        
    NavigationController nc;
    ProfileView pv;
    public ProfileModel pm;
        
    public ProfileViewController (NavigationController nc){
        this.nc = nc;
        //Database.readProfileData(Database.username);
        //this.pm = Database.userProfile;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == pv.getReturnBtn()) {
            nc.getMmv().getF().setVisible(true);
            pv.getF().dispose();
        }
    }
    public void setPCView() {
        pv = new ProfileView(this);
        pv.getReturnBtn().addActionListener(this);
    }
    
}

//public void getList(){
// for (FoodModel food: foods.getAllFoods()) {
 //           efv.getModel().addRow(new Object[]{food.getName(), food.getDateTime(), ""});
 //       }
//}