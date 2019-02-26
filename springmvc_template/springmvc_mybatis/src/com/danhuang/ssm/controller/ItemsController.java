package com.danhuang.ssm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class ItemsController
{
	@Autowired
	private ItemsService itemsService;
	
	//商品的查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception
	{
		List<ItemsCustom> itemsList = itemsService.findItemsList(null);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
}
