package com.news.newsapp.webMagic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.dao.ChoicenessMapper;
import com.news.newsapp.dao.SportsMapper;
import com.news.newsapp.entity.Choiceness;
import com.news.newsapp.entity.Sports;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

@Component
public class ChoicenessProcessor implements PageProcessor{
	
	@Autowired
	private ChoicenessMapper choicenessMapper; 
	
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();
		JSONObject object = JSON.parseObject(dataStr);
		JSONArray jsonArray = object.getJSONArray("T1467284926140");
		List<Choiceness> list = JSON.parseArray(jsonArray.toString(), Choiceness.class);
		choicenessMapper.clearTable();
		for (Choiceness choiceness : list) {
			choicenessMapper.insert(choiceness);
		}
	}

	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
			.setTimeOut(1000);
	}
}
