package com.news.newsapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Attention {
	private String id;
	private String title;
	@JSONField(name = "source")
	private String authorId;
	@JSONField(name = "commentCount")
	private String commentCount;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime;
	private String status;
	@JSONField(name = "imgsrc")
	private String images;
	@JSONField(name = "url")
	private String contentUrl;
	
	private List<Writer> writer;
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthorId() {
		return authorId;
	}



	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}



	public String getCommentCount() {
		return commentCount;
	}



	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}



	public Date getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getImages() {
		return images;
	}



	public void setImages(String images) {
		this.images = images;
	}



	public String getContentUrl() {
		return contentUrl;
	}



	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}



	public List<Writer> getWriter() {
		return writer;
	}



	public void setWriter(List<Writer> writer) {
		this.writer = writer;
	}


	@Override
	public String toString() {
		return "Attention [id=" + id + ", title=" + title + ", authorId=" + authorId + ", commentCount=" + commentCount
				+ ", updateTime=" + updateTime + ", status=" + status + ", images=" + images + ", contentUrl="
				+ contentUrl + ", writer=" + writer + "]";
	}

}
