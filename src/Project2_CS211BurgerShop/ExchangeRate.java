package Project2_CS211BurgerShop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ExchangeRate {
	
	static double rate=1.0;
	public static double getRate(String currancyCode) throws Exception {
		try {				
			String firstPartURL = "https://v6.exchangerate-api.com/v6/";
			String key = "445bc40444e487e870ef354d";
			String thirdPartURL = "/latest/USD";
			String theURL = firstPartURL + key + thirdPartURL;
					
			URL url = new URL(theURL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			JSONParser jsonParser = new JSONParser();
			JSONObject myObject = (JSONObject)jsonParser.parse(br);
					
			//read the exchange rate here
			if (currancyCode.equals("USD")){
				rate =(long)((JSONObject)myObject.get("conversion_rates")).get(currancyCode);	
			}else {
				rate =(double)((JSONObject)myObject.get("conversion_rates")).get(currancyCode);		
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return rate;
	}

}
