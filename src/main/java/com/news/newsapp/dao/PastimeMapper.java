package com.news.newsapp.dao;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.news.newsapp.entity.Joke;
import com.news.newsapp.entity.Pastime;

public interface PastimeMapper {
	
	//娱乐
	public List<Pastime> list();
	
	public int insert(Pastime pastime );
	
	public void clearTable();
	
	//段子
	void insertJoke(Joke joke);
	void clearJkoe();
	List<Joke> jokeList();
}
