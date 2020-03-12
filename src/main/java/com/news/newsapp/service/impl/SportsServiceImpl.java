package com.news.newsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.SportsMapper;
import com.news.newsapp.entity.Sports;
import com.news.newsapp.service.SportsService;

@Service
public class SportsServiceImpl implements SportsService {
	
	@Autowired
	private SportsMapper sportsMapper; 
	
	public List<Sports> list() {
		List<Sports> list = sportsMapper.list();
		return list;
	}

}
