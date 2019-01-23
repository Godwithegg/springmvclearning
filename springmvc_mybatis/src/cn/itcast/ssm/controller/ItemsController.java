package cn.itcast.ssm.controller;
/**
 * controller的返回值可以是modoelandview，string或者void
 */
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

/**
 * 商品的controller
 * @author danhuang
 *
 */
@Controller
//为了对url进行分类管理，可以在这里定义根路径，最终访问url时根路径+子路径
//访问地址为/items/queryItems.action
@RequestMapping("/items")
public class ItemsController
{
	@Autowired
	private ItemsService itemsService;
	
	//商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
	{
		//测试forward后request是否可以共享
		System.out.println(request.getParameter("id"));
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	
	//商品信息修改页面显示
	//@RequestMapping("/editItems")//requestmapping有三个方法，url映射，窄化映射，限制请求方式
	//限制http请求方法
//	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
//	public ModelAndView editItems() throws Exception
//	{
//		//调用service根据id查询商品信息
//		ItemsCustom itemsCustom = itemsService.findItemsById(1);
//		
//		
//		ModelAndView modelAndView = new ModelAndView();
//		//将商品信息放到model
//		modelAndView.addObject("itemsCustom",itemsCustom);
//		modelAndView.setViewName("/items/editItems");
//		return modelAndView;
//	}
	
	//如果不使用@requestparam，要求request传入参数名称和controllercan方法形参名称一致
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	//通过required指定这个参数是否必须传入，如果true而没用传入那么会报错
	public String editItems(Model model,@RequestParam(value="id",required=true) Integer items_id) throws Exception
	{
		//调用service根据id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		
		//通过形参中的moel将model数据传到页面
		//相当于modelandeview.addobject
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}
	
	//商品信息修改提交
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,Integer id,ItemsCustom itemsCustom) throws Exception
	{
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		//重定向到商品查询的页面
		//return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
		return "forward:queryItems.action";
	}
	
	//批量删除 商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception
	{
		//调用service批量删除商品
		//itemsService.d
	
		for (Integer pids : items_id)
		{
			itemsService.deleteItems(pids);
		}
		//删除这部分不能实现，不知道为什么
		
		return "success";
	}
	
	//批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception
	{
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	
	//批量修改商品提交
	//通过ItemsQueryVo接收批量提交的商品信息，将商品信息存储到ItemsQuery中itemsList属性中。
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception
	{
		List<ItemsCustom> list = itemsQueryVo.getItemsList();
		for(ItemsCustom itemsCustom : list)
		{
			itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		}
		return "redirect:queryItems.action";
	}
	
}
