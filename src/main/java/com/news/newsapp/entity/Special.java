package com.news.newsapp.entity;


public class Special {
	private String id;
	private String title;
	private String imgsrc;
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
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	@Override
	public String toString() {
		return "Special [id=" + id + ", title=" + title + ", imgsrc=" + imgsrc + "]";
	}
	
}
