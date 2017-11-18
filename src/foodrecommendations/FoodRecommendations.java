/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodrecommendations;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author nadaziab
 */
public class FoodRecommendations {
 
    private HashMap<String, String> foodRecommendationsMap;
    private ArrayList<String> recommendationsList;
    
    /**
     * default constructor for food recommendations
     */
    public FoodRecommendations() {
        
        recommendationsList = new ArrayList();
        recommendationsList.add("Salmon");
        recommendationsList.add("Spinach");
        recommendationsList.add("Blueberries");
        recommendationsList.add("Chocolate");
        
        foodRecommendationsMap = new HashMap();
        foodRecommendationsMap.put("Salmon", "lowers risk of depression");
        foodRecommendationsMap.put("Spinach", "positively impacts serotonin levels and boosts mood");
        foodRecommendationsMap.put("Blueberries", "associated with having a more positive mood");
        foodRecommendationsMap.put("Chocolate", "increases feelings of contentment");
        
    }
    
    /**
     * get the food recommendation descriptions
     * @return HashMap of food recommendations, the Key is the food name, the Value is the description
     */
    public HashMap getRecommendatiosnMap() {
        return foodRecommendationsMap;
    }
    
    /**
     * get the list of food recommendations
     * @return ArrayList of food recommendations
     */
    public ArrayList<String> getRecommendationsList() {
        return recommendationsList;
    }
}
