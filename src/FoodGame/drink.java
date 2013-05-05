/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

/**
 *
 * @author damali
 */
public class drink extends FoodType {
    
   public drink(String name, int cal, float fat, boolean vegan, boolean vegitarian, float sugar, float carbs, float protein)
   {
       this.vegan = vegan;
       this.vegitarian = vegitarian;
       this.Name = name;
       this.Calories = cal;
       this.Fat = fat;
       this.sugars=sugar;
       this.proteins=protein;
       this.carbs=carbs;
   }
  
 
    
}