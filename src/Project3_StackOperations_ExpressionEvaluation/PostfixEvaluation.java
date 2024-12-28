package Project3_StackOperations_ExpressionEvaluation;
import java.util.*;
public class PostfixEvaluation {
	public static Stack<Integer> stack = new Stack<>();
	public int postfixEvaluation(String postfix) {
		Scanner input = new Scanner(postfix);
		
		//This while-loop scans the postfix expression
		while(input.hasNext()) {
			if(input.hasNextInt()) { //if the token is a number then push into stack
				stack.push(input.nextInt());
			}
			
			else {//if the token is string(operator)
				String token = input.next();
				int value1 = stack.pop();
				int value2 = stack.pop();
				if(token.equals("+")) {
					stack.push(value2 + value1); 
				}else if(token.equals("-")) {
					stack.push(value2 - value1); 
				}else if(token.equals("*")) {
					stack.push(value2 * value1); 
				}else  {
					stack.push(value2 / value1); 
				}

			}
		}
		return stack.pop();
	}
		
}
