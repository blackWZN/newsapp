package com.news.newsapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.UserMapper;
import com.news.newsapp.entity.Sports;
import com.news.newsapp.entity.User;
import com.news.newsapp.service.UserService;
import com.news.newsapp.utils.CodeUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public void loginByPhone(String phone,String code) {
		User user = new User();
		user.setPhone(phone);
		user.setNickname("用户"+code);
		userMapper.insert(user);
	}

	public User findByPhone(String phone) {
		User user = userMapper.findByPhone(phone);
		return user;
	}
}
