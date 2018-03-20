package com.apar.qa.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RequestHistory")
public class RequestHistoryEntity  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	String historyId;
	String requestId;
	String createdBy;
	Date createdAt;
	String requestInitialStatus;
	String requestEndStatus;
	String remarks;
	String tags;
	String assigneeFrom;
	String assigneeTo;
	String contentType;
	
	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
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
	public String getRequestInitialStatus() {
		return requestInitialStatus;
	}
	public void setRequestInitialStatus(String requestInitialStatus) {
		this.requestInitialStatus = requestInitialStatus;
	}
	public String getRequestEndStatus() {
		return requestEndStatus;
	}
	public void setRequestEndStatus(String requestEndStatus) {
		this.requestEndStatus = requestEndStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
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
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	
}
