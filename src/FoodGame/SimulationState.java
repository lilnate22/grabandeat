/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

import Util.Vector2;
import antcolony.SimulationObjects.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ben
 */
public class SimulationState implements Serializable {
	// TODO make sure this serializes properly for saving

	public final List<FoodType> foodList = new ArrayList<>();

	public SimulationState() {
	}

	public void addFood(FoodType food) {
		foodList.add(food);
	}

	public List<FoodType> getFoodList() {
		return foodList;
	}

	public FoodType clickFood(int x, int y) {

		for (FoodType f : foodList) {
			System.out.println(x + " " + y);
			int relX = x - f.pos.x;
			int relY = y - f.pos.y;
			System.out.println(relX + " " + relY);
			if (relX >= 0 && relY >= 0 && relX <= f.image.getWidth(null) && relY <= f.image.getHeight(null)) {
				return f;
			}


		}
		return null;

	}
}
