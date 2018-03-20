package com.apar.qa.controllers.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.apar.qa.beans.RequestMasterBean;
import com.apar.qa.controllers.delegate.RequestDelegate;

public class ActionControllerImpl implements RequestDelegate{
		//@PostMapping("/submitRequest")
		public String submitRequestData(HttpServletRequest httpRequest,Model model){
			System.out.println("welcome to handle request");
			model.addAttribute("request", new RequestMasterBean());
			String requestTitle = httpRequest.getParameter("requestTitle");
			System.out.println("this is request title  "+requestTitle);
			return "Request/listing" ; 
		}

}

