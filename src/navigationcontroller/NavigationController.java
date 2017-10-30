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
import moodcontroller.MoodController;
import moodmodel.MoodList;
import moodview.AddMoodView;
import navigationview.MainMenuView;

/**
 *
 * @author Zhewei
 */
public class NavigationController implements ActionListener {

    private MainMenuView mmv;
    private FoodController fc;
    private MoodController mc;
    private FoodMoodInsert fmi;
    EditFoodView efv;
    int userID;
    
    public NavigationController(MainMenuView mmv, FoodList foods, MoodList moods, int user) {
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
            
        }
        else if (ae.getSource()==mmv.getEditEntriesBtn()) {
            efv = new EditFoodView();
            this.updateEditFood();
            efv.getSave().addActionListener(this);
        }
        else if (ae.getSource()==efv.getSave()) {
            saveFoodChanges();
        }
    }

    private void addtheListeners() {
        mmv.getAddFoodBtn().addActionListener(this);
        mmv.getAddMoodBtn().addActionListener(this);
        mmv.getViewProfileBtn().addActionListener(this);
        mmv.getEditEntriesBtn().addActionListener(this);
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
    
    private void updateEditFood() {
        
        //efv.getModel().addRow(new Object[]{"Food", "Consumed at", "New Name"});
        
        for (FoodModel food: fc.getFoods().getAllFoods()) {
            efv.getModel().addRow(new Object[]{food.getName(), food.getConsumedAt(), ""});
        }
    }

    private void saveFoodChanges() {
        //efv.getModel().get
    }
}
