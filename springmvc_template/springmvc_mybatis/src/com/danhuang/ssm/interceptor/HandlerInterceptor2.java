package com.danhuang.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor
{
	//进入Handler方法之前执行
	//用于身份认证、身份授权
	//比如身份认证，如果认证不通过标表示当前用户没有登录，需要此方法拦截不再想下执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{

		//System.out.println("handler2pre");
		return true;
	}
	
	//进入Handler方法之后，返回modelAndView之前执行
	//应用场景从modelAndView出发：将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里指定统一视图
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception
	{
		//System.out.println("handler2post");
		
	}

	//执行Handler完成后执行此方法
	//应用场景：统一的异常处理，统一日志处理
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{
		//System.out.println("handler2after");
	}

}
