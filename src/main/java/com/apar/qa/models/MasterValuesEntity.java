package com.apar.qa.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MasterValues")
public class MasterValuesEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	String id;
	String name;
	String value;	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="groupId", referencedColumnName="groupId")
	MasterValueGroupsEntity groupId;	
	String status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public MasterValueGroupsEntity getGroupId() {
		return groupId;
	}
	public void setGroupId(MasterValueGroupsEntity groupId) {
		this.groupId = groupId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
