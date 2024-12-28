package Project3_StackOperations_ExpressionEvaluation;
/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
2/22/2024
Project3_StackOperation_ExpressionEvaluation
a project that show how computer calculate the math expression
first do the expression evaluation:
ExpressionEvaluation.java check invalid input and give back error message
second change infix to postfix:
InfixToPostfix.java change infix to postfix by using stack
third calculate the postfix to get the result:
PostfixEvaluation.java put number in stack calculate it when meet the operation than put result back to stack until the end
myExpression.java test code 
*/
import java.util.*;
public class myExpression {
	static Scanner input = new Scanner(System.in);
	static String infix;
	static String postfix;
	static String mathExpression;
	static boolean valid;


	public static void main(String[] args) {
		while (true) {
		     System.out.printf("Enter a math expression: ");
		     mathExpression=input.nextLine();
		     if (mathExpression.length()==0) {
		       System.out.printf("\nBye!");
		       break;
		     }

		    else {
		    	ExpressionEvaluation ee = new ExpressionEvaluation();
		    	valid = ee.expressionEvaluation(mathExpression);

		      //valid=true;   for today’s practice
		    	if (valid) {
		    		InfixToPostfix i2p = new InfixToPostfix();    
		    		String postfix = i2p.infix2postfix(mathExpression);
		    		
		    		System.out.println("infix:" + mathExpression);
		    		System.out.println("postfix:" + postfix);
		    		
		    		PostfixEvaluation pe = new PostfixEvaluation();
		    		int result = pe.postfixEvaluation(postfix);
		    		
		    		
		    		System.out.println("result:" + result);
		    		
		    	}else {
		    		System.out.println("invalid mathExpression, try again!");
		    	}
		    }
		} // end while
	} // end main


}


