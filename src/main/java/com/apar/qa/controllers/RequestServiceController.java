package com.apar.qa.controllers;


import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apar.qa.service.RequestService;

@RestController
@RequestMapping(value = "/requests")
public class RequestServiceController {
	
	@Autowired
	private RequestService requestService;
	
	@RequestMapping(value = "/students/{jsonObject}/courses", method = RequestMethod.GET)
	public String retrieveCoursesForStudent(@PathVariable JSONObject jsonObject) {
		System.out.println("Student Id: "+jsonObject);
		System.out.println("value of ajay:: "+jsonObject.getString("ajay"));
		return "{\"Name\": \"Ajay Jain\"}";
	}
	
	@RequestMapping(value = "/addRequests", method = RequestMethod.POST)
	public String addUserRequest(@RequestBody Map<String, Object> requestMap) {
		String requestId = null;
		requestId = requestService.addRequest(requestMap);
		return requestId;
	}
	
}