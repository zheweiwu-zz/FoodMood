/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcontroller;

import foodmodel.FoodModel;
import foodmoodpair.FoodMoodInsert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moodmodel.MoodList;
import moodmodel.MoodModel;
import moodview.AddMoodView;
import navigationcontroller.NavigationController;

/**
 *
 * @author Zhewei
 */
public class MoodController implements ActionListener{
    
    private MoodList moods;
    private AddMoodView amv;
    private NavigationController nc;
    private FoodMoodInsert fmi;
    
    public MoodController(MoodList moods, NavigationController nc, FoodMoodInsert fmi) {
        this.moods = moods;
        this.nc = nc;
        this.fmi = fmi;
    }

    public void setAmv(AddMoodView amv) {
        this.amv = amv;
        this.amv.getAddBtn().addActionListener(this);
        this.amv.getReturn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==amv.getAddBtn()) {
            MoodModel newMood = new MoodModel (amv.getMoodDescription());
            if (fmi.insertMood(newMood)!=null) {
                moods.addMood(newMood);
                amv.getF().dispose();
                nc.getMmv().getF().setVisible(true);
            }
            else {
                System.out.println("Already inserted mood");
            }
        }
        else if (ae.getSource()==amv.getReturn()) {
            amv.getF().dispose();
            nc.getMmv().getF().setVisible(true);
        }
    }
}
