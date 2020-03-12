package com.news.newsapp.webMagic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.news.newsapp.dao.HeadlineMapper;
import com.news.newsapp.entity.Headline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class HeadLinePipeline implements Pipeline {

	@Autowired
	private HeadlineMapper headlineMapper;

	@Override
	public void process(ResultItems resultItems, Task task) {
		List<Headline> list = resultItems.get("list");
		headlineMapper.clearTable();
		for (Headline headline : list) {
			headlineMapper.insert(headline);
		}

	}

}
