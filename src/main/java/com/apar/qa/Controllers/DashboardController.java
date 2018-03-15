package com.apar.qa.Controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apar.qa.models.RequestBean;


@Controller
public class DashboardController {
    /*
	@Autowired
	RequestService requestService;
    */		
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		ArrayList<RequestBean> theList = new ArrayList<>();
		for (int i = 1;i<=3;++i){
			RequestBean bean = new RequestBean();
			bean.setRequestId("12345");
			bean.setShortDescription("This is a Sample Request");
			bean.setDescription("Jane");
			bean.setContentType("LINK");
			bean.setCreatedBy("1/01/2016");
			theList.add(bean);
		}
		
		model.addAttribute("allRequests", theList);
		model.addAttribute("request",new RequestBean());
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
