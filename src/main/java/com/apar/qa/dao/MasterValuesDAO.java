package com.apar.qa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apar.qa.models.MasterValuesEntity;

public interface MasterValuesDAO extends CrudRepository<MasterValuesEntity, Serializable> {
	MasterValuesEntity findById(String id);
	
	List<MasterValuesEntity> findByStatus(String status);
	
	@Query("select mv.id, mv.value from MasterValuesEntity mv where mv.groupId.groupName=:groupName")
	List<Object[]> findByGroupName(@Param("groupName") String groupName);
	
}
