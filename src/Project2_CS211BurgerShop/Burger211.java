package Project2_CS211BurgerShop;

import java.util.HashMap;

public abstract class Burger211 {
	private static HashMap <Integer, BurgerInfo> burger = new HashMap <> ();
	
	  Burger211(){   
		  
		 burger.put(1, new BurgerInfo("Inheritance Burger", 4.5, "beef patty, tomato, onion, black olive, ranch source")); 
		 burger.put(2, new BurgerInfo("@Override Burger", 5.5, "beef patty, lime, onion, lettuce, tomato source"));
		 burger.put(3, new BurgerInfo("Polymorphism Burger", 6.5, "chicken breast, gallo, onion, ranch source"));	 		 
	  }	  
		
	  abstract void printMenu();    
	  
	  // add some getters
	  public String getName(int key) {
		  return burger.get(key).name;
	  }

	  public double getPrice(int key) {
		  return burger.get(key).price;
	  }

	  public String getTopping(int key) {
		  return burger.get(key).topping;
	  }
	
	  int getHowManyBurgers() {
		  return burger.size();
	  }
	  
}
