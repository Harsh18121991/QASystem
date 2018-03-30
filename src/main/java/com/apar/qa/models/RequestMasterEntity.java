package com.apar.qa.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RequestMaster")
public class RequestMasterEntity implements Serializable {

	private static final long serialVersionUID = 8934737151319658838L;
	
	@Id
	String requestId;
	String requestTitle;
	String shortDescription;
	String description;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="requestType")
	MasterValuesEntity requestType;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contentType")
	MasterValuesEntity contentType;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="status")
	MasterValuesEntity status;
	String createdBy;
	Date createdAt;
	String owner;
	String tags;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="priority")
	MasterValuesEntity priority;
	Date targetClosureDate;
	Date expectedReviewDate;

	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MasterValuesEntity getRequestType() {
		return requestType;
	}
	public void setRequestType(MasterValuesEntity requestType) {
		this.requestType = requestType;
	}
	public MasterValuesEntity getContentType() {
		return contentType;
	}
	public void setContentType(MasterValuesEntity contentType) {
		this.contentType = contentType;
	}
	public MasterValuesEntity getStatus() {
		return status;
	}
	public void setStatus(MasterValuesEntity status) {
		this.status = status;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public MasterValuesEntity getPriority() {
		return priority;
	}
	public void setPriority(MasterValuesEntity priority) {
		this.priority = priority;
	}
	public Date getTargetClosureDate() {
		return targetClosureDate;
	}

	public void setTargetClosureDate(Date targetClosureDate) {
		this.targetClosureDate = targetClosureDate;
	}

	public Date getExpectedReviewDate() {
		return expectedReviewDate;
	}

	public void setExpectedReviewDate(Date expectedReviewDate) {
		this.expectedReviewDate = expectedReviewDate;
	}
	
	public void setProperties(Map<String, Object> beanproperties) {
		setRequestTitle((String) beanproperties.get("requestTitle"));
		setShortDescription((String) beanproperties.get("shortDescription"));
		setDescription((String) beanproperties.get("description"));
		setCreatedBy("System");
		setOwner((String) beanproperties.get("owner"));
		setCreatedAt(new Date());
	}
	 
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Properties ");
        sb.append("Request Id=").append(requestId).append(", ");
        sb.append("Request Title=").append(requestTitle).append(", ");
        sb.append("Short Description=").append(shortDescription).append(", ");
        sb.append("Description=").append(description).append(", ");
        sb.append("Request Type=").append(requestType).append(", ");
        sb.append("Content Type=").append(contentType).append(", ");
        sb.append("Status=").append(status).append(", ");
        sb.append("CreatedBy=").append(createdBy).append(", ");
        sb.append("CreatedAt=").append(createdAt).append(", ");
     	return sb.toString();
	}
	
}
