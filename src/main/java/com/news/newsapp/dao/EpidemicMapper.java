package com.news.newsapp.dao;

import java.util.List;

import com.news.newsapp.entity.Column;
import com.news.newsapp.entity.Epidemic;
import com.news.newsapp.entity.EpidemicNews;
import com.news.newsapp.entity.Special;

public interface EpidemicMapper {
	
	void insertEpidemic(Epidemic epidemic);
	
	void insertSpecial(Special special);
	
	void insertColumn(Column column);
	
	void insertEpidemicNews(EpidemicNews epidemicNews);
	
	void clearEpidemic();
	
	void clearSpecial();
	
	void clearColumn();
	
	void clearEpidemicNews();
	
	List<Epidemic> epidemicList();
	
	List<Special> specialList();
	
	List<Column> columnLsit();
	
	List<EpidemicNews> epidemicNewsList();
}
