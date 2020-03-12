package com.news.newsapp.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Epidemic {
	private String id;
	@JSONField(name = "mainLabel")
	private String name;
	@JSONField(name = "mainNum")
	private String num;
	@JSONField(name = "subNum")
	private String subNum;
	@JSONField(name = "lastUpdateTime")
	private String lastUpdateTime;
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
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSubNum() {
		return subNum;
	}
	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	@Override
	public String toString() {
		return "Epidemic [id=" + id + ", name=" + name + ", num=" + num + ", subNum=" + subNum + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}
	
}
