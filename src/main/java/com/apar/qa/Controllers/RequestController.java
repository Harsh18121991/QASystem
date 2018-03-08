package com.apar.qa.Controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.apar.qa.models.RequestBean;

@Controller
public class RequestController {
	
	private Log LOG = LogFactory.getLog(RequestController.class);

	@GetMapping("/details")
	public String Details( @RequestParam(value="requestId", required=false, defaultValue="") String requestId,Model model) {
		//get the request from the REST service
	    /*
		RequestBean request = service.GetById(id);    	
		//plug request into the Model
		model.addAttribute("request", request);
	    */
		return "Request/details";
	}


	@GetMapping("/new")
	public String newrequestForm( Model model) {
		model.addAttribute("request", new RequestBean());
		return "Request/new";
	}

	@PostMapping("/new")
	public String Create(@ModelAttribute RequestBean request,@RequestParam("file") MultipartFile imageFile) {
		LOG.info("creating request");
		return "redirect:/dashboard";
	}
}
