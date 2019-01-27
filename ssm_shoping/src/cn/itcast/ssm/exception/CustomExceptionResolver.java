package cn.itcast.ssm.exception;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* 项目名称：ssm_shoping 
* 类名称：CustomExceptionResolver 
* 类描述：全局异常处理，只要实现HandlerExceptionresolver即可 
* 创建人：林灿煌
* 创建时间：2019年1月28日 上午1:44:00 
* @version
 */
public class CustomExceptionResolver implements HandlerExceptionResolver
{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	{
		CustomException customException = null;
		if(ex instanceof CustomException)
		{
			customException = (CustomException)ex;
		}
		else customException = new CustomException("未知错误");
		//错误信息
		String message = customException.getMessage();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		return modelAndView;
	}

	
	

}
