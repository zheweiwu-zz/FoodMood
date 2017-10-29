/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodMood;

import logincontroller.LoginController;
import loginview.LoginView;

/**
 *
 * @author Zhewei
 */
public class FoodFood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView loginUI = new LoginView();
        LoginController lc = new LoginController(loginUI);
    }
    
}
