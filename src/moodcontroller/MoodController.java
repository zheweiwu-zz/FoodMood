/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moodmodel.MoodList;
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
    
    public MoodController(MoodList moods, NavigationController nc) {
        this.moods = moods;
        this.nc = nc;
    }

    public void setAmv(AddMoodView amv) {
        this.amv = amv;
        this.amv.getAddBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==amv.getAddBtn()) {
            amv.getF().dispose();
            nc.getMmv().getF().setVisible(true);
        }
    }
}
