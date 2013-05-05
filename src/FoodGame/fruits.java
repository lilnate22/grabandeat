/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

/**
 *
 * @author nate
 */
public class fruits extends FoodType {
    
   public fruits(String name, int cal, float fat, float sugar, float carbs, float protein)
   {
       this.vegan = true;
       this.vegitarian = true;
       this.Name = name;
       this.Calories = cal;
       this.Fat = fat;
       this.sugars=sugar;
       this.proteins=protein;
       this.carbs=carbs;
   }
  
 
    
}
