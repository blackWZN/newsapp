package com.news.newsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.PastimeMapper;
import com.news.newsapp.entity.Pastime;
import com.news.newsapp.service.PastimeService;
import com.news.newsapp.webMagic.PastimeLinePipeline;
import com.news.newsapp.webMagic.PastimeProcessor;

import us.codecraft.webmagic.Spider;

@Service
public class PastimeServiceImpl implements PastimeService{

	@Autowired
	private PastimeMapper pastimeMapper;
	
	
	public List<Pastime> list() {
		List<Pastime> list = pastimeMapper.list();
		return list;
	}
	
}
