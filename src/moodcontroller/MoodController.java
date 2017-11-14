/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcontroller;

import foodmoodpair.FoodMoodInsert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moodmodel.MoodList;
import moodmodel.MoodModel;
import moodview.AddMoodView;
import moodview.EditMoodView;
import navigationcontroller.NavigationController;
import databasecontroller.Database;

/**
 *
 * @author Zhewei
 */
public class MoodController implements ActionListener{
    
    private MoodList moods;
    protected AddMoodView amv;
    private NavigationController nc;
    private FoodMoodInsert fmi;
    protected EditMoodView emv;
    private MoodModelFactory mmf;
    
    public MoodController(MoodList moods, NavigationController nc, FoodMoodInsert fmi) {
        this.moods = moods;
        this.nc = nc;
        this.fmi = fmi;
        mmf = new MoodModelFactory();
    }

    public void setAmv(AddMoodView amv) {
        this.amv = amv;
        this.amv.getAddBtn().addActionListener(this);
        this.amv.getReturn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==amv.getAddBtn()) {
            MoodModel newMood = (MoodModel) mmf.getObject(-1, this);
            if (fmi.insertMood(newMood)!=null) {
                moods.addMood(newMood);
                try{
                    Database.POSTMood(newMood);
                }
                catch (Exception e){}
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
        else if (ae.getSource()==emv.getSave()) {
            saveMoodChanges();
        }
    }
    
    public MoodList getMoods() {
        return moods;
    }
    
    private void updateEditMood() {
        
        for (MoodModel mood: moods.getAllMoods()) {
            emv.getModel().addRow(new Object[]{mood.getDescription(), mood.getDateTime(), ""});
        }
    }

    private void saveMoodChanges() {
        for (int i = 0; i<emv.getModel().getRowCount(); i++) {
            if (emv.getModel().getValueAt(i, 2).equals("delete")) {
                moods.removeMood(i);
            }
            else if (!emv.getModel().getValueAt(i, 2).equals("")) {
                //unsure if this is working as thier is no interface component to check for saved changes - Nate
                moods.changeMood(i, new MoodModel((String) emv.getModel().getValueAt(i, 2), moods.getMood(i).getDateTime(), moods.getMood(i).getID()));
            }
        }
    }
    
    public void setEfv(EditMoodView efv) {
        this.emv = efv;
        this.updateEditMood();
        this.emv.getSave().addActionListener(this);
    }
}
