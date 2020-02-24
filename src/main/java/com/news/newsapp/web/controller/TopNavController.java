package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.TopNav;
import com.news.newsapp.service.TopNavService;
import com.news.newsapp.web.model.Result;

@RestController
@RequestMapping("/topNav")
@CrossOrigin
public class TopNavController {
	
	@Autowired
	private TopNavService navService; 
	
	@RequestMapping(value = "/findbyBottomNavId/{bottomNavId}",method= RequestMethod.GET)
	public Result findbyBottomNavId(@PathVariable int bottomNavId) {
		List<TopNav> list = navService.findbyBottomNavId(bottomNavId);
		if(!list.isEmpty()) {
			return new Result(200, "查询成功",list);
		}
		return new Result(500, "没有数据");
		
	}
}
