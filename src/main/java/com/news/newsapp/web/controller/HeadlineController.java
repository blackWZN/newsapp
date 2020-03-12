package com.news.newsapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.Headline;
import com.news.newsapp.service.HeadlineService;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.HeadLinePipeline;
import com.news.newsapp.webMagic.HeadLineProcessor;
import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/headline")
@CrossOrigin
public class HeadlineController {
	
	@Autowired
	private HeadlineService newsService;
	
	@Autowired
	private HttpSession session;
	
	//头条
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Result findAll() {
		
		List<Headline> list = newsService.findAll();
		if(!list.isEmpty()) {
			return new Result(200, "查询成功",list);
		}
		return new Result(500, "没有数据");
	}
	
	//搜索
	@RequestMapping(value = "/searchByTitle/{keyWord}",method = RequestMethod.GET)
	public Result searchByTitle(@PathVariable String keyWord) {
		List<Headline> list = newsService.searchByTitle(keyWord);
		if(!list.isEmpty()) {
			return new Result(200, "搜索成功",list);
		}
		return new Result(500, "没有数据");
	}
	
	//刷新
	@RequestMapping(value = "refres",method = RequestMethod.GET)
	public Result refres() {
		newsService.refres();		
		return new Result(200, "内容已更新");
	}
	
	//加载详情内容，适用所有栏目
	@RequestMapping(value = "/content",method = RequestMethod.GET)
	public Result content(@RequestParam String contenUrl) {
		String content = newsService.content(contenUrl);
		return new Result(200, "內容已加载",content);
	}
}
