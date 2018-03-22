package com.apar.qa.delegateImpl;

import java.io.OutputStream;
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
	        uc.setDoOutput(true);
	        uc.setRequestMethod("POST");
	        uc.setRequestProperty("Content-Type", "application/json");
	        //jsonObject.append("qty", "100");
	        //jsonObject.append("name", "ipad 4");
	        //String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
	        OutputStream os = uc.getOutputStream();
			os.write(jsonObject.toString().getBytes());
			os.flush();
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
