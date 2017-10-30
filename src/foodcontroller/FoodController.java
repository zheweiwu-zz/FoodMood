/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodcontroller;

import foodmodel.FoodList;
import foodmodel.FoodModel;
import foodmoodpair.FoodMoodInsert;
import foodview.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import navigationcontroller.NavigationController;
/**
 *
 * @author Zhewei
 */
public class FoodController extends FoodMoodInsert implements ActionListener{
    
    private FoodList foods;
    private AddFoodView afv;
    private NavigationController nc;
    
    public FoodController(FoodList foods, NavigationController nc) {
        this.foods = foods;
        this.nc = nc;
    }

    public AddFoodView getAfv() {
        return afv;
    }

    public void setAfv(AddFoodView afv) {
        this.afv = afv;
        this.afv.getAddBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==afv.getAddBtn()) {
            //add the food
            FoodModel newFood = new FoodModel (afv.getFoodName());
            if (insertFood(newFood)!=null) {
                foods.addFood(newFood);
                afv.getF().dispose();
                nc.getMmv().getF().setVisible(true);
            }
            else {
                System.out.println("Already inserted food");
            }
        }
    }
}
