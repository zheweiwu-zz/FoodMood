/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodmodel;

import dataobjectmodel.DataObjectModel;
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author Zhewei
 */
public class MoodModel implements DataObjectModel{
    
    private String description;
    private LocalDateTime recordedAt;
    private String moodID;
   //private Random random;
    private String parentFoodID;
    
    public MoodModel(String description) {
        this.description = description;
        this.recordedAt = LocalDateTime.now();
        //random = new Random();
        this.moodID = parentFoodID + recordedAt.toString();
    }
    
    public MoodModel(String description, LocalDateTime recordedAt, String moodID) {
        this.description = description;
        this.recordedAt = recordedAt;
        this.moodID = moodID;
    }
    
    /**
     * Get the description of the mood
     * @return the description of the mood
     */
    @Override
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Set the description of the mood
     * @param description the description of the mood
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Get when the mood was recorded
     * @return when the mood was recorded
     */
    @Override
    public LocalDateTime getDateTime() {
        return recordedAt;
    }
    
    /**
     * Set when the mood was recorded
     * @param dateTime when the mood was recorded
     */
    @Override
    public void setDate(LocalDateTime dateTime) {
        this.recordedAt = dateTime;
    }
    /**
     * Get the information at index
     * @param index index of retrieval
     * @return information at the index
     */
    public String getInfo(String index) {
        return description + " " + recordedAt+" "+moodID;
    }
    
    public String getID()
    {
        return moodID;
    }

    /**
     * Unsupported method for MoodModel
     * @return 
     */
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Moods do not support a name.");
    }

    /**
     * Unsupported method for MoodModel
     * @param name 
     */
    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Moods do not support a name.");
    }

    

    
}
