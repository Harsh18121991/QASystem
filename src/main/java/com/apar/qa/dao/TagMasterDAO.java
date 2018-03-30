package com.apar.qa.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apar.qa.models.TagMasterEntity;

public interface TagMasterDAO extends CrudRepository<TagMasterEntity,Serializable> {
	
	TagMasterEntity findByTagId(String tagId);
	
	List<TagMasterEntity> findByTagName(String tagName);
	
	@Query("Select t.tagId from TagMasterEntity t where tagId in :tagIds")
	List<String> findAllByTagIds(@Param("tagIds") List<String> tagIdList);
	
	
	
}
