/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

/**
 *
 * @author nate
 */
public class FoodType {
    
    public String Name;
    public int Calories;
    public int Fat;
    
    public boolean vegitarian;
    public boolean vegan;
    public boolean lactoseFree;
    public boolean peanutFree;
    
    private String ImageLoc;
    
    
    public FoodType()
    {
        
    }
    
    public FoodType(String name)
    {
        this.Name = name;
    }
    
    
    public void setCalories(int cal)
    {
        this.Calories = cal;
    }
    
    
    public int getCalories()
    {
        return this.Calories;
    }
    
    public String getImageLoc()
    {
        return this.ImageLoc;
    }
    
    public void setImageLoc(String loc)
    {
        this.ImageLoc = loc;
    }
    
    //actually set-get is uselss...just make the vars public
}
