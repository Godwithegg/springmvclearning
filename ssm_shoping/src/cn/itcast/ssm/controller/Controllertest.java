package cn.itcast.ssm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.service.impl.ItemsServiceImpl;

/**
 * 
* 项目名称：ssm_shoping 
* 类名称：Controller 
* 类描述： 
* 创建人：林灿煌
* 创建时间：2019年1月27日 下午12:37:04 
* @version
 */

@Controller
public class Controllertest 
{
	@Autowired
	private ItemsService ItemsService;
	
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception
	{
		List<ItemsCustom> itemsList = ItemsService.findItemsList(null);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
}
