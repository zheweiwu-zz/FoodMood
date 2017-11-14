/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobjectmodel;

import foodcontroller.FoodController;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 *
 * @author Nate
 */
public interface IDataObjectFactory {
    /**
     * 
     * @param i if recreating object, i = integer to get index of object to be 
     * changed, else i is set to -1 
     * @param controller  parent controller passed to factory so necessary 
     * parameters can be obtained without the controllers needing to know specifics 
     * @return requested object
     */
    DataObjectModel getObject(int i, ActionListener controller);
    
    /**
     * 
     * @param controller parent controller
     * @return new DataObjectModel
     */
    DataObjectModel createNewObject(ActionListener controller);
    
    //DataObjectModel createNewObject(String descriptor);
    
    /**
     * 
     * @param i index of object to be changed
     * @param controller parent controller
     * @return recreated DataObject model
     */
    DataObjectModel recreateObject(int i, ActionListener controller);
    
}

//DataObjectModel recreateObject(String descriptor, LocalDateTime date, int IDnum);
