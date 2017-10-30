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
class hasFood implements FoodMoodState {

    FoodMoodInsert a;
    
    public hasFood(FoodMoodInsert a) {
        this.a = a;
    }

    @Override
    public FoodModel insertFood(FoodModel a) {
        return null;
    }

    @Override
    public MoodModel insertMood(MoodModel a) {
        this.a.setFmState(this.a.getHasMood());
        return a;
    }
    
}
