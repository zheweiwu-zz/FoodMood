/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobjectmodel;

import java.time.LocalDateTime;

/**
 *
 * @author Nate
 */
public interface DataObjectModel {

    /**
     * Get the name of the data object
     * @return the name of the data object
     */
    String getName();
    
    /**
     * Set the name of the data object
     * @param name of the data object
     */
    void setName(String name);
    
    /**
     * Get the local date the data object was created
     * @return local date the data object was created
     */
    LocalDateTime getDateTime();
    
    /**
     * Set the local date of creation of the data object
     * @param dateTime of creation of the data object
     */
    void setDate(LocalDateTime dateTime);
    
    /**
     * Get the description of the data object
     * @return the description of the data object 
     */
    String getDescription();
    
    /**
     * Set the description of the data object
     * @param description the description of the data object
     */
    void setDescription(String description);   
}
