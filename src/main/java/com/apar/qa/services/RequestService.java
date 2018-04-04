package com.apar.qa.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apar.qa.common.DatabaseSequenceGenerator;
import com.apar.qa.dao.MasterValuesDAO;
import com.apar.qa.dao.RequestMasterDAO;
import com.apar.qa.models.MasterValuesEntity;
import com.apar.qa.models.RequestMasterEntity;

@Service
public class RequestService {
	
	@Autowired
	private RequestMasterDAO requestMasterDAO;
	
	@Autowired
	private MasterValuesDAO masterValuesDAO;
	
	@Autowired
	private TagService tagService;
	
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
		requestBean.setTags("apar");
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
				//MasterValuesEntity requestType = masterValuesDAO.findById((String) requestMap.get("requestType"));
				MasterValuesEntity requestType = masterValuesDAO.findById("MAS000016");
				requestMaster.setRequestType(requestType);
			}
			if(requestMap.get("contentType")!=null)
			{
				//MasterValuesEntity contentType = masterValuesDAO.findById((String) requestMap.get("contentType"));
				MasterValuesEntity contentType = masterValuesDAO.findById("MAS000002");
				requestMaster.setContentType(contentType);
			}
			//if(requestMap.get("status")!=null)
			//{
				//MasterValuesEntity status = masterValuesDAO.findById((String) requestMap.get("status"));
				MasterValuesEntity status = masterValuesDAO.findById("MAS000008");
				requestMaster.setStatus(status);
			//}
			if(requestMap.get("tags")!=null && !requestMap.get("tags").equals(""))
			{
				String tagIds = tagService.getAllTagIdsByName((String) requestMap.get("tags"));
				requestMaster.setTags(tagIds);
			}
			if(requestMap.get("priority")!=null)
			{
				//MasterValuesEntity priority = masterValuesDAO.findById((String) requestMap.get("priority"));
				MasterValuesEntity priority = masterValuesDAO.findById("MAS000004");
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
	
	public List<RequestMasterEntity> getAllRequest()
	{
		List<RequestMasterEntity> listRequest = (List<RequestMasterEntity>) requestMasterDAO.findAll();
		return listRequest;
	}
	
	public List<RequestMasterEntity> searchAllRequest(Map<String, String> requestMap)
	{
		
		List<RequestMasterEntity> listRequest = null;
		try {
			String fromDate = requestMap.get("fromDate");
			String toDate	= requestMap.get("toDate");
			if(fromDate==null || fromDate.equals(""))
				fromDate = "01/01/2000";
			if(toDate==null || toDate.equals(""))
				toDate	 = "31/12/2099";
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			listRequest = (List<RequestMasterEntity>) requestMasterDAO.findBySearchFilter(requestMap.get("requestId"), 
					requestMap.get("requestName"), requestMap.get("priority"), requestMap.get("status"), requestMap.get("tags"), 
					sdf.parse(fromDate), sdf.parse(toDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRequest;
	}
	
	
}