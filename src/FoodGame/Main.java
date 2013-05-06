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
	
	//todo place in own class, use to render amounts left etc
	private float protein;
	private float sugars;
	private float carbs;
	private float fats;
	private float calories;
	private String mode; //diabetic, vegan, vegetarian, boys, girls

	public static void main(String[] args) {
		SimulationState s = new SimulationState();
		
		//add the foods to the simulator
		
		
		//s.addFood(new Food(40, 50, "salad", "images/salad.png"));
		
		Renderer r = new Renderer(s);
		r.play();
		
		//perhaps insert code here that determines what mode and what amounts for the above are need?
		
	}
}
