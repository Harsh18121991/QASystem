package com.apar.qa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apar.qa.daoImpl.RequestBeanDaoImpl;

@Controller
@RequestMapping(value = "/ajay/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {
	
	@Autowired
	private RequestBeanDaoImpl requestBeanDaoImpl;
	
	
	@RequestMapping(value = "/students/{studentId}/courses", method = RequestMethod.GET)
	@ResponseBody
	public String retrieveCoursesForStudent(@PathVariable String studentId) {
		System.out.println("Student Id: "+studentId);
		return "{\"Name\": \"Ajay Jain\"}";
	}
	
	@RequestMapping(value = "/requests/{studentId}", method = RequestMethod.GET)
	@ResponseBody
	public String addUserRequest(@PathVariable String studentId) {
		System.out.println("Student Id: "+studentId);
		requestBeanDaoImpl.saveRequestBean();
		return "{\"Name\": \"Ajay Jain\"}";
	}
	
}