/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmodel;

import dataobjectmodel.DataObjectModel;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import moodmodel.MoodList;
import databasecontroller.Database;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Zhewei
 */
public class FoodModel implements DataObjectModel{
    
    private String name;
    private LocalDateTime consumedAtDT;
    private String consumedAt;
    private String foodID;
    private Random random;
    private String parentUserID;
    private MoodList linkedMoods;
    
    public FoodModel() {
        System.out.println("FoodModel instantiated");
    }
    
    public FoodModel(String name, String userID) {
        this.name = name;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hhmmssddmmyyyy");
        this.consumedAtDT = LocalDateTime.now();
        this.consumedAt = dtf.format(consumedAtDT);
        //random = new Random();
        this.foodID = this.name+consumedAt;
        this.parentUserID = Database.lastFoodID;
    }
    
    public FoodModel(String name, LocalDateTime date, String foodID) {
        this.name = name;
        this.consumedAtDT = date;
        this.foodID = foodID;
    }
    
    /**
     * Get the name of the food
     * @return name of the food
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Change the name of the food
     * @param name new name of the food
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get when the food was consumed
     * @return the date and time at which the food was consumed
     */
    @Override
    public LocalDateTime getDateTime() {
        return consumedAtDT.truncatedTo(ChronoUnit.SECONDS);
    }
    
    /**
     * Change when the food was consumed
     * @param dateTime the new time
     */
    @Override
    public void setDate(LocalDateTime dateTime) {
        this.consumedAtDT = dateTime;
    }
    
    /**
     * Get information about the food
     * @return Get the name of food and when it was consumed
     */
    public String getInfo() {
        return name+" "+consumedAt+" "+foodID;
    }
    
    /**
     * Get the ID of the food
     * @return ID of the food
     */
    public String getID() {
        return foodID;
    }
    
    public String getParentUserID(){
        return parentUserID;
    }
    
    public void getMoodList(MoodList linkedMoods){
        //get moodlist
    }

    

    
    /**
     * Unsupported method for FoodModel
     * @return 
     */
    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Foods do not support a description."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Unsupported method for FoodModel
     * @param description 
     */
    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException("Foods do not support a description."); //To change body of generated methods, choose Tools | Templates.
    }
}
