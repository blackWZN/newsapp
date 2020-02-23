package com.news.newsapp.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TopNav {
	private String id;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date updateTime;
	private String status;
	private String bottomNavId;
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
	public String getBottomNavId() {
		return bottomNavId;
	}
	public void setBottomNavId(String bottomNavId) {
		this.bottomNavId = bottomNavId;
	}
	
}
