package Project2_CS211BurgerShop;

import java.util.Scanner;

/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
2/1/2024
I create six classes in this project, and use one web design print class from professor Kim; 
BurgerINfo. java: Define variables and constructor
Burger211.java: Choosing a Data Structure – HashMap, and set initial data. extends BurgerINfo
Menu.java: The core area of the project includes important methods such as calculating discounts, comparing temperatures, and modifying toppings. extends Burger211
ExchangeRate.java: get different price according to the exchange rate big data from ExchangeRate-API 
WeatherAPP.java: get different temperature big data from OpenWeather.
myFranchise.java: test program 


basicInfo class Defined private variables, used constructors, created get() and override toString() methods.
This is a test class for a Store Procurement System, used to assist store administrators in recording incoming items  
I used the HashMap helps me to efficient construction of search systems


Difficulties encountered and resolved:
1. Understanding inheritance, abstraction, code architecture, and the relationships between different classes.
2. Solve the special case of USD, where USD is 1 in big data and not double. Long is needed to solve this special case.
3. Using "input. nextLine()" by itself after reading a numerical value with "input. nextInt()" or similar methods is a common practice in Java to handle the newline character left in the input buffer
4. Return the modified getTopping and call the updateTopping method in the getTopping method of the override.
5. Capture input errors
6. Modify character colors;
7. connection with BigData
*/

public class myFranchise {
	
	public static final String ANSI_RESET = "\u001B[0m";   
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String SET_PLAIN_TEXT = "\033[0;0m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";

	public static void main(String[] args) {
		String country;
		String franchiseName;
		int discount=0;
		String promotion="";
		int tooHot=0;
		int burgerNumber=0;
		String newTopping;
		
		Scanner input = new Scanner(System.in);	
		
		System.out.println(SET_BOLD_TEXT + ANSI_RED + "\nProject 2. Burger 211" + " (Winter 2024)"+ ANSI_RESET);		
		boolean run=true;
		while (run) {
			System.out.println(ANSI_GREEN +"\nEnter country code. (Alpha-2 code)"+ANSI_RED);
			country =input.next();
			if (country.equals("0")) {
				run=false;
				System.out.println("Bye!");
				break;
			}
			else {
				input.nextLine();
				System.out.println(ANSI_GREEN +"\nEnter your franchise name."+ANSI_RED);	
				franchiseName = input.nextLine();
				
				Menu franchise = new Menu(country, franchiseName);
				
				
				System.out.println(ANSI_GREEN +"Enter the promotion. If there is no promotion, press Enter."+ANSI_RED);
				promotion = input.nextLine();	
				System.out.println(ANSI_GREEN +"Enter the promotion discount rate(%)(0~99)"+ANSI_RED);
				discount = input.nextInt();
				franchise.Promotion((double)discount/100.0, promotion);
				
				
				System.out.println(ANSI_GREEN +"Enter a temperature for 'too hot to eat 10% off' promotion"+ANSI_RED);
				tooHot = input.nextInt();
				franchise.PromotionTooHot(tooHot);
																			

				System.out.println(ANSI_GREEN +"Which burger would you like to change the toppint? (enter 0 if not)" +ANSI_PURPLE);
				for(int i=1; i<=3; i++) {
			    	 System.out.println(i+") "+franchise.getName(i)+": "+franchise.getTopping(i));
			    }
				boolean validInput = false;
				
				while(!validInput) {
					try {
						System.out.println(ANSI_RED);
						burgerNumber= input.nextInt();
						
					
						if(burgerNumber<0||burgerNumber>3) {
							System.out.println("you need input a number within 0 and 3");
							input.nextLine();
						}else if(burgerNumber == 0){
							validInput = true;
						}else {
							validInput = true;
						}
					}
				
					catch(Exception e) {
						System.out.println("you should input a number");
						input.nextLine();
					}
				}
			    input.nextLine();
			    if(burgerNumber != 0) {
			    	System.out.println(ANSI_GREEN + franchise.getName(burgerNumber)+": "+franchise.getTopping(burgerNumber));
			    	System.out.println("enter the new topping you want"+ANSI_RED);
			    	newTopping = input.nextLine();
			    	franchise.updateTopping(burgerNumber, newTopping);
			    }    			     
				franchise.printMenu(); 			     				   
			}		
				
		}   

	}

}
