package com.news.newsapp.webMagic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.dao.SportsMapper;
import com.news.newsapp.entity.Sports;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

@Component
public class SportsProcessor implements PageProcessor{
	
	@Autowired
	private SportsMapper sportsMapper; 
	
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();
		JSONObject object = JSON.parseObject(dataStr);
		JSONArray jsonArray = object.getJSONArray("T1348649079062");
		List<Sports> list = JSON.parseArray(jsonArray.toString(), Sports.class);
		sportsMapper.clearTable();
		for (Sports sports : list) {
			sportsMapper.insert(sports);
		}
	}

	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
			.setTimeOut(1000);
	}
}
