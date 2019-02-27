package com.danhuang.ssm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danhuang.ssm.po.Items;
import com.danhuang.ssm.po.ItemsCustom;
import com.danhuang.ssm.service.ItemsService;

/**
 * 商品的controller
 * @author danhuang
 *
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url是根路径+子路径
//比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController
{
	@Autowired
	private ItemsService itemsService;
	
	//商品的查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception
	{
		//测试forward后request是否可以共享
		request.getParameter("id");
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//商品信息修改页面显示
	//@RequestMapping("/editItems")
	//限制http请求方法,可以为get和post
//	@RequestMapping(value="/editItems",method= {RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception
//	{
//		//调用service根据id查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		ModelAndView modelAndView = new ModelAndView();
//		//商品信息放入model
//		modelAndView.addObject("itemsCustom", itemsCustom);
//		
//		modelAndView.setViewName("items/editItems");
//		return modelAndView;
//	}
	
	@RequestMapping(value="/editItems",method= {RequestMethod.POST,RequestMethod.GET})
	public String editItems(Model model) throws Exception
	{
		//调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		
		//通过形参中的moel将model数据传到页面。相当于modeladnview.addobject()
		model.addAttribute("itemsCustom", itemsCustom);

		return "items/editItems";
	}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request) throws Exception
	{
		//调用service更新商品信息，页面需要将商品信息传到此方法
		//....
		
		//重定向到商品列表
//		return "redirect:queryItems.action";
		//forward页面转发
		return "forward:queryItems.action";
	}
}
