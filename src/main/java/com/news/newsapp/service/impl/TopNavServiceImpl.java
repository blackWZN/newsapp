package com.news.newsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.TopNavMapper;
import com.news.newsapp.entity.TopNav;
import com.news.newsapp.service.TopNavService;

@Service
public class TopNavServiceImpl implements TopNavService{

	@Autowired
	private TopNavMapper topNavMapper; 
	
	
	public List<TopNav> findbyBottomNavId(int bottomNavId) {
		List<TopNav> list = topNavMapper.findbyBottomNavId(bottomNavId);
		return list;
	}

}
