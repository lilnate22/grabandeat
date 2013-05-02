/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;
import java.util.ArrayList;
import java.util.List;

/**
 *this guy is what we will check for win state
 * @author nate
 */
public class Doctor {
    
    public List<FoodType> Fridge = new ArrayList<FoodType>();
    
    
    public Doctor()
    {
        
    }
    
    
    public boolean getVegan()
    {
        for(FoodType f : Fridge)
        {
            if(f.vegan == false)
                return false;
        }
        
        return true;
    }
    
    public boolean getVegitarian()
    {
        for(FoodType f : Fridge)
        {
            if(f.vegitarian == false)
                return false;
        }
        
        return true;
    }
    
    /* we need our diet to be bigger than X cals */
    public boolean HighCalCount(int calories)
    {
        int tmpCals = 0;
        for(FoodType f : Fridge)
        {
            tmpCals += f.Calories;
        }
        
        if (tmpCals > calories)
            return true;
        return false;
    }
    
    /* need all foods to be lower */
    public boolean lowCalCount(int cals)
    {
        int tmpCals = 0;
        for(FoodType f : Fridge)
        {
            tmpCals += f.Calories;
        }
        
        if (tmpCals < cals)
            return true;
        return false;
        
    }
    
    /* with the difference of 100 cals...get as close to our limit */
    public boolean equalCalCount(int cals)
    {
        int tmpCals = 0;
        for(FoodType f : Fridge)
        {
            tmpCals += f.Calories;
        }
        
        if ( ((tmpCals - 100) > cals) || ((tmpCals + 100) < cals))
            return true;
        return false;
    }
    
    
    public boolean lactoseFree()
    {
 
        for(FoodType f : Fridge)
        {
            if(f.lactoseFree == false)
                return false;
        }
        
        return true;
    }
    
    public boolean peanutFree()
    {
        for(FoodType f : Fridge)
        {
            if(f.peanutFree == false)
                return false;
        }
        
        return true;
    }
}
