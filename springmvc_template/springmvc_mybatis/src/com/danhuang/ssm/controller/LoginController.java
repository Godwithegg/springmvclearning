package com.danhuang.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController
{
	//登录
	@RequestMapping("/login")
	public String login(HttpSession session,String username,String password) throws Exception
	{
		//调用service进行身份认证
	
		//在session保存用户身份的信息
		session.setAttribute("username", username);
		//重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}
	
	//退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception
	{
		//清除session
		session.invalidate();
		
		//重定向到商品列表页面
		return "redirect:/items/queryItems.action";
	}
}
