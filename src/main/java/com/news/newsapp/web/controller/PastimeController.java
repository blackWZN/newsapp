package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.Pastime;
import com.news.newsapp.service.PastimeService;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.PastimeLinePipeline;
import com.news.newsapp.webMagic.PastimeProcessor;

import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/pastime")
@CrossOrigin
public class PastimeController {

	@Autowired
	private PastimeService pastimeService;
	
	@Autowired
	private PastimeLinePipeline pastimeLinePipeline;
	
	@Autowired
	private PastimeProcessor pastimeProcessor;

	// 娱乐
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list() {
		List<Pastime> list = pastimeService.list();
		return new Result(200, "查询成功", list);
	}

	//刷新
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public Result refresh() {
		Spider.create(pastimeProcessor)
				.addUrl("http://c.3g.163.com/nc/article/list/T1348648517839/0-20.html")
				.thread(5)
				.addPipeline(pastimeLinePipeline).run();
		return new Result(200, "内容已更新");
	}

}
