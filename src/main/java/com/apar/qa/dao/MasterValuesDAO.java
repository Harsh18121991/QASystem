package com.apar.qa.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.apar.qa.models.MasterValuesEntity;

public interface MasterValuesDAO extends CrudRepository<MasterValuesEntity, Serializable> {
	MasterValuesEntity findById(String id);
}
