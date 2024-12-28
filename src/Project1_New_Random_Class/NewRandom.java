/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
1/9/2024
In this assignment, I create NewRamdom class to extends the Random class, which let us have more method to use.
I used the calling method, Inheritance, overloading,type casting, while-loop, and type boolean.
*/
package Project1_New_Random_Class;
import java.util.*;
public class NewRandom extends Random {
	public char result;
	// first method nextInt(int low, int high): overload the nextInt() 
	//Returns a random number which is an integer value between the range of ‘low’ to ‘high’.
	public int nextInt(int low, int high) {
		return nextInt(high - low +1) + low;
	}
	
	//second method nextChar(): Returns a lower-case character.
	public char nextChar() {
		return (char)(nextInt('a','z'));
	}
	
	//third method nextChar(char from, char to): overload the nextChar()
	//Returns an lower-case letter between the range of ‘from’ to ‘to’.
	public char nextChar(char from, char to) {
		if (from < to) {                        //'c' < 'x'  range['c','z']
			return(char)(nextInt(from, to));
		}else if(from > to) {                   //'x' > 'c'  range['a','c']&&['x','z']
			do {
				result = (char)(nextInt('a','z'));
			}while(result > to && result < from);
			return result;
		}else {                                 //from == to
			return from;
		}
	}
	
	// fourth method nextChar(char from, int i): overload the nextChar()
	// Returns an lower-case letter between the range of ‘from’ to ‘from+i’
	public char nextChar(char from, int i) {
		int to, toTheLeft = from - 'a', toTheRight = 'z' - from;
		if(i < 0){       
			if(toTheLeft >= -i){          
				to = from + i;                  //(c,-2)==(a,c)  c-a=2  2=2 pass
		  	}else{
		  		to = 'z' - (-i - toTheLeft - 1);//(c,-3)==(z,c)  c-a=2  3-2-1
		  	}
			return (char)nextChar((char)to,from);      
		}else if(i > 0){
			if(toTheRight >= i){          
				to = from + i;                  //(x,2)==(x,z)  z-x=2  2=2 pass
		  	}else{
		  		to = 'a' + (i - toTheRight - 1);//(x,3)==(x,a)  z-x=2  3-2-1
		  	}
			return (char)nextChar(from,(char)to);
		  
		}else {
			return from;
		}
		  
	}
	// Another thought:
		/*
		if(i < 0) {
			if((int)from - 'a' >= - i) {   //(c,-2)  c-a=2  2=2 pass
				return(char)((int)from - nextInt(- i + 1));   // |i|=range-1
			}else {
				do {                            //(c,-3)  c
					result = (char)nextInt('z', 'a');
				}while(result > (int)from && result < 'z' + ((int)from - 'a'+ i + 1));
				return result;
			}
		}else if(i > 0) {
			if('z' - (int)from >=  i) {
				return(char)(nextInt(i + 1) + (int)from);
			}else {
				do {                            
					result = (char)nextInt('z', 'a'); //x, 3
				}while(result < (int)from && result > 'a' + (i - ('z' -(int)from) - 1));
				return result;
			}
				
		}else {   //i=0
			return from;
		}
	}*/
	
	// fifth method nextSpecialChar(): Returns a special character
	public char nextSpecialChar() {
		do {
			result = (char)nextInt('!', '~'); //'!'is the first one and '~' is the last one
		}while (Character.isLetterOrDigit((char)result));
		return result;
	}
	// Another thought:
	/* public char nextSpecialChar() {
	   String specialCharacters = "!@#$%^&*()-_+=<>?";
	   Random random = new Random();
       int randomIndex = random.nextInt(specialCharacters.length());
	   return specialCharacters.charAt(randomIndex);
    } 
	*/

}
