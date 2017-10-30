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
class hasMood implements FoodMoodState {

    FoodMoodInsert a;
    
    public hasMood(FoodMoodInsert a) {
        this.a = a;
    }

    @Override
    public FoodModel insertFood(FoodModel a) {
        System.out.println("inserting food in mood");
        this.a.setFmState(this.a.getHasFood());
        return a;
    }

    @Override
    public MoodModel insertMood(MoodModel a) {
        return null;
    }
    
}
