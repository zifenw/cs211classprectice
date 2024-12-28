package Project2_CS211BurgerShop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class WeatherAPP {
	static double cityTemp = 0.0;
	public static double getTemp (String cityName) throws Exception {
		try {				
		//Create a URL instance
			String firstPartURL = "https://api.openweathermap.org/data/2.5/weather?q=";
			String secondPartURL ="&appid=b0a84a966b9cb32e5c603a3307aedb79"; 
			String theURL = firstPartURL + cityName + secondPartURL;
					
			URL url = new URL(theURL); 
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			JSONParser jsonParser = new JSONParser();
			JSONObject myObject = (JSONObject)jsonParser.parse(br);
								
			//Temperature
			cityTemp = (double)((JSONObject) myObject.get("main")).get("temp");
			cityTemp = (cityTemp - 273.15)*9/5 + 32;
			
		}
		catch (Exception ex) {		
			ex.printStackTrace();		
		}
		return cityTemp;
	}	

}


