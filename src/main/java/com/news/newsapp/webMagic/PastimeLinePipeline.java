package com.news.newsapp.webMagic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.news.newsapp.dao.HeadlineMapper;
import com.news.newsapp.dao.PastimeMapper;
import com.news.newsapp.entity.Headline;
import com.news.newsapp.entity.Pastime;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class PastimeLinePipeline implements Pipeline{

	@Autowired
	private PastimeMapper pastimeMapper;
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		List<Pastime> list = resultItems.get("pastime");
		pastimeMapper.clearTable();
		for (Pastime pastime : list) {
			pastimeMapper.insert(pastime);
		}
	}

}
