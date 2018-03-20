package com.apar.qa.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="RequestContents")
public class RequestContentsEntity implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	String contentId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="requestId")
	RequestMasterEntity requestId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="historyId")
	RequestHistoryEntity historyId;
	String content;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contentType")
	MasterValuesEntity contentType;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tags")
	TagMasterEntity tags;
	String createdBy;
	Date createdAt;

	
	
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	public RequestMasterEntity getRequestId() {
		return requestId;
	}
	public void setRequestId(RequestMasterEntity requestId) {
		this.requestId = requestId;
	}
	public RequestHistoryEntity getHistoryId() {
		return historyId;
	}
	public void setHistoryId(RequestHistoryEntity historyId) {
		this.historyId = historyId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MasterValuesEntity getContentType() {
		return contentType;
	}
	public void setContentType(MasterValuesEntity contentType) {
		this.contentType = contentType;
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
	public TagMasterEntity getTags() {
		return tags;
	}
	public void setTags(TagMasterEntity tags) {
		this.tags = tags;
	}
	
	
	
}
