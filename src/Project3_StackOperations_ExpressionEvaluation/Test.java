package Project3_StackOperations_ExpressionEvaluation;
/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
2/9/2024
*/
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ExpressionEvaluation check = new ExpressionEvaluation();
		while(true) {
			System.out.println("Enter a math expression");
			String expression = input.nextLine();
			if (expression.isEmpty()) {
                System.out.println("bye");
                break;
            }
			System.out.println(expression + " is " + toValid(check.expressionEvaluation(expression)));
		}
	}
	public static String toValid(boolean test) {
		if (!test) {
			return "invalid";
		}else {
			return "valid";
		}
	}

}
