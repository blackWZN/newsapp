package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.dao.PastimeMapper;
import com.news.newsapp.entity.Joke;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.JokeProcessor;

import us.codecraft.webmagic.Spider;

@RestController
@RequestMapping("/joke")
@CrossOrigin
public class JokeController {
	
	@Autowired
	private JokeProcessor jokeProcessor;
	
	@Autowired
	private PastimeMapper pastimeMapper;

	@RequestMapping(value = "/refresh",method= RequestMethod.GET)
	public Result refresh() {
		Spider.create(jokeProcessor)
			.addUrl("http://3g.163.com/touch/jsonp/joke/chanListNews/T1419316284722/2/0-10.html?callback=joke0")
			.run();
		return new Result(200, "刷新成功");
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Result jokeLsit() {
		List<Joke> list = pastimeMapper.jokeList();
		return new Result(200, "段子列表",list);
	}
}
