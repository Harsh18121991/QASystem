package com.apar.qa.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="RequestMaster")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestMasterBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8934737151319658838L;
	
	@Id
	@JsonProperty("requestId")
	String requestId;
	
	@JsonProperty("requestTitle")
	String requestTitle;
	
	@JsonProperty("shortDescription")
	String shortDescription;
	
	@Column
	@JsonProperty("description")
	String description;
	
	@Column
	@JsonProperty("requestType")
	String requestType;
	
	@Column
	@JsonProperty("contentType")
	String contentType;

	@Column
	@JsonProperty("status")
	String status;
	
	@Column
	@JsonProperty("createdBy")
	String createdBy;
	
	@Column
	@JsonProperty("createdAt")
	Date createdAt;
	
	@Column
	String owner;
	
	@Column
	String tags;
	
	@Column
	String priority;
	
	@Column
	Date targetClosureDate;
	
	@Column
	Date expectedReviewDate;
	
	public RequestMasterBean() {
		
	}
	
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
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
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
	
	 public void setProperties(Map<String, String> beanproperties) {
	  setRequestId(beanproperties.get("requestId"));
	  setRequestTitle(beanproperties.get("requestTitle"));
	  setShortDescription(beanproperties.get("shortDescription"));
	  setDescription(beanproperties.get("description"));
	  setRequestType(beanproperties.get("requestType"));
	  setContentType(beanproperties.get("contentType"));
	  setStatus(beanproperties.get("status"));
	  setCreatedBy(beanproperties.get("createdBy"));
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
