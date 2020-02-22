package com.news.newsapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Array;
import com.news.newsapp.dao.BottomNavMapper;
import com.news.newsapp.entity.BottomNav;
import com.news.newsapp.service.BottomNavService;

@Service
public class BottomNavServiceImpl implements BottomNavService {
	
	@Autowired
	private BottomNavMapper bottomNavMapper;
	
	public List<BottomNav> findAll(){
		List<BottomNav> list = bottomNavMapper.findAll();
		
		return list;
	}
}
