/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antcolony.SimulationObjects;

import Util.Vector2;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben
 */
public class Food implements Serializable {

	public Vector2 pos = new Vector2();
	public int foodQuality; //Have something to store nutrient ingredients
	public Image image; //replace this with a real image thing
	public final String foodName;

	public Food(int x, int y, String name, Image img) {
		pos.x = x;
		pos.y = y;
		foodQuality = 0;
		foodName = name;
		image = img;
	}

	public Food(int x, int y, String name, String imgName) {
		Image img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
		}
		
		pos.x = x;
		pos.y = y;
		foodQuality = 0;
		foodName = name;
		image = img;
	}

	public Food() {
		pos.x = 0;
		pos.y = 0;
		foodQuality = 0;
		foodName = "default";
	}


	public int getFoodQuality() {
		return foodQuality;
	}

	public void setFoodQuality(int foodQuality) {
		this.foodQuality = foodQuality;
	}

	public Vector2 getPos() {
		return pos;
	}

	public void setPos(Vector2 pos) {
		this.pos = pos;
	}
}
