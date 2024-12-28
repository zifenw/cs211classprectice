package HashMap;

import java.io.File;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
1/23/2024
I create two classes in this project; 
basicInfo class Defined private variables, used constructors, created get() and override toString() methods.
This is a test class for a Store Procurement System, used to assist store administrators in recording incoming items  
I used the HashMap helps me to efficient construction of search systems
*/

public class StoreProcurementHashMap {
	
	static HashMap<String, basicInfo> spsSystem = new HashMap<>();
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args) {
		select();
	}
	
	public static void select () {
		
		System.out.println("HashMap+Encapsulation+Constructor Test (CS 211-Winter 2024)");
		
		System.out.println("\nStore procurement system");	
		
		while (true) {
		
		try {
			
			System.out.println("\nChoose one 1)add  2)remove  3)search  4)all list  5)quit");
			
			int number = input.nextInt();
			
			if (number == 1) {
				add ();
				
			} else if (number == 2) {
				remove ();
				
			} else if (number == 3) {
				search();
				
			} else if (number == 4) {
				showAllList ();
				
			} else if (number == 5) {
				System.out.println("Bye!");
				break;
			}
			
			if (number <= 0 || number > 5) {
				System.out.println("You must have to choose between 1 - 5");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("\nYou can only input digit.");
			input.nextLine();
		}
	}
	
}

public static void add () {
	
	while (true) {
		
		try {
			
			System.out.println("Type the new product name:");
			String newID = input.next();
	
					
			if (spsSystem.containsKey(newID)) {	
				System.out.println("Product is already added");
				continue;
			}
			System.out.println("The product type?");
			String newType = input.next();
			
			System.out.println("How many do you want?");
			int newNumber = input.nextInt();
			
			System.out.println("How much price for each?");
			double newPrice = input.nextDouble();
			
			spsSystem.put(newID, new basicInfo(newType,newNumber, newPrice)); //spsSystem.put(newID, new basicInfo(newID,newType...)
			
			showAllList();
			break;
			
		} catch (InputMismatchException e){
			System.out.println("\nyou can only input digit");
			input.nextLine();
		}		
	}

}

public static void remove () {
	
	while (true) {
        showAllList();
        //check the hashMap is empty   
        if (spsSystem.size()== 0) {
            System.out.println("\nEmpty in the list.");
            break;
        }
        // ask for an id(=key) to be removed
        System.out.println("\nwhich product do you want to remove?");
        String deleteID = input.next();
        
        
        //check the id is in the list and remove if any
         
        if (spsSystem.containsKey(deleteID)) {   
        	spsSystem.remove(deleteID);
            System.out.println(deleteID + " successfully removed.");
            break;
        } else {
            System.out.println("Can't find " + deleteID +"\n");
        }
    }
    showAllList();
}

public static void search() {
	
	while (true) {
		
		//check if the size of the HashMap is not an empty
		if (spsSystem.size()== 0) {
            System.out.println("\nNo products in the list.");
            break;
        }    		
		
		// ask for an id to search
		System.out.println("\nWhich product do you want to search?");
        String searchID = input.next();
        
		
        if (spsSystem.containsKey(searchID)) {        	
        	System.out.println("\nWhat do you want to know from product=" + searchID +"?\n1) productType  2) purchNumber  3) eachPrice 4)all");
        	int number = input.nextInt();
        	if (number == 1) {
        		System.out.println(searchID + "[Product Type: " + spsSystem.get(searchID).getProductType()+"]");
				
			} else if (number == 2) {
				System.out.println(searchID + "[Product Number: " + spsSystem.get(searchID).getPurchNumber()+"]");
			} else if (number == 3) {
				System.out.println(searchID + "[Product Price: " + spsSystem.get(searchID).getEachPrice()+"]");
			} else if (number == 4) {
				System.out.println(searchID + "[Product Type: " + spsSystem.get(searchID).getProductType()+
						           "Product Number: " + spsSystem.get(searchID).getPurchNumber()+
						           "Product Price: " + spsSystem.get(searchID).getEachPrice()+"]");
			}
        } else {
            System.out.println("\nCan't find " + searchID);
        }

        break; 
	}
	
}

public static void showAllList () {
	System.out.println("\nCurrent Products ("+spsSystem.size()+")"); 
	for (String i : spsSystem.keySet()) {
		System.out.print("key: " + i + " basicInfo: " + spsSystem.get(i));
    }
}
}
