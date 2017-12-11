/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcontroller;

import dataobjectmodel.DataObjectModel;
import dataobjectmodel.IDataObjectFactory;
import foodcontroller.FoodController;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import moodcontroller.MoodController;
import moodmodel.MoodList;
import moodmodel.MoodModel;

/**
 *
 * @author Nate
 */
public class MoodModelFactory implements IDataObjectFactory{
    @Override
    public DataObjectModel getObject(int i, ActionListener controller) {
        MoodModel newMood;
        if(i == -1){
            newMood = (MoodModel) createNewObject(controller);
            return newMood;
        }
        else if(i != -1){
            newMood = (MoodModel) recreateObject(i, controller);
            return newMood;
        }
        else{
            throw new RuntimeException("Something went wrong in GetObject decision tree");
        }
    }
        
    @Override
    public DataObjectModel createNewObject(ActionListener moodController) {
        MoodController mc = (MoodController) moodController;
        int rating = mc.amv.getRating().getValue();
        DataObjectModel newMood = new MoodModel(rating);
        return newMood;
    }

    @Override
    public DataObjectModel recreateObject(int i, ActionListener moodController) {
        MoodController mc = (MoodController) moodController;
        MoodList moods = mc.getMoods();         
        return new MoodModel((int) mc.emv.getModel().getValueAt(i, 2), moods.getMood(i).getDateTime(), moods.getMood(i).getID());        
    }

    
                


}
