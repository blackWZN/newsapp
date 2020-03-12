package com.news.newsapp.webMagic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.news.newsapp.dao.HeadlineMapper;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

@Component
public class Detail implements PageProcessor{

	@Autowired
	private HeadlineMapper headlineMapper;
	
	@Override
	public void process(Page page) {
		Html html = page.getHtml();
		List<String> all = html.css("article p").all();
		headlineMapper.insertContent(all.toString());
	}

	@Override
	public Site getSite() {
		return Site.me();
	}
	
	

}
