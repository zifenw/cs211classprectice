package HashMap;

public class basicInfo {
	// define some private variables
	private String productType;
	private int purchNumber;
	private double eachPrice;
	
	public basicInfo(String name, int number, double eachPrice) {
		this.productType = name;
		this.purchNumber = number;
		this.eachPrice = eachPrice;
		
	}
	
	public String getProductType(){
		return this.productType;
	}
	public int getPurchNumber(){
		return this.purchNumber;
	}
	public double getEachPrice(){
		return this.eachPrice;
	}
	
	@Override
	public String toString() {
		return "Product Type: " + productType + ", Purch Number: " + purchNumber + ", EachPrice: " + eachPrice + "\n";
	}
}
