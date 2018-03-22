package com.apar.qa.delegateImpl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.apar.qa.beans.RequestMasterBean;
import com.apar.qa.controllers.RequestController;
import com.apar.qa.delegate.RequestDelegate;
import org.json.JSONException;
import org.json.JSONObject;
@Controller
public class SubmitRequestDelegateImpl implements RequestDelegate{
		//@PostMapping("/submitRequest")
		public String submitRequestData(HttpServletRequest httpRequest,HttpServletResponse httpResponse,Model model){
			Map<String,Object> requestData 	= new HashMap<String,Object>();
			System.out.println("welcome to handle request");
			RequestController requestController = new RequestController();
			model.addAttribute("allRequests",requestController.getBeanDetails());
			model.addAttribute("request",new RequestMasterBean());
			requestData.put("requestTitle",httpRequest.getParameter("requestTitle"));
			requestData.put("shortDescription",httpRequest.getParameter("shortDescription"));
			requestData.put("requestType",httpRequest.getParameter("requestType"));
			requestData.put("priority",httpRequest.getParameter("priority"));
			requestData.put("targetDate",httpRequest.getParameter("targetDate"));
			requestData.put("expectedDate",httpRequest.getParameter("expectedDate"));
			requestData.put("contentType",httpRequest.getParameter("tags"));
			requestData.put("contentType",httpRequest.getParameter("owner"));
			requestData.put("description",httpRequest.getParameter("description"));
			requestData.put("contentType",httpRequest.getParameter("contentType"));
			requestData.put("contentType",httpRequest.getParameter("text"));
			requestData.put("contentType",httpRequest.getParameter("link"));
			requestData.put("contentType",httpRequest.getParameter("file"));
			JSONObject jsonObject	=	 new JSONObject(requestData);
			SendServiceRequest.sendRequestData(jsonObject);
			return "Request/listing" ; 
		}
		/*public String submitRequestData(HttpServletRequest httpRequest,HttpServletResponse httpResponse,Model model){
			Map<String,Object> requestData 	= new HashMap<String,Object>();
			System.out.println("welcome to handle request");
			 String request = (String) httpRequest.getParameter("requestTitle");
			System.out.println("this is the requst"+request);
			try {
				JSONObject json = new JSONObject(request);
				System.out.println("jrequestData::: "+json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject jsonObject	=	 new JSONObject(requestData);
			SendServiceRequest.sendRequestData(jsonObject);
			return "Request/listing" ; 
		}*/
}

