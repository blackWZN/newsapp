package com.news.newsapp.webMagic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.entity.Headline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

@Component
public class HeadLineProcessor implements PageProcessor{
	
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();

		JSONObject object = JSON.parseObject(dataStr);
		JSONArray jsonArray = object.getJSONArray("T1348647853363");
		List<Headline> list = JSON.parseArray(jsonArray.toString(), Headline.class);
		page.putField("list", list);
		
		
			
	}

	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
			.setTimeOut(1000);
	}
}
