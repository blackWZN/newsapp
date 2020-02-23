package com.news.newsapp.service;

import java.util.List;

import com.news.newsapp.entity.News;

public interface NewsService {
	
	public List<News> findAll();
	
	public List<News> searchByTitle(String keyWord);
}
