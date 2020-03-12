package com.news.newsapp.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.dao.AttentionMapper;
import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Sports;
import com.news.newsapp.entity.User;
import com.news.newsapp.entity.Writer;
import com.news.newsapp.service.AttentionService;
import com.news.newsapp.web.model.Result;
import com.news.newsapp.webMagic.AttentionPipeline;
import com.news.newsapp.webMagic.AttentionProcessor;
import com.news.newsapp.webMagic.PastimeLinePipeline;
import com.news.newsapp.webMagic.SciencePipeline;
import com.news.newsapp.webMagic.ScienceProcessor;

import us.codecraft.webmagic.Spider;

@CrossOrigin
@RestController
@RequestMapping("/attention")
public class AttentionController {

	@Autowired
	private AttentionProcessor attentionProcessor;

	@Autowired
	private AttentionPipeline attentionPipeline;

	@Autowired
	private ScienceProcessor scienceProcessor;

	@Autowired
	private SciencePipeline sciencePipeline;

	@Autowired
	private AttentionService attentionService;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private AttentionMapper attentionMapper;

	/*
	 * @RequestMapping("refresh") public String sx() {
	 * Spider.create(attentionProcessor) .addUrl(
	 * "https://3g.163.com/touch/reconstruct/article/list/BA8F6ICNwangning/0-10.html")
	 * .thread(5) .addPipeline(attentionPipeline) .run(); return "ok"; }
	 * 
	 * @RequestMapping("refresh1") public String sx1() {
	 * Spider.create(scienceProcessor) .addUrl(
	 * "https://3g.163.com/touch/reconstruct/article/list/BA8D4A3Rwangning/0-10.html")
	 * .thread(5) .addPipeline(sciencePipeline) .run(); return "ok"; }
	 */

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Result list(HttpServletRequest request) {
		List<Attention> list = attentionService.list();
		Object attribute = session.getAttribute("user");
		User user = null;
		if (attribute != null) {
			user = (User) attribute;
		}
		System.out.println("user: " + session.getAttribute("user"));
		// 用户未登录显示所有内容
		if (user == null) {
			return new Result(200, "登录后再关注，第一时间获取最新动态", list);
		}
		// 用户已登录，优先显示已关注内容
		String id = user.getId();
		List<Writer> writerList = attentionService.getListByUser(id);
		if (writerList.isEmpty()) {
			return new Result(200, "你的暂无关注，为您推荐热门内容", list);
		}
		return new Result(200, "关注内容列表", writerList);
	}

	@RequestMapping(value = "/get/{writerId}", method = RequestMethod.GET)
	public Result get(@PathVariable String writerId) {
		 Object attribute = session.getAttribute("user");
		if(attribute == null) {
			return new Result(200, "请登陆后关注");
		}
		User user = (User) attribute;
	
		attentionMapper.seeWriter(user.getId(), writerId);
		return new Result(200, "关注用成功");
	}

}
