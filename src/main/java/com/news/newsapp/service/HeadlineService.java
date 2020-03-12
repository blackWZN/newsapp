package com.news.newsapp.service;

import java.util.List;

import com.news.newsapp.entity.Headline;
import com.news.newsapp.web.model.Result;

public interface HeadlineService {
	
	public List<Headline> findAll();
	
	public List<Headline> searchByTitle(String keyWord);
	
	public void refres();
	
	public String content(String contenUrl);
}
