package com.news.newsapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.BottomNav;
import com.news.newsapp.service.BottomNavService;
import com.news.newsapp.web.model.Result;

@RestController
@RequestMapping("/bottomNav")
public class BottomNavController {

	@Autowired
	private BottomNavService bottomNavService;

	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Result findAll() {
		List<BottomNav> allList = bottomNavService.findAll();
		if (allList != null) {
			return new Result(200, "查询成功", allList);
		}
		return new Result(500, "查询失败");
	}
}
