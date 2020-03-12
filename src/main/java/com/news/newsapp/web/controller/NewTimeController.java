package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.dao.SportsMapper;
import com.news.newsapp.entity.Joke;
import com.news.newsapp.entity.Sports;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.NewTimeProcessor;

import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/newTime")
@CrossOrigin
public class NewTimeController {
	
	@Autowired
	private NewTimeProcessor newTimeProcessor;
	
	@Autowired
	private SportsMapper sportsMapper;
	
	@RequestMapping(value = "/refresh",method= RequestMethod.GET)
	public Result refresh() {
		Spider.create(newTimeProcessor)
			.addUrl("http://c.m.163.com/nc/article/list/T1414142214384/0-20.html")
			.thread(5)
			.runAsync();
		return new Result(200, "刷新成功");
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Result newTimeLsit() {
		List<Sports> list = sportsMapper.newTimeList();
		return new Result(200, "新时代列表",list);
	}
}
