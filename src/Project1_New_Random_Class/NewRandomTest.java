/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
1/9/2024
In this assignment, I create few method to test the NewRamdom class.
I used the calling method, while-loop, for loop, type boolean, array list, try, catch, break, and continue .
*/
package Project1_New_Random_Class;
import java.util.*;
public class NewRandomTest {

	static String[] method = new String [5];
	static String[] errorMsg = new String [2];
	static int howManyTest=30;
	static NewRandom nRand = new NewRandom();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		loadMenu();
		loadErrorMsg();
		selectNtest();

	}

	public static void loadMenu() {
		method[0]="nextInt(int low, int high)";
		method[1]="nextChar()";
		method[2]="nextChar(char from, char to)";
		method[3]="nextChar(char from, int i)";
		method[4]="nextSpecialChar()";
		
	}
	
	public static void loadErrorMsg() {
		errorMsg[0]="inpit error\nMust be 0..5";
		errorMsg[1]="inpit error\nMust be digit";
	}
	
	public static void selectNtest() {
		System.out.println("\nProject 1. New Random Class. (Winter Quarter 2024)");
		boolean run=true; int index;
		while(run) {
			System.out.println("\nWhat method would you like to test?");
			for (int  i = 0; i<method.length; i++) {
				System.out.println(i + ". " + method[i]);
			}
			System.out.println(method.length +": quit");
			String whichTest = input.next();
			
			try {
				index = Integer.parseInt(whichTest);	 
					if(index == method.length) {  
						System.out.println("Bye!");
						break;
					}else if(index >=0 && index <=4){
						test(index);
					}else {
						System.out.println(errorMsg[0]);//errorMsg[0]: out of range
						continue;
					}
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg[1]);		//errorMsg[1]: not a digit
				continue;
			}
			
			break;
		}
		
	}
	public static void test(int index) {
		if (index == 0) {							//test of method[0]: nextInt(low, high)
			System.out.println("input low");
			int low = input.nextInt();
			System.out.println("input high");
			int high = input.nextInt();
			
			System.out.println("\nResult: nextInt("+low+", "+high+")");
			for (int i = 0; i < howManyTest; i++) {
				int a = nRand.nextInt(low,high);
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		else if (index == 1) {						//test of method[1]: nextChar()
			System.out.println("\nResult: nextChar()");
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextChar();
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		else if (index == 2) {						//test of method[2]: nextChar(from, to)
			System.out.println("input from");
			char from = input.next().charAt(0);
			System.out.println("input to");
			char to = input.next().charAt(0);
			
			System.out.println("\nResult: nextInt("+from+", "+to+")");
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextChar(from,to);
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		else if (index == 3) {						//test of method[3]: nextChar(from, i)
			System.out.println("input from");
			char from = input.next().charAt(0);
			System.out.println("input index");
			int i = input.nextInt();
			
			System.out.println("\nResult: nextInt("+from+", "+i+")");
			for (int y = 0; y < howManyTest; y++) {
				char a = nRand.nextChar(from,i);
				System.out.print(a + " ");
			}
			System.out.println();
		}
		
		else if (index == 4) {						//test of method[4]: nextSpecialChar()
			System.out.println("\nResult: nextSpecialChar()");
			for (int i = 0; i < howManyTest; i++) {
				char a = nRand.nextSpecialChar();
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
