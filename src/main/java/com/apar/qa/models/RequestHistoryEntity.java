package com.apar.qa.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RequestHistory")
public class RequestHistoryEntity  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	String historyId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="requestId")
	RequestMasterEntity requestId;
	String createdBy;
	Date createdAt;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="requestInitialStatus")
	MasterValuesEntity requestInitialStatus;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="requestEndStatus")
	MasterValuesEntity requestEndStatus;
	String remarks;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tags")
	TagMasterEntity tags;
	String assigneeFrom;
	String assigneeTo;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contentType")
	MasterValuesEntity contentType;
	
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	public RequestMasterEntity getRequestId() {
		return requestId;
	}
	public void setRequestId(RequestMasterEntity requestId) {
		this.requestId = requestId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public MasterValuesEntity getRequestInitialStatus() {
		return requestInitialStatus;
	}
	public void setRequestInitialStatus(MasterValuesEntity requestInitialStatus) {
		this.requestInitialStatus = requestInitialStatus;
	}
	public MasterValuesEntity getRequestEndStatus() {
		return requestEndStatus;
	}
	public void setRequestEndStatus(MasterValuesEntity requestEndStatus) {
		this.requestEndStatus = requestEndStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public TagMasterEntity getTags() {
		return tags;
	}
	public void setTags(TagMasterEntity tags) {
		this.tags = tags;
	}
	public String getAssigneeFrom() {
		return assigneeFrom;
	}
	public void setAssigneeFrom(String assigneeFrom) {
		this.assigneeFrom = assigneeFrom;
	}
	public String getAssigneeTo() {
		return assigneeTo;
	}
	public void setAssigneeTo(String assigneeTo) {
		this.assigneeTo = assigneeTo;
	}
	public MasterValuesEntity getContentType() {
		return contentType;
	}
	public void setContentType(MasterValuesEntity contentType) {
		this.contentType = contentType;
	}
	

	
}
