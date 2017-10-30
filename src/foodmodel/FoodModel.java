/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmodel;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Zhewei
 */
public class FoodModel {
    
    private String name;
    private Date consumedAt;
    private int foodID;
    private Random random;
    
    public FoodModel() {
        System.out.println("FoodModel instantiated");
    }
    
    public FoodModel(String name) {
        this.name = name;
        this.consumedAt = new Date();
        random = new Random();
        this.foodID = random.nextInt(10000);
    }
    
    public FoodModel(String name, Date date, int foodID) {
        this.name = name;
        this.consumedAt = date;
        this.foodID = foodID;
    }
    /**
     * Get the name of the food
     * @return name of the food
     */
    public String getName() {
        return name;
    }
    /**
     * Change the name of the food
     * @param name new name of the food
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get when the food was consumed
     * @return the date and time at which the food was consumed
     */
    public Date getConsumedAt() {
        return consumedAt;
    }
    /**
     * Change when the food was consumed
     * @param consumedAt the new time
     */
    public void setConsumedAt(Date consumedAt) {
        this.consumedAt = consumedAt;
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
}
