package com.apar.qa.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

@ConfigurationPropertiesBinding
public class ServiceClient {

	public static String sendRequestData(JSONObject jsonObject, String requestService) {
		StringBuffer sb = new StringBuffer();
		try{
		 	String requestUrl  = "http://localhost:8080/requests/"+requestService;
		 			//+ "/{"+ jsonObject+"}";
		 	System.out.println("Generated url:: "+requestUrl);
	        URL url = new URL(requestUrl);
	        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
	        uc.setDoOutput(true);
	        uc.setRequestMethod("POST");
	        uc.setRequestProperty("Content-Type", "application/json");
	        OutputStream os = uc.getOutputStream();
			os.write(jsonObject.toString().getBytes());
			os.flush();
			System.out.println("Service Executed");
			BufferedReader br = new BufferedReader(new InputStreamReader(
			        (uc.getInputStream()))); // Getting the response from the webservice

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				sb.append(output);
			    System.out.println(output); // Instead of this, you could append all your response to a StringBuffer and use `toString()` to get the entire JSON response as a String.
			    // This string json response can be parsed using any json library. Eg. GSON from Google.
			}
	        uc.disconnect();
	 }
	        catch(Exception ex){
	        	System.out.println(ex.getMessage());
	        	}
		return sb.toString();
	}
}
