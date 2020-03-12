package com.news.newsapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.newsapp.dao.AttentionMapper;
import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Writer;
import com.news.newsapp.service.AttentionService;

@Service
public class AttentionServiceImpl implements AttentionService{

	@Autowired
	private AttentionMapper attentionMapper;
	
	//未登录推荐内容
	public List<Attention> list(){
		List<Attention> list = attentionMapper.list();
		for (Attention attention : list) {
			String authorId = attention.getAuthorId();
			List<Writer> writer = attentionMapper.selectWriterById(authorId);
			attention.setWriter(writer);
		}
		System.out.println(list);
		return list;
	}

	//登录获取关注内容
	public List<Writer> getListByUser(String id) {
		List<Writer> writerList = attentionMapper.selectWriterByUserId(id);
		for (Writer writer : writerList) {
			List<Attention> attentionList = attentionMapper.findByWriterId(writer.getId());
			writer.setAttentions(attentionList);
		}
		return writerList;
	}
	
	public void seeWriter(String userId,String writerId) {
		attentionMapper.seeWriter(userId,writerId);
	}
}
