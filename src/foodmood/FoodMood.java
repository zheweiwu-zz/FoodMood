/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood;
import logincontroller.LoginController;
import loginview.*;
/**
 *
 * @author Zhewei
 */
public class FoodMood {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView lv = new LoginView();
        LoginController lc = new LoginController(lv);
    }
    
}
