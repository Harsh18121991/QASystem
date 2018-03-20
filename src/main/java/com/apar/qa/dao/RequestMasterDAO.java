package com.apar.qa.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apar.qa.models.RequestMasterEntity;


public interface RequestMasterDAO extends CrudRepository<RequestMasterEntity, Long> {

    List<RequestMasterEntity> findByRequestTitle(String requestTitle);

    @Query("select c from RequestMasterEntity c where c.requestTitle = :requestTitle")
    Stream<RequestMasterEntity> findByRequestTitleReturnStream(@Param("requestTitle") String requestTitle);

    List<RequestMasterEntity> findByRequestId(String requestId);

    //@Query("select c from Customer c")
    //Stream<Customer> findAllAndStream();

    //List<Customer> findByDateBetween(Date from, Date to);

}
