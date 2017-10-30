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
public class FoodController implements ActionListener{
    
    private FoodList foods;
    private AddFoodView afv;
    private NavigationController nc;
    private FoodMoodInsert fmi;
    
    public FoodController(FoodList foods, NavigationController nc, FoodMoodInsert fmi) {
        this.foods = foods;
        this.nc = nc;
        this.fmi = fmi;
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
            if (fmi.insertFood(newFood)!=null) {
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
