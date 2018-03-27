package com.apar.qa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.apar.qa.models.RequestMasterEntity;


public interface RequestMasterDAO extends CrudRepository<RequestMasterEntity, Serializable> {

    List<RequestMasterEntity> findByRequestTitle(String requestTitle);

    //@Query("select c from RequestMasterEntity c where c.requestTitle = :requestTitle")
   // Stream<RequestMasterEntity> findByRequestTitleReturnStream(@Param("requestTitle") String requestTitle);

    RequestMasterEntity findByRequestId(String requestId);

    //@Query("select c from Customer c")
    //Stream<Customer> findAllAndStream();

    //List<Customer> findByDateBetween(Date from, Date to);

}
