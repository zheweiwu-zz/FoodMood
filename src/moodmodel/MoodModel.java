/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodmodel;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Zhewei
 */
public class MoodModel {
    
    private String description;
    private Date recordedAt;
    private int moodID;
    private Random random;
    
    public MoodModel(String description) {
        this.description = description;
        this.recordedAt = new Date();
         random = new Random();
        this.moodID = random.nextInt(10000);
    }
    
    public MoodModel(String description, Date recordedAt) {
        this.description = description;
        this.recordedAt = recordedAt;
    }
    
    /**
     * Get the description of the mood
     * @return the description of the mood
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Set the description of the mood
     * @param description the description of the mood
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Get when the mood was recorded
     * @return when the mood was recorded
     */
    public Date getRecordedAt() {
        return recordedAt;
    }
    
    /**
     * Set when the mood was recorded
     * @param recordedAt when the mood was recorded
     */
    public void setRecordedAt(Date recordedAt) {
        this.recordedAt = recordedAt;
    }
    /**
     * Get the information at index
     * @param index index of retrieval
     * @return information at the index
     */
    public String getInfo(String index) {
        return description + " " + recordedAt+" "+moodID;
    }
    
    public int getID()
    {
        return moodID;
    }
}
