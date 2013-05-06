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

	private static int FRIDGE_SIZE = 12;
	public static int FOOD_SIZE = 52;
	public final Map<String, List<Food>> foodMap;
	public final List<Food> curFoods = new ArrayList<>();
	public final List<Food> foodsInBag = new ArrayList<>();
	public final List<Food> remainingFood = new ArrayList<>();
	public final static int BAG_X = 551;
	public final static int BAG_Y = 400;

	public SimulationState() {
		foodMap = loadFoods();
	}

	public void setUpFridge() {
		Random rand = new Random();
		if (remainingFood.isEmpty()) {
			for (List<Food> l : foodMap.values()) {
				remainingFood.addAll(l);
			}
		}
		while (curFoods.size() < FRIDGE_SIZE) {
			int choice = rand.nextInt(remainingFood.size());
			curFoods.add(remainingFood.remove(choice));
		}
	}

	public List<Food> getFoods() {
		List<Food> out = new LinkedList<>();
		out.addAll(curFoods);
		out.addAll(foodsInBag);
		return out;
	}

	public Food clickFood(int x, int y) {

		for (Food f : curFoods) {
//			System.out.println(x + " " + y);
			int relX = x - f.pos.x;
			int relY = y - f.pos.y;
//			System.out.println(relX + " " + relY);
			if (relX >= 0 && relY >= 0 && relX <= FOOD_SIZE && relY <= FOOD_SIZE) {
				return f;
			}


		}

		for (int i = 0; i < foodsInBag.size(); i++) {
			Food f = foodsInBag.get(i);
			int relX = x - f.pos.x;
			int relY = y - f.pos.y;
			if (relX >= 0 && relY >= 0 && relX <= FOOD_SIZE && relY <= FOOD_SIZE) {
				return f;
			}
		}
		return null;

	}

	public List<Food> getBagContents() {
		return foodsInBag;
	}

	//location of fridge as input, followed by location of bag thing
	public void foodSnap(int x, int y) {

		for (int i = 0; i < curFoods.size(); i++) {
			Food f = curFoods.get(i);
			if (f.pos.x >= BAG_X && f.pos.y >= BAG_Y && f.pos.x <= BAG_X + 400 && f.pos.y <= BAG_Y + 160) {
				foodsInBag.add(curFoods.remove(i));
			} else {
				f.setPos(new Vector2(x + 150 + 70 * (i % 3), y + 250 + (int) (i / 3) * 65));
			}
		}
		for (int i = 0; i < foodsInBag.size(); i++) {
			Food f = foodsInBag.get(i);
			if (f.pos.x >= BAG_X && f.pos.y >= BAG_Y && f.pos.x <= BAG_X + 400 && f.pos.y <= BAG_Y + 160) {
				f.setPos(new Vector2(BAG_X + 30 + 60 * (i % 3), BAG_Y + 30 + (int) (i / 3) * 55));
			} else {

				remainingFood.add(foodsInBag.remove(i));
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
