package com.news.newsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.NewsMapper;
import com.news.newsapp.entity.News;
import com.news.newsapp.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsMapper newsMapper;
	
	public List<News> findAll() {
		return newsMapper.findAll();
	}

	public List<News> searchByTitle(String keyWord) {
		return newsMapper.searchByTitle(keyWord);
	}

}
