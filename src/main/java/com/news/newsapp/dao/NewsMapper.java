package com.news.newsapp.dao;

import java.util.List;

import com.news.newsapp.entity.News;

public interface NewsMapper {
	
	public List<News> findAll();
	
	public List<News> searchByTitle(String keyWord);
}
