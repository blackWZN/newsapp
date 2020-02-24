package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.News;
import com.news.newsapp.service.NewsService;
import com.news.newsapp.web.model.Result;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	public Result findAll() {
		List<News> list = newsService.findAll();
		if(!list.isEmpty()) {
			return new Result(200, "查询成功",list);
		}
		return new Result(500, "没有数据");
	}
	
	@RequestMapping(value = "/searchByTitle/{keyWord}",method = RequestMethod.GET)
	public Result searchByTitle(@PathVariable String keyWord) {
		List<News> list = newsService.searchByTitle(keyWord);
		if(!list.isEmpty()) {
			return new Result(200, "搜索成功",list);
		}
		return new Result(500, "没有数据");
	}
}
