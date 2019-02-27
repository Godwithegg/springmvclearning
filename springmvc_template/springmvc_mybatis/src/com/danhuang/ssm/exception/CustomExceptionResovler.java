package com.danhuang.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author danhuang
 *
 */
public class CustomExceptionResovler implements HandlerExceptionResolver
{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{
		//handler处理器适配器要执行的handler对象（只有method
//		String message = null;
//		//解析异常类型：如果是自定义的类型就抛出该类型异常，否则抛出未知错误
//		if(ex instanceof CustomException)
//		{
//			message = ((CustomException)ex).getMessage();
//		}
//		else 
//			message = "未知错误";
		
		//上面的代码变为
		CustomException customException = null;
		if(ex instanceof CustomException)
		{
			customException = ((CustomException)ex);
		}
		else
		{
			customException = new CustomException("未知错误");
		}
		//错误信息
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		//将错误信息传到页面
		modelAndView.addObject("message",message);
		modelAndView.setViewName("error");
		
		
		return modelAndView;
	}
	
	
}
