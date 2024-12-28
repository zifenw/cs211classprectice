package Project2_CS211BurgerShop;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class Menu extends Burger211{
	String country;
	String franchise;
	double discountRate;
	String promotion;
	String currencyCode;
	String currencySymbol;
	int updatedBurgerKey=-1;
	String updatedTopping;
	
	static double exchangeRate;
	static double temperature; 
	static String[] localPrice=new String[4];
	
	Scanner input = new Scanner(System.in); 
  	  
	Menu(String country, String franchise){	
		    
		Locale locale = new Locale.Builder().setRegion(country).build();
		  
		currencyCode = Currency.getInstance(locale).getCurrencyCode();
		currencySymbol = Currency.getInstance(locale).getSymbol();
		  		  	  
		this.country=country;
		this.franchise=franchise;
		   
		try {
			// read exchange rate
			exchangeRate = ExchangeRate.getRate(currencyCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	          
	        
		    
		try {
			// read temperature
			temperature = WeatherAPP.getTemp(franchise);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	  
	 
	public void Promotion(Double discount, String promotion){
		this.promotion = promotion;
 		this.discountRate = discount;
	}
	  
	public void PromotionTooHot(int highTemp){  
		if(temperature >= highTemp) {
			discountRate = discountRate + 0.1;
		}
		  
	}  
	   
	@Override
	public void printMenu(){
		
		DecimalFormat df = new DecimalFormat("#,###,###.0");
		
		for (int i= 1 ; i<= getHowManyBurgers(); i++) {
			localPrice[i]= df.format(getPrice(i)*(1.0-discountRate));
			
			if (discountRate>0.0) {
				localPrice[i] +=" (regular:" + df.format(getPrice(i))+")";
			}	 
		}
		 
	
		// call API
		new MenuGUI(franchise,promotion,getName(1), currencySymbol+localPrice[1], getTopping(1),getName(2),currencySymbol+localPrice[2], getTopping(2),getName(3),currencySymbol+localPrice[3], getTopping(3), exchangeRate, temperature);
	
	  }	
	 
	
	@Override
	public double getPrice(int key) {
		return super.getPrice(key) * exchangeRate;
		
	}
	
	  
	@Override
	public String getTopping(int key) {		
		if(key == updatedBurgerKey) {
			return updatedTopping;
		}else {
			return super.getTopping(key);
		}
	}
	  
	  
	public void updateTopping(int key, String topping) {
		updatedBurgerKey = key;
		updatedTopping=topping;
	}	
	  
}
