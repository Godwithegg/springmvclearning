package cn.itcast.ssm.controller;
/**
 * controller的返回值可以是modoelandview，string或者void
 */
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import cn.itcast.ssm.controller.validation.ValidGroup1;
import cn.itcast.ssm.exception.CustomException;
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
	
	//商品分类
	//itemTypes表示最终将方法返回值放在request中的key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes()
	{
		Map<String, String> itemTypes = new HashMap<>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");
		return itemTypes;
	}
	
	
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
		//判断商品是否为空,根据id没有查询到商品，抛出异常，提示商品信息不存在
		if(itemsCustom == null)
		{
			throw new CustomException("修改的商品信息不存在");
		}
		
		//通过形参中的moel将model数据传到页面
		//相当于modelandeview.addobject
		model.addAttribute("items", itemsCustom);
		return "items/editItems";
	}
	
	//查询商品信息，输出json
	//itemsview/{id}里边的{id}表示将这个位置的参数传到pathvariable当中
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception
	{
		//调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}
	
	//商品信息修改提交
	//在需要校验的pojo前边添加@validated，在需要校验的pojo后边添加BindingResult bindingResult来接收校验出错的信息
	//注意：@validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的，一前一后
	//@ModelAttribute可以指定pojo回显到页面在request中的key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request,Integer id,
			@ModelAttribute("items") @Validated(value={ValidGroup1.class}) ItemsCustom itemsCustom,
			BindingResult bindingResult,MultipartFile items_pic//接收商品的图片
			) throws Exception
	{                             
		//获取校验错误信息
		if(bindingResult.hasErrors())
		{
			//输出错误信息
			 List<ObjectError> allErrors = bindingResult.getAllErrors();
			 System.out.println(allErrors.size());
			 for (ObjectError objectError : allErrors)
			{
				//输出错误信息
				 System.out.println(objectError.getDefaultMessage());
			}
			 model.addAttribute("allErrors", allErrors);
			 //出错重新回到编辑页面
			 
			 //model.addAttribute("id", id);
			 
			 //@ModelAttribute如果不用这个的话就用下面这个进行回显
			 model.addAttribute("items",itemsCustom);
			 return "items/editItems";
		}
		//原始名称
		String originalFilename = items_pic.getOriginalFilename();
		System.out.println(originalFilename);
		//上传图片
		if(items_pic != null && originalFilename.length()>0 && originalFilename != null)
		{
			//存储图片的物理路径
			String pic_path = "D:\\springmvclearning\\springmvc_mybatis\\image\\";
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(pic_path+newFileName);
			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);
			//将新的图片名称写到itemsCustom中
			itemsCustom.setPic(newFileName);
		}
		
		//调用service更新商品信息，页面需要将商品信息传到此方法
		itemsService.updateItems(id, itemsCustom);
		//重定向到商品查询的页面
		//return "redirect:queryItems.action";
		//页面转发
		//return "forward:queryItems.action";
		return "redirect:queryItems.action";
		
	}
	
	//由于有外键约束，因此不能进行删除
	//批量删除 商品信息
	@RequestMapping("/deleteItems")
	public String deleteItemsSubmit(Integer[] items_id) throws Exception
	{
		//调用service批量删除商品
		//itemsService.d
	
		for (int pids : items_id)
		{
			itemsService.deleteItems(pids);
		}
		
		
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
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo,BindingResult bindingResult) throws Exception
	{

		List<ItemsCustom> list = itemsQueryVo.getItemsList();
		for(ItemsCustom itemsCustom : list)
		{
			itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		}
		return "redirect:queryItems.action";
	}
	
}
