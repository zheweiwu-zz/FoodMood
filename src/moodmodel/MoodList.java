/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodmodel;

import java.util.ArrayList;

/**
 *
 * @author Zhewei
 */
public class MoodList {
    private ArrayList<MoodModel> moods;
    
    public MoodList(ArrayList<MoodModel> moods) {
        this.moods = moods;
    }

    public MoodList() {
        moods = new ArrayList<>();
    }
    
    public void addMood(MoodModel mood) {
        moods.add(mood);
    }
    
    /**
     * Change a mood in the list of moods
     * @param index the index of the mood to be changed
     * @param mood the mood to be added in place of old mood
     */
    public void changeMood(int index, MoodModel mood) {
        moods.set(index, mood);
    }
    
    /**
     * Remove a mood from the list of moods
     * @param index the index of the mood to be removed
     */
    public void removeMood(int index) {
        moods.remove(index);
    }
    
    public moodmodel.MoodModel getMood(int index) {
        return moods.get(index);
    }
    
    public ArrayList<MoodModel> getAllMoods() {
        return moods;
    }
}
