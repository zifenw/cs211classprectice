package Project1_Implementing_Efficient_Program;

public class Adult extends BusFare{
	public Adult(double baseRate) {
		super(baseRate);
	}
	public void print(){
		System.out.printf("Fare: %f", getBaseRate());
	}
	protected double getBaseRate() {
		return super.getBaseRate();
	}
}
