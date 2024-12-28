package Project3_StackOperations_ExpressionEvaluation;
import java.util.*;
/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
2/22/2024
Infix to postfix
Ask the user for an infix expression. Assume the expression is valid.
If the expression is empty, then stop running. otherwise 
Convert the infix expression to a postfix expression.
*/
public class InfixToPostfix {
	public static String post = "";
	public static HashMap<Character, Integer> precedence = new HashMap<>();
	     
	public String infix2postfix(String infix) {

		loadPrecedence();
		
		Stack<Character> stack = new Stack<Character>();   
		post = "";
		
		for (int j=0; j<infix.length(); j++) { //read all the symbols one by one left to right
			char c = infix.charAt(j);
			if (Character.isDigit(c)) { // if the token is operand, then directly add it to post
				post += c; // Append the operand to the post string
			} 
			
			if(j+1 >= infix.length() || !Character.isDigit(infix.charAt(j + 1))) {
				post += " ";
			}
	
			if(c == '(' || c == '{') {  // if the token is '(','{'then push it on to the stack
		       stack.push(c);
			}
			if (c == ')') {
			   char p=' ';          
			   while(!stack.isEmpty() && p != '('){ //pop all the contents of stack until respective '(' is poped 
				   p=stack.pop();
				   if (p != '(') {
			            post += p + " ";  
			        }  
			   } 
			     //'(' are not added to the result 
			} 
			if (c == '}') {
				char p=' ';
				while (!stack.isEmpty() && p != '{'){//pop all the contents of stack until respective '{' is poped 
					p=stack.pop();
					if (p != '{') {
			            post += p + " ";
			        }
				} 
				//'{' are not added to the result
			}
			if (c == '+' || c == '-' || c == '*' || c == '/') {

				while (!stack.isEmpty() && (precedence.get(stack.peek())>= precedence.get(c))) {
				     char p = stack.pop();
				     post+= p+ " "; 
				}
				stack.push(c);
			}
		
		}
		while (!stack.isEmpty()) {
			char p = stack.pop();
			post +=p;
		}
		return post;
	}
		
	public static void loadPrecedence(){
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('(', 0);
		precedence.put('{', 0);
	}
		     
}
