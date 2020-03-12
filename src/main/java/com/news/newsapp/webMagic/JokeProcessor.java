package com.news.newsapp.webMagic;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.dao.AttentionMapper;
import com.news.newsapp.dao.PastimeMapper;
import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Headline;
import com.news.newsapp.entity.Joke;
import com.news.newsapp.webMagic.PastimeLinePipeline;
import com.news.newsapp.webMagic.PastimeProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.JsonPathSelector;

@Component
public class JokeProcessor implements PageProcessor {
		
	@Autowired
	private PastimeMapper pastimeMapper;
	
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();
		String subData = dataStr.substring(12,dataStr.length()-2);
		List<Joke> list = JSON.parseArray(subData, Joke.class);
		pastimeMapper.clearJkoe();
		for (Joke joke : list) {
			pastimeMapper.insertJoke(joke);
		}
			
	}

	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
				.setTimeOut(1000);
	}

	public static void main(String[] args) {
		Spider.create(new JokeProcessor())
			.addUrl("http://3g.163.com/touch/jsonp/joke/chanListNews/T1419316284722/2/0-10.html?callback=joke0")
			.run();
	}
}
