package FoodGame;

public class girl extends scenario{

	public girl(){
		
		goal="You are a girl between the ages of 10 and 13. It is recommended that eat " +
				" between 1600 and 2000 calories each day. You should also eat 34g of protein, 130 grams of carbonhydrates, " +
				"50 grams of fat, and keep sugar at minimum." +
				"Drag the food into the lunch bag to meet your goals for the Day";
	
		min_calories=1600;
		max_calories=2000;
		goal_fat=50;
	    goal_sugars=20;
	    goal_proteins=34;
	    goal_carbs=130;
	    fruits=2;
	    vegetables=2;
	   
	}
}
