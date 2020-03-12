package com.news.newsapp.dao;

import java.util.List;

import com.news.newsapp.entity.Headline;

public interface HeadlineMapper {
	
	public List<Headline> findAll();
	
	public List<Headline> searchByTitle(String keyWord);
	
	public int insert(Headline headline);
	
	public void clearTable();
	
	public Headline selectById(String id);
	
	public int insertContent(String content);
	
	public String selectContent();
		
	public void clearContent();

}
