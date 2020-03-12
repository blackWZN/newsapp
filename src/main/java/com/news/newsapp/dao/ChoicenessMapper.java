package com.news.newsapp.dao;

import java.util.List;

import com.news.newsapp.entity.Choiceness;
import com.news.newsapp.entity.Sports;

public interface ChoicenessMapper {
	void insert(Choiceness choiceness);
	
	List<Choiceness> list();
	
	void clearTable();
}
