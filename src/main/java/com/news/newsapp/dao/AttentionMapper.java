package com.news.newsapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.news.newsapp.entity.Attention;
import com.news.newsapp.entity.Headline;
import com.news.newsapp.entity.Writer;

public interface AttentionMapper {

	public int insert(Attention attention);
	
	public List<Attention> list();
	
	public List<Writer> selectWriterById(String writerId);

	public List<Attention> getListByUser(String userId);
	
	public List<Writer> selectWriterByUserId(String userId);
	
	//根据WriterId查找Attention
	public List<Attention> findByWriterId(String WriterId);
	
	void seeWriter(@Param("userId") String userId,@Param("writerId") String writerId);
}
