package com.apar.qa.daoImpl;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apar.qa.QAApplication;
import com.apar.qa.dao.RequestMasterDAO;
import com.apar.qa.models.RequestMasterEntity;

@SpringBootApplication
public class RequestBeanDaoImpl implements CommandLineRunner{
	
	@Autowired
	private RequestMasterDAO requestRepository;
	
	public void saveRequestBean() {
		RequestMasterEntity requestBean = new RequestMasterEntity();
		requestBean.setRequestId("REQ000002");
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
		System.out.println("Before Saving Object:::::: "+requestRepository);
		requestRepository.save(requestBean);
		System.out.println("After Saving Object::::::");
	}
	
	  @Override
	  public void run(String... args) throws Exception {


	      System.out.println("\n1.findAll()...");
	      for (RequestMasterEntity requestBean : requestRepository.findAll()) {
	          System.out.println(requestBean);
	      }

	      System.out.println("\n2.findByRequestTitle(String requestTitle)");
	      for (RequestMasterEntity requestBean : requestRepository.findByRequestTitle("harsh")) {
	          System.out.println(requestBean);
	      }

	      System.out.println("\n3.findByRequestId(String requestId)");
	      for (RequestMasterEntity requestBean : requestRepository.findByRequestId("12345")) {
	          System.out.println(requestBean);
	      }

	      // For Stream, need @Transactional
	      System.out.println("\n4.findByRequestTitleReturnStream(@Param(\"requestTitle\") String requestTitle)..");
	      try (Stream<RequestMasterEntity> stream = requestRepository.findByRequestTitleReturnStream("ajay")) {
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
	  }
	  
	  public static void main(String[] args) {
			//SpringApplication.run(QAApplication.class, args);
		}
	
}
