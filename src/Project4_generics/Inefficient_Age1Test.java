package Project4_generics;
/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
3/1/2024
inefficient explanation:
The code is too long and it creates three different things to store different versions of the same thing, 
just like three unnecessary trips to buy something. This approach wastes memory and increases the complexity of the code.
Each instance consumes memory to store its fields, even though only one field is being used at a time.


why the explanation is inefficient:
Not considering Polymorphis and modifying using genetics 
The code is inefficient because it redundantly defines three separate classes to store age data with different data types but no functional differences. 
This redundancy leads to unnecessary code duplication and maintenance difficulty. Using generics can solve this issue.
Generics allow you to define a generic class and specify the actual data type when needed,
avoiding the need for redundant class definitions. With this approach, you only need to define one generic class Age<T>, 
and specify the concrete type parameter where necessary, eliminating code redundancy and making the code more efficient and maintainable.
*/
public class Inefficient_Age1Test {

	public static void main(String[] args) {
		System.out.println("Your age is");
		
		Inefficient_Age1 age_String = new Inefficient_Age1();
		age_String.setAgeString("Eighteen");
		System.out.println(age_String.getAgeString());
		
		Inefficient_Age1 age_Int = new Inefficient_Age1();
		age_Int.setAgeInt(18);
		System.out.println(age_Int.getAgeInt());
		
		Inefficient_Age1 age_Double = new Inefficient_Age1();
		age_Double.setAgeDouble(18.0);
		System.out.println(age_Double.getAgeDouble());
	}

}
