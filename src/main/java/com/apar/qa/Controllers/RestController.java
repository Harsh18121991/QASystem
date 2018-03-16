package com.apar.qa.Controllers;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/ajay/", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {
	
	
	@RequestMapping(value = "/students/{studentId}/courses", method = RequestMethod.GET)
	@ResponseBody
	public String retrieveCoursesForStudent(@PathVariable String studentId) {
		System.out.println("Student Id: "+studentId);
		return "{\"Name\": \"Ajay Jain\"}";
	}
	
}