package com.news.newsapp.webMagic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.dao.AttentionMapper;
import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Headline;
import com.news.newsapp.entity.Pastime;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

@Component
public class AttentionPipeline implements Pipeline{
	
	@Autowired
	private AttentionMapper attentionMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		List<Attention> list = resultItems.get("attention");
		for (Attention attention : list) {
			attentionMapper.insert(attention);
		}
	}
}
