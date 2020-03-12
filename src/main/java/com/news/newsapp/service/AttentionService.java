package com.news.newsapp.service;

import java.util.List;

import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Writer;

public interface AttentionService {
	public List<Attention> list();

	public List<Writer> getListByUser(String id);
	
	void seeWriter(String userId,String writerId);
}
