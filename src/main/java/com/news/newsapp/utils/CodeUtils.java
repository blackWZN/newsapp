package com.news.newsapp.utils;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class CodeUtils {
	
	public static String code(HttpServletRequest request) {
		StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<6;i++) {
        	stringBuffer.append(Integer.toHexString(new Random().nextInt(16)));
        }
        String code = stringBuffer.toString().toUpperCase();
        request.getSession().setAttribute("code", code);
        return code;
	}
}
