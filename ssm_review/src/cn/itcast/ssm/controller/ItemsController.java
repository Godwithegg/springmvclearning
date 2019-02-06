package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;
import cn.itcast.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController
{
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(ItemsQuery itemsQuery) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQuery);
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
}
