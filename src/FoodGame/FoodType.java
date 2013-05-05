/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;
import Util.Vector2;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author nate
 */
public class FoodType {
    
    public String Name;
    public int Calories;
    public int Fat;
    
    public boolean vegitarian = false;
    public boolean vegan= false;
    public boolean lactoseFree = false;
    public boolean peanutFree = false;
    
    public Image image;
    
    public Vector2 pos = new Vector2();
    
    public FoodType(int x, int y,String Name, Image i)
    {
        pos.x = x;
	pos.y = y;
        this.image = i;
        this.Name = Name;
        
    }
    
    public FoodType(int x, int y, String name, String imgName) {
		Image img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
		}
		
		pos.x = x;
		pos.y = y;

		this.Name = name;
		image = img;
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
    
    public Image getImageLoc()
    {
        return this.image;
    }
    
    public void setImageLoc(Image image)
    {
        this.image = image;
    }
    
    
    
    
    //actually set-get is uselss...just make the vars public
}
