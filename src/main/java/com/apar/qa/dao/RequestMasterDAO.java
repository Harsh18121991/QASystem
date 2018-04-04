package com.apar.qa.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apar.qa.models.RequestMasterEntity;


public interface RequestMasterDAO extends CrudRepository<RequestMasterEntity, Serializable> {

    List<RequestMasterEntity> findByRequestTitle(String requestTitle);

    //@Query("select c from RequestMasterEntity c where c.requestTitle = :requestTitle")
   // Stream<RequestMasterEntity> findByRequestTitleReturnStream(@Param("requestTitle") String requestTitle);

    RequestMasterEntity findByRequestId(String requestId);
    
    @Query("select r.requestId, r.requestTitle, r.shortDescription, r.tags from RequestMasterEntity r where r.requestId like %:requestId% and r.requestTitle like %:requestName%"
    		+ " and r.priority.value like %:priority% and r.status.value like %:status% and r.tags like %:tags% and r.createdAt between :fromDate and :toDate")
    List<RequestMasterEntity> findBySearchFilter(@Param("requestId") String requestId, @Param("requestName") String requestName, 
    		@Param("priority") String priority, @Param("status") String status, @Param("tags") String tags,
    		@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
    
    @Query("select r.requestId, r.requestTitle, r.shortDescription, r.tags from RequestMasterEntity r")
    List<RequestMasterEntity> findAll();

    //@Query("select c from Customer c")
    //Stream<Customer> findAllAndStream();

    //List<Customer> findByDateBetween(Date from, Date to);

}
