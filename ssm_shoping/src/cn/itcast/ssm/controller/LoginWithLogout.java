package cn.itcast.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginWithLogout
{
	//登陆
	@RequestMapping("/login")
	public String doLogin(HttpSession session,String username,String password) throws Exception
	{
		//在session中保存用户的身份信息
		session.setAttribute("username", username);
		//重定向到商品列表页面
		return "redirect:items/queryItems.action";
	}
	
	//退出
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) throws Exception
	{
		//清除session用户的登陆状态
		session.invalidate();
		
		//重定向到登陆页面
		return "redirect:items/queryItems.action";
	}
}
