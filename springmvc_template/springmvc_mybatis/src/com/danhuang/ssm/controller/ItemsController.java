package com.danhuang.ssm.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.danhuang.ssm.controller.validation.ValidGroup1;
import com.danhuang.ssm.controller.validation.ValidGroup2;
import com.danhuang.ssm.exception.CustomException;
import com.danhuang.ssm.po.Items;
import com.danhuang.ssm.po.ItemsCustom;
import com.danhuang.ssm.po.ItemsQueryVo;
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
	
	//商品分类
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes()
	{
		Map<String, String> itemTypes = new HashMap<>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");
		return itemTypes;
	}
	
	//商品的查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
	{
		//测试forward后request是否可以共享
		request.getParameter("id");
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
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
	//@RequestParam里边指定request传入参数名称和形参进行绑定
	//required要求指定参数必须要传入
	//defaultValue可以设置默认值，如果id没有传入，将默认值和形参绑定
	public String editItems(Model model,@RequestParam(value= "id") Integer items_id) throws Exception
	{
		//调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		
		//判断商品是否为空，，根据id没有查找到商品，抛出异常，提示商品用户信息不存在
		if(itemsCustom == null)
		{
			throw new CustomException("商品信息不存在");
		}
		
		//通过形参中的moel将model数据传到页面。相当于modeladnview.addobject()
		model.addAttribute("items", itemsCustom);

		return "items/editItems";
	}
	
	//商品信息修改提交
	//在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult bindingResult接收校验出错信息
	//注意：@Validated和BindingResult bindingResult是配对出现，而且@Validated是在BindingResult的前面
	//@ModelAttribute可以指定pojo回显到页面在request中的key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,@ModelAttribute("items") @Validated(value= {ValidGroup1.class,ValidGroup2.class}) ItemsCustom itemsCustom,
			BindingResult bindingResult) throws Exception
	{
		//获取校验的错误信息
		if(bindingResult.hasErrors())
		{
			//输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors)
			{
				//输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			//将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			
			//可以直接使用model将提交pojo回显到页面
			model.addAttribute("items",itemsCustom);
			
			//出错重新到商品的修改页面
			return "items/editItems";
		}
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		//....
		
		//重定向到商品列表
		return "redirect:queryItems.action";
		//forward页面转发
//		return "forward:queryItems.action";
		//return "success";
	}
	
	//批量删除 商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception
	{
		//调用service来批量删除商品
		itemsService.deleteItems(items_id);
		//...
		
		return "redirect:queryItems.action";
		//return "success";
	}
	
	//批量修改商品的页面，将商品信息查询出来，然后在页面中可以编辑商品信息
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
	{
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	//批量修改商品提交
	//通过ItemsQueryVo接收批量提交商品信息，把这些商品信息存储到itemsQueryVo的itemsList中
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception
	{
		List<ItemsCustom> list = itemsQueryVo.getItemsList();
		for (ItemsCustom itemsCustom : list)
		{
			itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		}
		return "redirect:queryItems.action";
	}
}
