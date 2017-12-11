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
import databasecontroller.Database;
/**
 *
 * @author Zhewei
 */
public class FoodController implements ActionListener{
    
    private FoodList foods;
    protected AddFoodView afv;
    protected NavigationController nc;
    private FoodMoodInsert fmi;
    protected EditFoodView efv;
    private FoodModelFactory fmf;
    
    public FoodController(FoodList foods, NavigationController nc, FoodMoodInsert fmi) {
        this.foods = foods;
        this.nc = nc;
        this.fmi = fmi;
        this.fmf = new FoodModelFactory();
        
    }

    public AddFoodView getAfv() {
        return afv;
    }

    public void setAfv(AddFoodView afv) {
        this.afv = afv;
        this.afv.getAddBtn().addActionListener(this);
        this.afv.getReturn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==afv.getAddBtn()) {
            //add the food
            FoodModel newFood = (FoodModel) fmf.getObject(-1, this);
            if (fmi.insertFood(newFood)!=null) {
                foods.addFood(newFood);
                try{
                    Database.POSTFood(newFood);
                }
                catch (Exception e){}
                afv.getF().dispose();
                nc.getMmv().getF().setVisible(true);
            }
            else {
                System.out.println("Already inserted food");
            }
        }
        else if (ae.getSource()==afv.getReturn()) {
            afv.getF().dispose();
            nc.getMmv().getF().setVisible(true);
        }
        else if (ae.getSource()==efv.getSave()) {
            saveFoodChanges();
        }
    }

    public FoodList getFoods() {
        return foods;
    }
    
    private void updateEditFood() {
        
        for (FoodModel food: foods.getAllFoods()) {
            efv.getModel().addRow(new Object[]{food.getName(), food.getDateTime(), ""});
        }
    }

    private void saveFoodChanges() {
        for (int i = 0; i<efv.getModel().getRowCount(); i++) {
            if (efv.getModel().getValueAt(i, 2).equals("delete")) {
                // remove food from database upon running
                foods.removeFood(i);   
            }
            else if (!efv.getModel().getValueAt(i, 2).equals("")) {
                foods.changeFood(i, new FoodModel((String) efv.getModel().getValueAt(i, 2), foods.getFood(i).getDateTime(), foods.getFood(i).getID()));
                //Database.updateFoodData(foods.getFood(i).getID(), efv.getModel().getValueAt(i,2).toString(), foods.getFood(i).getDateTime());
            }
        }
    }
    
    public void setEfv(EditFoodView efv) {
        this.efv = efv;
        this.updateEditFood();
        this.efv.getSave().addActionListener(this);
    }
}
