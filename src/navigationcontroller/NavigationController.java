/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationview.MainMenuView;

/**
 *
 * @author Zhewei
 */
public class NavigationController implements ActionListener {

    MainMenuView mmv;
    
    public NavigationController(MainMenuView mmv) {
        this.mmv = mmv;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==mmv.getAddFoodBtn()) {
            
        }
        else if (ae.getSource()==mmv.getAddMoodBtn()) {
            
        }
        else if (ae.getSource()==mmv.getViewProfileBtn()) {
            
        }
        else if (ae.getSource()==mmv.getEditEntriesBtn()) {
            
        }
    }
}
