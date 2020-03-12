package com.news.newsapp.dao;

import java.util.List;

import com.news.newsapp.entity.Sports;

public interface SportsMapper {
	
	void insert(Sports sports);
	
	List<Sports> list();
	
	void clearTable();
	
	//新时代
	void insertNewTime(Sports newTime);
	
	void clearNewTime();
	
	List<Sports> newTimeList();
}
