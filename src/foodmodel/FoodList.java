/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmodel;

import java.util.ArrayList;

/**
 *
 * @author Zhewei
 */
public class FoodList {
    private ArrayList<FoodModel> foods;
    
    public FoodList (ArrayList<FoodModel> foods) {
        this.foods = foods;
    }
    
    public void addFood(FoodModel food) {
        foods.add(food);
    }
    
    public void changeFood(int index, FoodModel food) {
        foods.set(index, food);
    }
    
    public void removeFood(int index) {
        foods.remove(index);
    }
    
    public FoodModel getFood(int index) {
        return foods.get(index);
    }
}
