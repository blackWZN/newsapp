package com.news.newsapp.webMagic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.news.newsapp.dao.EpidemicMapper;
import com.news.newsapp.entity.Column;
import com.news.newsapp.entity.Epidemic;
import com.news.newsapp.entity.EpidemicNews;
import com.news.newsapp.entity.Special;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

@Component
public class EpidemicProcessor implements PageProcessor{
	
	@Autowired
	private EpidemicMapper epidemicMapper;
	
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();
		JSONObject object = JSON.parseObject(dataStr);
		Object object2 = object.get("data");
		JSONObject parse = JSON.parseObject(object2.toString());
		
		JSONArray jsonArray = parse.getJSONArray("items");
		
		//解析疫情统计
		Object object3 = jsonArray.get(1);
		JSONObject parse1 = JSON.parseObject(object3.toString());
		Object object4 = parse1.get("epidemicInfo");
		JSONObject parse2 = JSON.parseObject(object4.toString());
		JSONArray data = parse2.getJSONArray("epidemicData");
		List<Epidemic> list = JSON.parseArray(data.toString(), Epidemic.class);
		String lastUpdateTime = parse2.getString("lastUpdateTime");
		for (Epidemic epidemic : list) {
			epidemic.setLastUpdateTime(lastUpdateTime);
		}
		epidemicMapper.clearEpidemic();
		for (Epidemic epidemic : list) {
			epidemicMapper.insertEpidemic(epidemic);
		}
		
		//解析专题
		Object object5 = jsonArray.get(0);
		JSONObject parse4 = JSON.parseObject(object5.toString());
		String title = parse4.getString("title");
		String imgsrc = parse4.getString("imgsrc");
		Special special = new Special();
		special.setImgsrc(imgsrc);
		special.setTitle(title);
		epidemicMapper.clearSpecial();
		epidemicMapper.insertSpecial(special);
		
		//解析疫情栏目
		Object object6 = parse.get("wap_pluginfo");
		JSONObject parse6 = JSON.parseObject(object6.toString());
		JSONArray jsonArray6 = parse6.getJSONArray("commonPlugin");
		List<Column> parseArray = JSON.parseArray(jsonArray6.toJSONString(), Column.class);
		epidemicMapper.clearColumn();
		for (Column column : parseArray) {
			epidemicMapper.insertColumn(column);
		}
		
		//解析疫情新闻
		List<EpidemicNews> epidemicNewsList = new ArrayList<>();
		for (int i = 2; i < jsonArray.size(); i++) {
			Object object7 = jsonArray.get(i);
			EpidemicNews epidemicNews = JSON.parseObject(object7.toString(), EpidemicNews.class);
			epidemicNewsList.add(epidemicNews);
		}
		epidemicMapper.clearEpidemicNews();
		for (EpidemicNews epidemicNews : epidemicNewsList) {
			epidemicMapper.insertEpidemicNews(epidemicNews);
		}
		
		

	}
	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
			.setTimeOut(1000);
	}
	
	public static void main(String[] args) {
		
	}
}
