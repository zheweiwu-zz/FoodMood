/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationcontroller;

import foodcontroller.FoodController;
import foodmodel.FoodList;
import foodview.AddFoodView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moodcontroller.MoodController;
import moodmodel.MoodList;
import navigationview.MainMenuView;

/**
 *
 * @author Zhewei
 */
public class NavigationController implements ActionListener {

    MainMenuView mmv;
    private FoodController fc;
    MoodController mc;
    
    public NavigationController(MainMenuView mmv, FoodList foods, MoodList moods) {
        this.mmv = mmv;
        fc = new FoodController(foods, this);
        mc = new MoodController(moods, this);
        addtheListeners();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==mmv.getAddFoodBtn()) {
            AddFoodView afv = new AddFoodView();
            fc.setAfv(afv);
            mmv.getF().setVisible(false);
        }
        else if (ae.getSource()==mmv.getAddMoodBtn()) {
            
        }
        else if (ae.getSource()==mmv.getViewProfileBtn()) {
            
        }
        else if (ae.getSource()==mmv.getEditEntriesBtn()) {
            
        }
    }

    private void addtheListeners() {
        mmv.getAddFoodBtn().addActionListener(this);
        mmv.getViewProfileBtn().addActionListener(this);
        mmv.getViewProfileBtn().addActionListener(this);
        mmv.getEditEntriesBtn().addActionListener(this);    }

    public FoodController getFc() {
        return fc;
    }
    
    public MainMenuView getMmv() {
        return mmv;
    }

    public MoodController getMc() {
        return mc;
    }
}
