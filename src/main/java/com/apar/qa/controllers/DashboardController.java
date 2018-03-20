package com.apar.qa.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apar.qa.beans.RequestMasterBean;


@Controller
public class DashboardController {
    /*
	@Autowired
	RequestService requestService;
    */		
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		ArrayList<RequestMasterBean> theList = new ArrayList<>();
		for (int i = 1;i<=3;++i){
			RequestMasterBean bean = new RequestMasterBean();
			bean.setRequestId("REQ12345");
			bean.setShortDescription("This is a Sample Request");
			bean.setDescription("Jane");
			bean.setContentType("LINK");
			bean.setCreatedBy("1/01/2016");
			theList.add(bean);
		}
		
		model.addAttribute("allRequests", theList);
		model.addAttribute("request",new RequestMasterBean());
		return "Dashboard/index";
	}

	/*
	
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<RequestBean> list = requestService.getAllRequests();
		model.addAttribute("allRequests", list);
		return "Dashboard/index";
	}	

	*/
}
