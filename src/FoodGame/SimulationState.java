/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

import Util.Vector2;
import antcolony.SimulationObjects.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Ben
 */
public class SimulationState implements Serializable {
	// TODO make sure this serializes properly for saving

	private static int FRIDGE_SIZE = 8;
	public static int FOOD_SIZE = 50;
	public final Map<String, List<Food>> foodMap;
	public final List<Food> curFoods = new ArrayList<>();
	public final List<Food> foodsInBag = new ArrayList<>();

	public SimulationState() {
		foodMap = loadFoods();
	}

	public void setUpFridge() {
		Random rand = new Random();
		List<Food> foodList = new ArrayList<>();
		for (List<Food> l : foodMap.values()) {
			foodList.addAll(l);
		}
		while (curFoods.size() < FRIDGE_SIZE) {
			int choice = rand.nextInt(foodList.size());
			curFoods.add(foodList.get(choice));
		}
	}

	public List<Food> getFoods() {
		return curFoods;
	}

	public Food clickFood(int x, int y) {

		for (Food f : curFoods) {
			System.out.println(x + " " + y);
			int relX = x - f.pos.x;
			int relY = y - f.pos.y;
			System.out.println(relX + " " + relY);
			if (relX >= 0 && relY >= 0 && relX <= FOOD_SIZE && relY <= FOOD_SIZE) {
				return f;
			}


		}
		return null;

	}
	//location of fridge as input, followed by location of bag thing

	public void foodSnap(int x, int y, int bagX, int bagY) {

		for (int i = 0; i < curFoods.size(); i++) {
			Food f = curFoods.get(i);
			if (f.pos.x >= bagX && f.pos.y >= bagY && f.pos.x <= bagX + 200 && f.pos.y <= bagY + 60) {
			} else {
				f.setPos(new Vector2(x + 30 + 60 * (i % 2), y + 30 + (int) (i / 2) * 60));
			}
		}
	}

	public Map<String, List<Food>> loadFoods() {
		try {

			File file = new File("database.json");
			Scanner s = new Scanner(file);
			Map<String, List<Food>> foods = new HashMap<>();
			while (s.hasNext()) {
				String line = s.nextLine();
				JSONObject obj = new JSONObject(line);
				Food food = new Food(obj.getString("Name"), "./images/" + obj.getString("Name") + ".png");
				food.setPos(new Vector2(0, 0));
				int calories = obj.getInt("Calories");
				String category = obj.getString("Category");
				double fat = obj.getDouble("Fat");
				double carbs = obj.getDouble("Carbs");
				double protein = obj.getDouble("Protein");
				double sugars = obj.getDouble("Sugars");
				boolean vegan = obj.getBoolean("Vegan");
				boolean vegetarian = obj.getBoolean("Vegetarian");

				food.setCalories(calories);
				food.setCarbs(carbs);
				food.setCategory(category);
				food.setFat(fat);
				food.setProtein(protein);
				food.setSugars(sugars);
				food.setVegan(vegan);
				food.setVegetarian(vegetarian);
				if (!foods.containsKey(category)) {
					foods.put(category, new ArrayList<Food>());

				}
				foods.get(category).add(food);

			}
			return foods;

		} catch (FileNotFoundException ex) {
			Logger.getLogger(scenario.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}
}
