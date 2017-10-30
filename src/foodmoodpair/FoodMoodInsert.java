/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmoodpair;

import foodmodel.FoodModel;
import moodmodel.MoodModel;

/**
 *
 * @author Zhewei
 */
public class FoodMoodInsert {
    
    FoodMoodState hasFood;
    FoodMoodState hasMood;
    
    FoodMoodState fmState;
    
    public FoodMoodInsert() {
        hasFood = new hasFood(this);
        hasMood = new hasMood(this);
        fmState = hasMood;
        System.out.println("setting" + fmState.toString());

    }
    
    void setFmState(FoodMoodState newFmState) {
        fmState = newFmState;
        System.out.println("setting" + newFmState.toString());
    }
    
    public FoodModel insertFood (FoodModel a) {
        return fmState.insertFood(a);
    }
    
    public MoodModel insertMood(MoodModel a) {
        return fmState.insertMood(a);
    }

    public FoodMoodState getHasFood() {
        return hasFood;
    }

    public FoodMoodState getHasMood() {
        return hasMood;
    }

    public FoodMoodState getFmState() {
        return fmState;
    }
    
}
