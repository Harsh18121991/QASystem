package com.apar.qa.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apar.qa.common.DatabaseSequenceGenerator;
import com.apar.qa.dao.MasterValuesDAO;
import com.apar.qa.dao.RequestMasterDAO;
import com.apar.qa.dao.TagMasterDAO;
import com.apar.qa.models.MasterValuesEntity;
import com.apar.qa.models.RequestMasterEntity;
import com.apar.qa.models.TagMasterEntity;

@Service
public class RequestService {
	
	@Autowired
	private RequestMasterDAO requestMasterDAO;
	
	@Autowired
	private MasterValuesDAO masterValuesDAO;
	
	@Autowired
	private TagMasterDAO tagMasterDAO;
	
	@Autowired
	private DatabaseSequenceGenerator db;
	
	private String prefix = "REQ";
	
	public void saveRequestBean() {
		RequestMasterEntity requestBean = new RequestMasterEntity();
		requestBean.setRequestId("REQ000003");
		requestBean.setRequestTitle("Document Review");
		requestBean.setShortDescription("short");
		requestBean.setDescription("long");
		MasterValuesEntity requestType = masterValuesDAO.findById("MAS000016");
		requestBean.setRequestType(requestType);
		MasterValuesEntity contentType = masterValuesDAO.findById("MAS000002");
		requestBean.setContentType(contentType);
		MasterValuesEntity status = masterValuesDAO.findById("MAS000008");
		requestBean.setStatus(status);
		requestBean.setCreatedBy("Ajay");
		requestBean.setCreatedAt(new Date());
		requestBean.setOwner("Harsh");
		TagMasterEntity tags = tagMasterDAO.findByTagId("TAG000001");
		requestBean.setTags(tags);
		MasterValuesEntity priority = masterValuesDAO.findById("MAS000004");
		requestBean.setPriority(priority);
		requestBean.setTargetClosureDate(new Date());
		requestBean.setExpectedReviewDate(new Date());
		requestMasterDAO.save(requestBean);
		System.out.println("Object Saved Successfully::::::");
	}
	
	public String addRequest(Map<String, Object> requestMap)
	{
		RequestMasterEntity requestMaster = new RequestMasterEntity();
		try {
			requestMaster.setProperties(requestMap);
			if(requestMap.get("requestType")!=null)
			{
				MasterValuesEntity requestType = masterValuesDAO.findById((String) requestMap.get("requestType"));
				requestMaster.setRequestType(requestType);
			}
			if(requestMap.get("contentType")!=null)
			{
				MasterValuesEntity contentType = masterValuesDAO.findById((String) requestMap.get("contentType"));
				requestMaster.setContentType(contentType);
			}
			if(requestMap.get("status")!=null)
			{
				MasterValuesEntity status = masterValuesDAO.findById((String) requestMap.get("status"));
				requestMaster.setStatus(status);
			}
			if(requestMap.get("tags")!=null)
			{
				TagMasterEntity tags = tagMasterDAO.findByTagId((String) requestMap.get("tags"));
				requestMaster.setTags(tags);
			}
			if(requestMap.get("priority")!=null)
			{
				MasterValuesEntity priority = masterValuesDAO.findById((String) requestMap.get("priority"));
				requestMaster.setPriority(priority);
			}
			try {
				if(requestMap.get("targetClosureDate")!=null)
				{
					Date targetClosureDate = new SimpleDateFormat("yyyy-mm-dd").parse((String) requestMap.get("targetClosureDate"));
					requestMaster.setTargetClosureDate(targetClosureDate);
				}
				if(requestMap.get("expectedReviewDate")!=null)
				{
					Date expectedReviewDate = new SimpleDateFormat("yyyy-mm-dd").parse((String) requestMap.get("expectedReviewDate"));
					requestMaster.setExpectedReviewDate(expectedReviewDate);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String generated_id = db.generateUniqueId(prefix, "");
			requestMaster.setRequestId(generated_id);
			requestMasterDAO.save(requestMaster);
			System.out.println("Object Saved Successfully::::::");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return requestMaster.getRequestId();
	}
	
	  /*@Override
	  public void run(String... args) throws Exception {


	      System.out.println("\n1.findAll()...");
	      for (RequestMasterEntity requestBean : requestMasterDAO.findAll()) {
	          System.out.println(requestBean);
	      }

	      System.out.println("\n2.findByRequestTitle(String requestTitle)");
	      for (RequestMasterEntity requestBean : requestMasterDAO.findByRequestTitle("harsh")) {
	          System.out.println(requestBean);
	      }

	      System.out.println("\n3.findByRequestId(String requestId)");
	      System.out.println(requestMasterDAO.findByRequestId("REQ000003"));

	      // For Stream, need @Transactional
	      System.out.println("\n4.findByRequestTitleReturnStream(@Param(\"requestTitle\") String requestTitle)..");
	      try (Stream<RequestMasterEntity> stream = requestMasterDAO.findByRequestTitleReturnStream("ajay")) {
	          stream.forEach(x -> System.out.println(x));
	      }

	      //System.out.println("....................");
	      //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	      //Date from = sdf.parse("2017-02-15");
	      //Date to = sdf.parse("2017-02-17");

	      //for (Customer customer : customerRepository.findByDateBetween(from, to)) {
	      //    System.out.println(customer);
	      //}

	      System.out.println("Done!");
	      //saveRequestBean();
	      //System.exit(0);
	  }	*/
}
