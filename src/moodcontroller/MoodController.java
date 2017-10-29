/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcontroller;

import moodmodel.MoodList;
import navigationcontroller.NavigationController;

/**
 *
 * @author Zhewei
 */
public class MoodController {
    
    private MoodList moods;
    private NavigationController nc;
    
    public MoodController(MoodList moods, NavigationController nc) {
        this.moods = moods;
        this.nc = nc;
    }
}
