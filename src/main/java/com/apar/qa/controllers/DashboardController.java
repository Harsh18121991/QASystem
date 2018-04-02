package com.apar.qa.controllers;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apar.qa.beans.RequestMasterBean;
import com.apar.qa.rest.ServiceClient;


@Controller
public class DashboardController {
    /*
	@Autowired
	RequestService requestService;
    */		
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		String requestService = "listAllRequests";
		JSONObject jsonObject = new JSONObject() ;
		String value = ServiceClient.sendRequestData(jsonObject,requestService);
		model.addAttribute("allRequests",RequestController.convertJsonToList(value));
		return "Dashboard/index";
	}
}
