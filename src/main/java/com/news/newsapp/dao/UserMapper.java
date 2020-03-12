package com.news.newsapp.dao;

import com.news.newsapp.entity.Sports;
import com.news.newsapp.entity.User;

public interface UserMapper {
	public int insert(User user);
	
	public User findByPhone(String phone);
}
