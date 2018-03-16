package com.apar.qa.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apar.qa.models.RequestBean;


public interface RequestRepository extends CrudRepository<RequestBean, Long> {

    List<RequestBean> findByRequestTitle(String requestTitle);

    @Query("select c from RequestBean c where c.requestTitle = :requestTitle")
    Stream<RequestBean> findByRequestTitleReturnStream(@Param("requestTitle") String requestTitle);

    List<RequestBean> findByRequestId(String requestId);

    //@Query("select c from Customer c")
    //Stream<Customer> findAllAndStream();

    //List<Customer> findByDateBetween(Date from, Date to);

}
