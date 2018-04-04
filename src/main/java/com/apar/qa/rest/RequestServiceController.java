package com.apar.qa.rest;


import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apar.qa.models.RequestMasterEntity;
import com.apar.qa.services.RequestService;

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
		System.out.println("requestMap:::::: "+requestMap);
		requestId = requestService.addRequest(requestMap);
		return requestId;
	}
	
	@RequestMapping(value = "/listAllRequests", method = RequestMethod.POST)
	public List<RequestMasterEntity> listUserRequest() {
		List<RequestMasterEntity> listRequests = requestService.getAllRequest();
		return listRequests;
	}
	
	@RequestMapping(value = "/searchAllRequests", method = RequestMethod.POST)
	public List<RequestMasterEntity> searchUserRequest(@RequestBody Map<String, String> requestMap) {
		System.out.println("requestMap:::::: "+requestMap);
		List<RequestMasterEntity> listRequests = requestService.searchAllRequest(requestMap);
		return listRequests;
	}
	
}