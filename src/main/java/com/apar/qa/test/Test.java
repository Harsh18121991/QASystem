package com.apar.qa.test;

import org.json.JSONObject;

import com.apar.qa.rest.ServiceClient;

public class Test {
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
	
	public static void main(String args[]) {
		JSONObject jsonObject	=	 new JSONObject();
		jsonObject.put("requestId", "");
		jsonObject.put("requestTitle", "");
		jsonObject.put("priority", "");
		jsonObject.put("status", "");
		jsonObject.put("fromDate", "");
		jsonObject.put("toDate", "");
		jsonObject.put("tags", "");
		String response = ServiceClient.sendRequestData(jsonObject,"searchAllRequests");
		System.out.println("Generated Response::: "+response);
	}
	
	

}
