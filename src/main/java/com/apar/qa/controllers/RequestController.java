package com.apar.qa.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.apar.qa.beans.RequestMasterBean;
import com.apar.qa.rest.ServiceClient;
import com.apar.qa.services.MasterValueService;

@Controller
public class RequestController {
	
	@Autowired
	private MasterValueService masterValueService;
	
	private Log LOG = LogFactory.getLog(RequestController.class);

	@GetMapping("/details")
	public String Details( @RequestParam(value="requestId", required=false, defaultValue="") String requestId,Model model) {
		return "Request/details";
	}

	@GetMapping("/add")
	public String newrequestForm( Model model) {
		model.addAttribute("request", new RequestMasterBean());
		model.addAttribute("masterValues",masterValueService.getAllMasterValues());
		return "Request/add";
	}

	@PostMapping("/add")
	public String Create(@ModelAttribute RequestMasterBean request,@RequestParam("file") MultipartFile imageFile) {
		LOG.info("creating request");
		return "redirect:/dashboard";
	}
	
	@GetMapping("/list")
	public String listrequestForm( Model model) {
		String requestService = "listAllRequests";
		JSONObject jsonObject = new JSONObject() ;
		String value = ServiceClient.sendRequestData(jsonObject,requestService);
		model.addAttribute("allRequests",convertJsonToList(value));
		return "Request/listing";
	}
	
	@GetMapping("/view")
	public String viewRequestForm( HttpServletRequest httpRequest,Model model) {
		String requestId = httpRequest.getParameter("requestId");
		System.out.println("request id "+requestId);
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
	
	//this method converts string to list
	public static ArrayList<RequestMasterBean> convertJsonToList(String jsonString)
	{
		ArrayList<RequestMasterBean> requestList = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(jsonString);
		for (int i = 0;i<jsonArray.length();i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			System.out.println("json object is"+jsonObject);
			RequestMasterBean bean = new RequestMasterBean();
			bean.setRequestId(jsonObject.getString("requestId"));
			bean.setRequestTitle(jsonObject.getString("requestTitle"));
			bean.setShortDescription(jsonObject.getString("shortDescription"));
			bean.setDescription(jsonObject.getString("description"));
			bean.setTags(jsonObject.getString("tags"));
			requestList.add(bean);
		}
		return requestList;
	}
	//this method hits service to save data for create request 
	@PostMapping("/submitRequest")
	public String submitRequestData(HttpServletRequest httpRequest,HttpServletResponse httpResponse,Model model){
		Map<String,Object> requestData 	= new HashMap<String,Object>();
		System.out.println("welcome to handle request");
		requestData.put("requestTitle",httpRequest.getParameter("requestTitle"));
		requestData.put("shortDescription",httpRequest.getParameter("shortDescription"));
		requestData.put("requestType",httpRequest.getParameter("requestType"));
		requestData.put("priority",httpRequest.getParameter("priority"));
		requestData.put("targetClosureDate",httpRequest.getParameter("targetDate"));
		requestData.put("expectedReviewDate",httpRequest.getParameter("expectedDate"));
		requestData.put("tags",httpRequest.getParameter("tags"));
		requestData.put("owner",httpRequest.getParameter("owner"));
		requestData.put("description",httpRequest.getParameter("description"));
		requestData.put("contentType",httpRequest.getParameter("contentType"));
		requestData.put("text",httpRequest.getParameter("text"));
		requestData.put("link",httpRequest.getParameter("link"));
		requestData.put("file",httpRequest.getParameter("file"));
		JSONObject jsonObject	=	 new JSONObject(requestData);
		ServiceClient.sendRequestData(jsonObject,"addRequests");
		return "redirect:/list"; 
	}
	//for search list
	@PostMapping("/searchRequest")
	public String searchRequestData(HttpServletRequest httpRequest,HttpServletResponse httpResponse){
		Map<String,Object> requestData 	= new HashMap<String,Object>();
		System.out.println("welcome to handle request search request");
		requestData.put("requestId",httpRequest.getParameter("requestId"));
		requestData.put("requestTitle",httpRequest.getParameter("requestTitle"));
		requestData.put("priority",httpRequest.getParameter("priority"));
		requestData.put("status",httpRequest.getParameter("status"));
		requestData.put("fromDate",httpRequest.getParameter("fromDate"));
		requestData.put("toDate",httpRequest.getParameter("toDate"));
		requestData.put("tags",httpRequest.getParameter("tags"));
		System.out.println("json data"+requestData);
		//JSONObject jsonObject	=	 new JSONObject(requestData);
		//ServiceClient.sendRequestData(jsonObject,"addRequests");
		return "redirect:/list"; 
	}
}
