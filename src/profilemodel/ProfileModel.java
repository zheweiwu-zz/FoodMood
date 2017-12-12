/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profilemodel;

import foodmodel.FoodModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nate
 */
public class ProfileModel implements Serializable {

    private String username;
    private List FoodList;
    private String age;
    private String password;
    private FoodModel food;
    private String weight;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ProfileModel(String username, String age, String weight ) {
        this.username = username;
        this.weight = weight;
        this.age = age;
    }    

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
