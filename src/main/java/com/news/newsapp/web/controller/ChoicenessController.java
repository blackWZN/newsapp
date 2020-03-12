package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.dao.ChoicenessMapper;
import com.news.newsapp.entity.Choiceness;
import com.news.newsapp.entity.Sports;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.ChoicenessProcessor;

import us.codecraft.webmagic.Spider;

@CrossOrigin
@RestController
@RequestMapping("/choiceness")
public class ChoicenessController {
	
	@Autowired
	private ChoicenessProcessor choicenessProcessor;
	
	@Autowired
	private ChoicenessMapper choicenessMapper; 
	
	@RequestMapping(value="/refresh",method=RequestMethod.GET)
	public Result refresh() {
		System.out.println("刷新要闻数据");
		Spider.create(choicenessProcessor)
				.addUrl("http://c.3g.163.com/nc/article/list/T1467284926140/0-20.html")
				.thread(50)
				.run();
		return new Result(200,"数据已刷新");
	}
	
	@RequestMapping(value = "/list",method =RequestMethod.GET)
	public Result list() {
		List<Choiceness> list = choicenessMapper.list();
		return new Result(200, "加载成功",list);
	}
}
