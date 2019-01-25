package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.ItemsCustom;

/**
 * json交互的一个测试
 * @author danhuang
 *
 */
@Controller
public class JsonTest
{
	//请求json(商品信息)，输出响应json（商品信息）
	//@requestbody将请求的商品信息的json串转乘itemscustom对象
	//@responsebody将itemscustom转成json输出
	@RequestMapping("requestJson")
	public @ResponseBody ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom)
	{
		return itemsCustom;
	}
	//请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody ItemsCustom responseJson(ItemsCustom itemsCustom)
	{
		
		return itemsCustom;
	}
}
