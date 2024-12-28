package Project1_Implementing_Efficient_Program;

public class Senior extends BusFare{
	public Senior(double baseRate) {
		super(baseRate);
	}
	public void print(){
		System.out.printf("Fare: %f", getBaseRate());
	}
	protected double getBaseRate() {
		return super.getBaseRate();
	}
}
