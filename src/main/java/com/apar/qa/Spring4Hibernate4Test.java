package com.apar.qa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.apar.qa.configuration.AppConfig;
import com.apar.qa.dao.RequestBeanDao;

public class Spring4Hibernate4Test {
  public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
  	  ctx.register(AppConfig.class);
  	  ctx.refresh();
	  RequestBeanDao rdao = ctx.getBean(RequestBeanDao.class);
	  //rdao.saveRequestBean();
	  System.out.println("Done");
  }
} 