package com.danhuang.ssm.controller;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.danhuang.ssm.po.Items;

/**
 * 注解的handler
 * @author danhuang
 *
 */
//使用controller标识它是一个控制器
@Controller
public class ItemsController3
{
	//商品查询列表
	//@requestmapping实现对queryItems和url进行映射
	//一般建议url和方法名写的一样
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception
	{
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<>();
		//向List中填充静态数据
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		itemsList.add(items_1);
		itemsList.add(items_2);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		return modelAndView;
	}
	
	//定义其他方法
	//商品添加
	//商品修改


}
