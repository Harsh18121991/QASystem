package com.apar.qa.controllers.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

public interface RequestDelegate {

	
	@PostMapping("/submitRequest")
	public String submitRequestData(HttpServletRequest httpRequest,Model model);
		
		
	}

