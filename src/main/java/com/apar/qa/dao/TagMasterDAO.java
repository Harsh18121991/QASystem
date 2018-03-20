package com.apar.qa.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.apar.qa.models.TagMasterEntity;

public interface TagMasterDAO extends CrudRepository<TagMasterEntity,Serializable> {
	TagMasterEntity findByTagId(String tagId);
}
