package com.news.newsapp.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String, Date>{
   @Override
   public Date convert(String source) {
      // 将日期串转换成日期格式（格式是yyyy-MM-dd）
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
         //返回上述格式的Date类型对象
         return simpleDateFormat.parse(source);
      } catch (Exception e) {
    	  System.out.println("異常");
    	  e.printStackTrace();
      }
      return null;
   }
}