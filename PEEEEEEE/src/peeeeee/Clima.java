
package peeeeee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class Clima {
	public static String getHTML(String urlToRead) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
		   result.append(line);
		}
		rd.close();
		return result.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
                    System.out.println("ingrese la ciudad: ");
                    Scanner lea = new Scanner(System.in);
                    String a =lea.next();
                    
			String respuesta = getHTML("http://api.openweathermap.org/data/2.5/weather?q="+a+"&appid=86587174cc0cd70fe4cbb7f3f2753419");
			//System.out.println(respuesta);
			JSONObject obj = new JSONObject(respuesta);
                        
			double temp = obj.getJSONObject("main").getDouble("temp") - 273.15;
                        double pressure = obj.getJSONObject("main").getDouble("pressure");
                        double tempMax = obj.getJSONObject("main").getDouble("temp_max")-273.15;
                        double tempMin = obj.getJSONObject("main").getDouble("temp_min")-273.15;
                        double Humedad = obj.getJSONObject("main").getDouble("humidity");
                        double latitud = obj.getJSONObject("coord").getDouble("lat");
                        double longitud = obj.getJSONObject("coord").getDouble("lon");
			System.out.println("La temperatura en San Pedro Sula es: "+temp+" Celsius");
                        System.out.println("La presion en San Pedro Sula es: "+pressure);
                        System.out.println("La latitud en San Pedro Sula es: "+latitud);
                        System.out.println("La longitud en San Pedro Sula es: "+longitud);
                        System.out.println("La temp Maxima en San Pedro Sula es: "+tempMax);
                        System.out.println("La temp Min en San Pedro Sula es: "+tempMin);
                        System.out.println("La Humedad en San Pedro Sula es: "+Humedad);
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}