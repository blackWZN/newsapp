package com.news.newsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.HeadlineMapper;
import com.news.newsapp.entity.Headline;
import com.news.newsapp.service.HeadlineService;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.Detail;
import com.news.newsapp.webMagic.HeadLinePipeline;
import com.news.newsapp.webMagic.HeadLineProcessor;

import us.codecraft.webmagic.Spider;

@Service
public class HeadlineServiceImpl implements HeadlineService {

	@Autowired
	private HeadlineMapper newsMapper;

	@Autowired
	private HeadLineProcessor headLineProcessor;

	@Autowired
	private HeadLinePipeline headLinePipeline;
	
	@Autowired
	private Detail detail;

	public List<Headline> findAll() {
		return newsMapper.findAll();
	}

	public List<Headline> searchByTitle(String keyWord) {
		return newsMapper.searchByTitle(keyWord);
	}

	public void refres() {
		System.out.println("刷新头条数据");
		Spider.create(headLineProcessor)
				.addUrl("http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html")
				.thread(50)
				.addPipeline(headLinePipeline).run();
	}

	
	public String content(String contenUrl) {
		Spider.create(detail)
		.addUrl(contenUrl)
		.thread(5).run();
		String content = newsMapper.selectContent();
		newsMapper.clearContent();
		return content;
	}

}
