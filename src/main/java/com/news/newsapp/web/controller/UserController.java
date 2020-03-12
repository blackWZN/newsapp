package com.news.newsapp.web.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.newsapp.entity.Sports;
import com.news.newsapp.entity.User;
import com.news.newsapp.service.UserService;
import com.news.newsapp.utils.CodeUtils;
import com.news.newsapp.web.model.Result;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	// 获取验证码
	@RequestMapping(value = "/code/{phone}", method = RequestMethod.GET)
	public Result code(@PathVariable String phone, HttpServletRequest request) {
		String phoneRegex = "^1[3578]\\d{9}";
		if (phone.matches(phoneRegex)) {
			String code = CodeUtils.code(request);
			return new Result(200, "获取到验证码", code);
		}
		return new Result(500, "手机号格式不正确");
	}

	// 手机号登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result loginByPhone(String phone, String reqCode, HttpServletRequest request) {
		String phoneRegex = "^1[3578]\\d{9}";
		String code = (String) request.getSession().getAttribute("code");
		User user = userService.findByPhone(phone);
		System.out.println("11: " + user);
		// 手机号未登录过
		if (user == null) {
			userService.loginByPhone(phone, code);
		}
		user = userService.findByPhone(phone);
		if (user != null && code != null && phone.matches(phoneRegex) && code.equals(reqCode)) {
			// 登录
			session.setAttribute("user", user);
			session.setAttribute("code","");
			return new Result(200, "登录成功", user);
		}
		return new Result(500, "手机号或验证码错误");
	}
	
	@RequestMapping(value = "/loginOut",method = RequestMethod.GET)
	public Result loginOut() {
		session.invalidate();
		return new Result(200,"已退出登录");
	}
	
}
