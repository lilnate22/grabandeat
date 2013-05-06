/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package antcolony.SimulationObjects;

import FoodGame.scenario;
import Util.Vector2;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	private int calories = 0;
	private String category = "";
	private double fat = 0;
	private double carbs = 0;
	private double protein = 0;
	private double sugars = 0;
	private boolean vegan = false;
	private boolean vegetarian = false;

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getSugars() {
		return sugars;
	}

	public void setSugars(double sugars) {
		this.sugars = sugars;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

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

	public Food(String name, String imgName) {
		foodName = name;
		Image img = null;
		try {
			img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			try {
				Logger.getLogger(Food.class.getName()).log(Level.SEVERE, "Failed to load image for "+ foodName, e);
				img = ImageIO.read(new File("images/default.png"));
			} catch (IOException ex) {
				Logger.getLogger(Food.class.getName()).log(Level.SEVERE, "Failed to load default", ex);
			}
			
		}

		pos.x = 0;
		pos.y = 0;
		foodQuality = 0;
		
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
