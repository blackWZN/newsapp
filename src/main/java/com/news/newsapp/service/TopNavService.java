package com.news.newsapp.service;

import java.util.List;
import com.news.newsapp.entity.TopNav;

public interface TopNavService {
	public List<TopNav> findbyBottomNavId(int bottomNavId);
}
