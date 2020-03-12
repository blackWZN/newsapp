package com.news.newsapp.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class Column {
	private String id;
	@JSONField(name = "imgsrc")
	private String icon;
	@JSONField(name = "title")
	private String name;
	@JSONField(name = "url")

	private String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Column [id=" + id + ", icon=" + icon + ", name=" + name + ", url=" + url + "]";
	}
	
}
