package Project3_StackOperations_ExpressionEvaluation;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionEvaluation{
	static HashMap<Integer,String> errorMessage = new HashMap<>();
	static HashMap<Character,Character> pair = new HashMap<>();

	public static boolean expressionEvaluation(String statement) {
	
		loadErrorMessage();
		Stack<Character> stack= new Stack<>(); 
	            
		boolean valid=true;
	
	
		for (int j = 0; j < statement.length(); j++) {        	
			char c = statement.charAt(j);
            		
			if ((c == '{') || (c == '(')) {
				stack.push(c);
			}
	                
			if (c==')') { 	
				if (stack.isEmpty()) {
					printError(statement, j, 2); // miss pair for )
					valid = false;
					break;
				}
				char PopedChar = stack.pop();  
				if (!(PopedChar == '(')) {
					printError(statement, j, 2); // miss pair for )               
					valid=false;
					break;
				}	    
			}
	                                
			if (c=='}') { 	
				if (stack.isEmpty()) {
					printError(statement, j, 1); // miss pair for }   
			
					valid = false;
					break;
				}
				char PopedChar = stack.pop();  
				if (!(PopedChar ==  '{')) {
					printError(statement, j, 1); // miss pair for }
					valid=false;
					break;
				}
			}
		 	  
		} // end for
		if(!stack.isEmpty()) {
			printError(statement, statement.length() - 1, 3);
			valid = false;
		}
		return valid;
		        
	}
	
	public static void loadErrorMessage() { //store the error message into the 
	  		
		errorMessage.put(1, "miss pair for }");
		errorMessage.put(2, "miss pair for )");
		errorMessage.put(3, "Incomplete Expression");
	  	
	}
		
	public static void printError(String statement, int location, int errorNo) {
		System.out.println(statement);
		for (int i = 0; i < location; i++) {
            System.out.print(" ");
        }
		System.out.print("^ " + errorMessage.get(errorNo)+ "\n");
		 
	}
		
}

