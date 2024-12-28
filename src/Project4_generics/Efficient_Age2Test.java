package Project4_generics;

/*Zifeng Wang
202515718
zifeng.wang@bellevuecollege.edu
3/5/2024

Why this code is better:
The generic approach uses a single class Age<T> to handle different data types for age.
It avoids redundant class definitions for each data type, reducing code duplication.
With generics, the code is more concise and easier to maintain.
It allows for flexible usage of different data types without additional overhead.
The generic class Age<T> promotes code reusability and modularity.
Changes to the Age class need to be made in only one place, enhancing maintainability.
The generic solution promotes better scalability for handling additional data types in the future.
Overall, the generic approach leads to more efficient and cleaner code compared to the previous redundant implementation.
*/

public class Efficient_Age2Test {

	public static void main(String[] args) {
		Efficient_Age2 age = new Efficient_Age2();
		
		System.out.println("Your age is");
		
		age.setAge("Eighteen");
		System.out.println(age.getAge());
		
		age.setAge(18);
		System.out.println(age.getAge());
		
		age.setAge(18.0);
		System.out.println(age.getAge());

	}

}
