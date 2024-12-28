package Project1_Implementing_Efficient_Program;

public class BusFare {
	//Base rate variable, 'protected' access modifier allows access within the same package and by subclasses
	protected double baseRate;
	//Constructor to set the base rate
	public BusFare(double baseRate) {
		this.baseRate = baseRate;
	}
	//Method to get the base rate
	protected double getBaseRate() {
		return baseRate;
	}
}
