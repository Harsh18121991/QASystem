package com.apar.qa.delegateImpl;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SendServiceRequest {

	public static void sendRequestData(JSONObject jsonObject) {
		try{
		 	String requestUrl  = "http://localhost:8080/requests/addRequests";
		 			//+ "/{"+ jsonObject+"}";
		 	System.out.println("Generated url1::"+requestUrl);
	        URL url = new URL(requestUrl);
	        HttpURLConnection uc = (HttpURLConnection)url.openConnection();
	        uc.setRequestMethod("POST");
	        System.out.println(uc.getResponseMessage());
	        //System.out.println(uc.);
	        uc.disconnect();
	 }
	        catch(Exception ex){
	        	System.out.println(ex.getMessage());
	        	}
}
	public static void main(String args[]) {
		JSONObject jsonObject	=	 new JSONObject();
		sendRequestData(jsonObject);
	}
}
