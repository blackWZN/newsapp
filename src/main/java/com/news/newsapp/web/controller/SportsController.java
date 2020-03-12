package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.Sports;
import com.news.newsapp.service.SportsService;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.SportsProcessor;

import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/sports")
@CrossOrigin
public class SportsController {
	
	@Autowired
	private SportsProcessor  sportsProcessor;
	
	@Autowired
	private SportsService sportsService;
	
	@RequestMapping(value="/refresh",method=RequestMethod.GET)
	public Result refresh() {
		System.out.println("刷新体育数据");
		Spider.create(sportsProcessor)
				.addUrl("http://c.3g.163.com/nc/article/list/T1348649079062/0-20.html")
				.thread(50)
				.run();
		return new Result(200,"数据已刷新");
	}
	
	@RequestMapping(value = "/list",method =RequestMethod.GET)
	public Result list() {
		List<Sports> list = sportsService.list();
		return new Result(200, "加载成功",list);
	}
}
