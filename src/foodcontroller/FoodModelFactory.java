/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcontroller;

import dataobjectmodel.DataObjectModel;
import dataobjectmodel.IDataObjectFactory;
import foodcontroller.FoodController;
import foodmodel.FoodList;
import foodmodel.FoodModel;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

/**
 *
 * @author Nate
 */
public class FoodModelFactory implements IDataObjectFactory{

    
    @Override
    public DataObjectModel getObject(int i, ActionListener controller) {
        FoodModel newFood;
        if(i == -1){
           newFood = (FoodModel) createNewObject(controller);
           return newFood;
        }
        else if(i != -1){
           newFood = (FoodModel) recreateObject(i, controller);
           return newFood;
        }
        else{
            throw new RuntimeException("Something went wrong in GetObject decision tree");
        }
    }
        
    @Override
    public DataObjectModel createNewObject(ActionListener foodController) {
        FoodController fc = (FoodController) foodController;
        String name = fc.afv.getFoodName();
        DataObjectModel newFood = new FoodModel(name);
        return newFood;
    }

    @Override
    public DataObjectModel recreateObject(int i, ActionListener foodController) {
        FoodController fc = (FoodController) foodController;
        FoodList foods = fc.getFoods();
        if(i == -1){
            throw new RuntimeException("cannot recreate object, invalid index given");            
        }
        else{return new FoodModel((String) fc.efv.getModel().getValueAt(i, 2), foods.getFood(i).getDateTime(), foods.getFood(i).getID());}
        
    }

    
    

    
}
