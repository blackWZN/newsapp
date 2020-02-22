package com.news.newsapp.entity;

import java.util.Date;

public class TopNav {
	private String id;
	private String name;
	private Date update_time;
	private String status;
	private String bottom_nav_id;
	
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
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBottom_nav_id() {
		return bottom_nav_id;
	}
	public void setBottom_nav_id(String bottom_nav_id) {
		this.bottom_nav_id = bottom_nav_id;
	}
	
	
}
