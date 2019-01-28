package cn.itcast.ssm.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,@ModelAttribute("item") @Validated ItemsCustom itemsCustom,
			BindingResult bindingResult,MultipartFile items_pic) throws Exception
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("itemsCustom", itemsCustom);
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("allErrors",allErrors);
			return "/items/editItems";
		}
		
		String originalFilename = items_pic.getOriginalFilename();
		//上传图片
		if(items_pic != null && originalFilename.length() > 0 && originalFilename != null )
		{
			String pic_path = "D:\\springmvclearning\\ssm_shoping\\image\\";
			String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			items_pic.transferTo(new File(pic_path+newFilename));
			itemsCustom.setPic(newFilename);
		}
		
		itemsService.updateItems(id, itemsCustom);
		
		return "redirect:queryItems.action";
	}
	
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception
	{
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
}
