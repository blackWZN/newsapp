package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.dao.EpidemicMapper;
import com.news.newsapp.entity.Column;
import com.news.newsapp.entity.Epidemic;
import com.news.newsapp.entity.EpidemicNews;
import com.news.newsapp.entity.Special;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.EpidemicProcessor;

import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/epidemic")
@CrossOrigin
public class EpidemicController {

	@Autowired
	private EpidemicProcessor epidemicProcessor;

	@Autowired
	private EpidemicMapper epidemicMapper;

	@RequestMapping("/refresh")
	public Result refresh() {
		System.out.println("刷新疫情数据");
		Spider.create(epidemicProcessor)
				.addUrl("http://gw.m.163.com/nc/api/v1/feed/static/normal-list?start=0&tid=T1579658657288&size=20")
				.thread(50).run();
		return null;
	}

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public Result epidemicData() {
		List<Epidemic> list = epidemicMapper.epidemicList();
		return new Result(200, "疫情统计",list);
	}
	
	@RequestMapping(value = "/special", method = RequestMethod.GET)
	public Result special() {
		List<Special> list = epidemicMapper.specialList();
		return new Result(200, "顶部图片和标题",list);
	}
	
	@RequestMapping(value = "/column", method = RequestMethod.GET)
	public Result column() {
		List<Column> list = epidemicMapper.columnLsit();
		return new Result(200, "中间的图标",list);
	}
	
	@RequestMapping(value = "/epidemicNews", method = RequestMethod.GET)
	public Result epidemicNews() {
		List<EpidemicNews> list = epidemicMapper.epidemicNewsList();
		return new Result(200, "疫情新闻",list);
	}
}
