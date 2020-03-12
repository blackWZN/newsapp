package com.news.newsapp.service;

import com.news.newsapp.entity.Sports;
import com.news.newsapp.entity.User;

public interface UserService {
	
	public void loginByPhone(String phone,String code);
	
	public User findByPhone(String phone);
}
