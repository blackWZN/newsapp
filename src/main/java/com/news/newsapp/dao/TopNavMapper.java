package com.news.newsapp.dao;

import java.util.List;

import com.news.newsapp.entity.TopNav;

public interface TopNavMapper {
	
	public List<TopNav> findbyBottomNavId(int bottomNavId);
}
