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

/**
 *
 * @author Zhewei
 */
public class FoodModel implements DataObjectModel{
    
    private String name;
    private LocalDateTime consumedAt;
    private int foodID;
    private Random random;
    
    public FoodModel() {
        System.out.println("FoodModel instantiated");
    }
    
    public FoodModel(String name) {
        this.name = name;
        this.consumedAt = LocalDateTime.now();
        random = new Random();
        this.foodID = random.nextInt(10000);
    }
    
    public FoodModel(String name, LocalDateTime date, int foodID) {
        this.name = name;
        this.consumedAt = date;
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
        return consumedAt.truncatedTo(ChronoUnit.SECONDS);
    }
    
    /**
     * Change when the food was consumed
     * @param dateTime the new time
     */
    @Override
    public void setDate(LocalDateTime dateTime) {
        this.consumedAt = dateTime;
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
    public int getID() {
        return foodID;
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
