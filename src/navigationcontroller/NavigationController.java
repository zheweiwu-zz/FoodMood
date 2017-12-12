/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationcontroller;

import foodcontroller.FoodController;
import foodmodel.FoodList;
import foodmodel.FoodModel;
import foodmoodpair.FoodMoodInsert;
import foodview.AddFoodView;
import foodview.EditFoodView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import moodcontroller.MoodController;
import moodmodel.MoodList;
import moodview.AddMoodView;
import navigationview.MainMenuView;
import notificationscontroller.NotificationsController;
import notificationsview.NotificationsView;
import profilecontroller.ProfileController;
import profilecontroller.ProfileViewController;
import recommendatonscontroller.RecommendationsController;

/**
 *
 * @author Zhewei
 */
public class NavigationController implements ActionListener {

    private MainMenuView mmv;
    private FoodController fc;
    private MoodController mc;
    private FoodMoodInsert fmi;
    private String userID;
    private Timer tim;
    
    public NavigationController(MainMenuView mmv, FoodList foods, MoodList moods, String user) {
        this.mmv = mmv;
        fmi = new FoodMoodInsert();
        fc = new FoodController(foods, this, fmi);
        mc = new MoodController(moods, this, fmi);
        addtheListeners();
        userID = user;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==mmv.getAddFoodBtn()) {
            AddFoodView afv = new AddFoodView();
            fc.setAfv(afv);
            mmv.getF().setVisible(false);
        }
        else if (ae.getSource()==mmv.getAddMoodBtn()) {
            AddMoodView amv = new AddMoodView();
            mc.setAmv(amv);
            mmv.getF().setVisible(false);
        }
        else if (ae.getSource()==mmv.getViewProfileBtn()) {
            ProfileViewController pc;
            try {
                pc = new ProfileViewController(this);
                pc.setPCView();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(NavigationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            mmv.getF().setVisible(false);
        }
        else if (ae.getSource()==mmv.getEditEntriesBtn()) {
            fc.setEfv(new EditFoodView());
        }
        else if (ae.getSource() == mmv.getViewRecommendationsBtn()) {
            RecommendationsController rc = new RecommendationsController(this);
            rc.setRv();
            mmv.getF().setVisible(false);
        }
        else if (ae.getSource() == tim) {
            tim.stop();
            JOptionPane.showMessageDialog(mmv.getF(), "It is time to insert a mood!");
        }
    }

    private void addtheListeners() {
        mmv.getAddFoodBtn().addActionListener(this);
        mmv.getAddMoodBtn().addActionListener(this);
        mmv.getViewProfileBtn().addActionListener(this);
        mmv.getEditEntriesBtn().addActionListener(this);
        mmv.getViewRecommendationsBtn().addActionListener(this);
    }

    public FoodController getFc() {
        return fc;
    }
    
    public MainMenuView getMmv() {
        return mmv;
    }

    public MoodController getMc() {
        return mc;
    }
    
    public String getUserID(){
        return userID;
    }
    
    public void startTimer(){
        tim = new Timer(5000, this);
        tim.start();
    }
    
}
