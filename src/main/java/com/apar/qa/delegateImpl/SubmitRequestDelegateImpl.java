package com.apar.qa.delegateImpl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.apar.qa.beans.RequestMasterBean;
import com.apar.qa.controllers.RequestController;
import com.apar.qa.delegate.RequestDelegate;

@Controller
public class SubmitRequestDelegateImpl implements RequestDelegate{
		//@PostMapping("/submitRequest")
		public String submitRequestData(HttpServletRequest httpRequest,HttpServletResponse httpResponse,Model model){
			Map<String,Object> requestData 	= new HashMap<String,Object>();
			System.out.println("welcome to handle request");
			model.addAttribute("request", new RequestMasterBean());
			String requestTitle = httpRequest.getParameter("requestTitle");
			RequestController requestController = new RequestController();
			model.addAttribute("allRequests",requestController.getBeanDetails());
			model.addAttribute("request",new RequestMasterBean());
			System.out.println("this is request title  "+requestTitle);
			return "Request/listing" ; 
		}
	//@PostMapping("/submitRequest")
	/*public String submitRequestData( Model model) {
		RequestController requestController = new RequestController();
		model.addAttribute("request", requestController.getBeanDetails().get(0));
		return "Request/status";
	}*/
}

