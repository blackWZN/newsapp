package com.news.newsapp.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Joke {
    @JSONField(serialize = false)//忽略该字段映射数据
	private String Joke_id;
	private String title;
	@JSONField(name = "source")
	private String author;
	@JSONField(name = "digest")
	private String content;
	@JSONField(name = "laughweight")
	private String laugh;
	@JSONField(name = "enjoyweight")
	private String enjoy;
	@JSONField(name = "boredweight")
	private String bored;
	
	public String getJoke_id() {
		return Joke_id;
	}
	public void setJoke_id(String joke_id) {
		Joke_id = joke_id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLaugh() {
		return laugh;
	}
	public void setLaugh(String laugh) {
		this.laugh = laugh;
	}
	public String getEnjoy() {
		return enjoy;
	}
	public void setEnjoy(String enjoy) {
		this.enjoy = enjoy;
	}
	public String getBored() {
		return bored;
	}
	public void setBored(String bored) {
		this.bored = bored;
	}
	@Override
	public String toString() {
		return "Joke [Joke_id=" + Joke_id + ", title=" + title + ", author=" + author + ", content=" + content
				+ ", laugh=" + laugh + ", enjoy=" + enjoy + ", bored=" + bored + "]";
	}
	
	
}
