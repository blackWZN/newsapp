package com.news.newsapp.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Sports {
	private String id;
	private String title;
	@JSONField(name = "source")
	private String author;
	@JSONField(name = "replyCount")
	private String commentCount;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime;
	private String status;
	@JSONField(name = "imgsrc")
	private String images;
	@JSONField(name = "url")
	private String contentUrl;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	@Override
	public String toString() {
		return "Sports [id=" + id + ", title=" + title + ", author=" + author + ", commentCount=" + commentCount
				+ ", updateTime=" + updateTime + ", status=" + status + ", images=" + images + ", contentUrl="
				+ contentUrl + "]";
	}

}
