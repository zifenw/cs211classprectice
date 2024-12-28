package Project4_generics;

public class Efficient_Age2 <T>{
	private Object age;
	
	public T getAge() {
		return (T)age;
	}

	public void setAge(T age) {
		this.age = age;
	}

}
