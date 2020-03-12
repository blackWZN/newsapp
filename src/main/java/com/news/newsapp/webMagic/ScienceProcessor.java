package com.news.newsapp.webMagic;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.dao.AttentionMapper;
import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Headline;
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
public class ScienceProcessor implements PageProcessor {
		
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();
		String subData = dataStr.substring(9,dataStr.length()-1);
		JSONObject object = JSON.parseObject(subData);
		JSONArray jsonArray = object.getJSONArray("BA8D4A3Rwangning");
		List<Attention> list = JSON.parseArray(jsonArray.toString(), Attention.class);
		page.putField("science", list);		
	}

	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
				.setTimeOut(1000);
	}

}
