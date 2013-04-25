/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodGame;

import antcolony.SimulationObjects.Food;

/**
 *
 * @author Ben
 */
public class Main {

	public static void main(String[] args) {
		SimulationState s = new SimulationState();
		s.addFood(new Food(400, 50, "salad", "images/salad.png"));
		s.addFood(new Food(400, 400, "burger", "images/burger.png"));
		Renderer r = new Renderer(s);
		r.play();
	}
}
