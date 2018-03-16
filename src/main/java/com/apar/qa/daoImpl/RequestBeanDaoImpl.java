package com.apar.qa.daoImpl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.apar.qa.models.RequestBean;

@Transactional
public class RequestBeanDaoImpl {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	public void saveRequestBean() {
		RequestBean requestBean = new RequestBean();
		requestBean.setRequestId("REQ000001");
		requestBean.setRequestTitle("Document Review");
		requestBean.setShortDescription("short");
		requestBean.setDescription("long");
		requestBean.setRequestType("MAS000016");
		requestBean.setContentType("MAS000002");
		requestBean.setStatus("MAS000008");
		requestBean.setCreatedBy("Ajay");
		requestBean.setCreatedAt(new Date());
		requestBean.setOwner("Harsh");
		requestBean.setTags("TAG000001");
		requestBean.setPriority("MAS000004");
		requestBean.setTargetClosureDate(new Date());
		requestBean.setExpectedReviewDate(new Date());
		
		hibernateTemplate.save(requestBean);
	}
	
	/*@Transactional(readOnly = true)
	  @Override
	  public void run(String... args) throws Exception {


	      System.out.println("\n1.findAll()...");
	      for (RequestBean requestBean : requestRepository.findAll()) {
	          System.out.println(requestBean);
	      }

	      System.out.println("\n2.findByRequestTitle(String requestTitle)");
	      for (RequestBean requestBean : requestRepository.findByRequestTitle("harsh")) {
	          System.out.println(requestBean);
	      }

	      System.out.println("\n3.findByRequestId(String requestId)");
	      for (RequestBean requestBean : requestRepository.findByRequestId("12345")) {
	          System.out.println(requestBean);
	      }

	      // For Stream, need @Transactional
	      System.out.println("\n4.findByRequestTitleReturnStream(@Param(\"requestTitle\") String requestTitle)..");
	      try (Stream<RequestBean> stream = requestRepository.findByRequestTitleReturnStream("ajay")) {
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

	      exit(0);
	  }*/
	
}
