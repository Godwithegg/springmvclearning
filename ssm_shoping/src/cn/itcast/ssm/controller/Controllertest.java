package cn.itcast.ssm.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;
import cn.itcast.ssm.service.ItemsService;
import cn.itcast.ssm.service.impl.ItemsServiceImpl;


@Controller
@RequestMapping("/items")
public class Controllertest 
{
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest httpServletRequest,ItemsQuery itemsQuery) throws Exception
	{
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQuery);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	@RequestMapping("/editItems")
	public String editItems(Model model,Integer id) throws Exception
	{
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		model.addAttribute("item", itemsCustom);
		return "/items/editItems";
	}
	
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,@ModelAttribute("item") @Validated ItemsCustom itemsCustom,BindingResult bindingResult) throws Exception
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("itemsCustom", itemsCustom);
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors",allErrors);
			return "/items/editItems";
		}
		
		itemsService.updateItems(id, itemsCustom);
		
		return "redirect:queryItems.action";
	}
}
