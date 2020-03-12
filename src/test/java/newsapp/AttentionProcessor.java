package newsapp;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
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
public class AttentionProcessor implements PageProcessor {
	
	@Autowired
	private AttentionMapper attentionMapper;
	
	@Override
	public void process(Page page) {
		Json json = page.getJson();
		String dataStr = json.toString();
		String subData = dataStr.substring(9,dataStr.length()-1);
		JSONObject object = JSON.parseObject(subData);
		JSONArray jsonArray = object.getJSONArray("BA8F6ICNwangning");
		System.out.println(jsonArray.toJSONString());
		List<Attention> list = JSON.parseArray(jsonArray.toString(), Attention.class);
		for (Attention attention : list) {
			attentionMapper.insert(attention);
		}
//		page.putField("list", list);
		
		
	}

	//设置请求参数
	@Override
	public Site getSite() {
		return Site.me()
				.setTimeOut(1000);
	}

	public static void main(String[] args) {
//		Spider.create(new WebMagic())
//			.addUrl("https://3g.163.com/touch/reconstruct/article/list/BA8F6ICNwangning/0-10.html")
//			.thread(5)
////			.addPipeline(new PastimeLinePipeline())
//			.run();

	}
}
