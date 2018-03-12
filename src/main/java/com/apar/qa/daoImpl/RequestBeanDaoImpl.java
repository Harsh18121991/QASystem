package com.apar.qa.daoImpl;

import java.util.Date;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.apar.qa.models.RequestBean;
import com.apar.qa.dao.RequestBeanDao;

@Transactional
public class RequestBeanDaoImpl implements RequestBeanDao{
	
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
	
}
