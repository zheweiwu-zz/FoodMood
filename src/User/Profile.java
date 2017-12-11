/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;
import moodmodel.MoodModel;
import foodmodel.FoodModel;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class Profile {
    
    private String name;
    private String password;
    private String username;
    private String weight;
    private List<FoodModel> foods;
    private List<MoodModel> moods;

    public Profile(String name, String password, String username, String weight, List<FoodModel> foods, List<MoodModel> moods) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.weight = weight;
        this.foods = foods;
        this.moods = moods;
    }

    public Profile() {
        this.name = "";
        this.password = "";
        this.username = "";
        this.weight = "";
        this.foods = new ArrayList<>();
        this.moods = new ArrayList<>();
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<FoodModel> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodModel> foods) {
        this.foods = foods;
    }

    public List<MoodModel> getMoods() {
        return moods;
    }

    public void setMoods(List<MoodModel> moods) {
        this.moods = moods;
    }
    
    
}
