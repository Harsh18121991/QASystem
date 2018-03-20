package com.apar.qa.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.apar.qa.beans.RequestMasterBean;

@Controller
public class RequestController {
	
	private Log LOG = LogFactory.getLog(RequestController.class);

	@GetMapping("/details")
	public String Details( @RequestParam(value="requestId", required=false, defaultValue="") String requestId,Model model) {
		return "Request/details";
	}

	@GetMapping("/new")
	public String newrequestForm( Model model) {
		model.addAttribute("request", new RequestMasterBean());
		return "Request/new";
	}

	@PostMapping("/new")
	public String Create(@ModelAttribute RequestMasterBean request,@RequestParam("file") MultipartFile imageFile) {
		LOG.info("creating request");
		return "redirect:/dashboard";
	}
	
	@GetMapping("/list")
	public String listrequestForm( Model model) {
		model.addAttribute("allRequests", getBeanDetails());
		model.addAttribute("request",new RequestMasterBean());
		return "Request/listing";
	}
	
	@GetMapping("/view")
	public String viewRequestForm( Model model) {
		model.addAttribute("request", getBeanDetails().get(0));
		return "Request/view";
	}
	
	@GetMapping("/reply")
	public String replyRequestForm( Model model) {
		model.addAttribute("request", new RequestMasterBean());
		return "Request/reply";
	}

	@GetMapping("/status")
	public String statusRequestForm( Model model) {
		model.addAttribute("request", getBeanDetails().get(0));
		return "Request/status";
	}
	
	public ArrayList<RequestMasterBean> getBeanDetails()
	{
		ArrayList<RequestMasterBean> theList = new ArrayList<>();
		for (int i = 1;i<=3;++i){
			RequestMasterBean bean = new RequestMasterBean();
			bean.setRequestId("REQ12345");
			bean.setRequestTitle("Link Request");
			bean.setShortDescription("This is a Sample Request");
			bean.setDescription("Jane");
			bean.setContentType("LINK");
			bean.setCreatedBy("1/01/2016");
			bean.setStatus("InProgress");
			theList.add(bean);
		}
		return theList;
	}
	

}
