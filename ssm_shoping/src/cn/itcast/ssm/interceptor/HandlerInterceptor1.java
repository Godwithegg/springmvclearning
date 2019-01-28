package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor1 implements HandlerInterceptor
{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公开地址（实际使用的时候将地址放在配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login.action") > 0)
		{
			//如果是登陆提交网址，放行
			return true;
		}
		//判断session
		HttpSession session = request.getSession();
		//从session中识别身份
		String username = (String) session.getAttribute("username");
		
		if(username != null)
		{
			return true;
		}
		//跳转到登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		return false;
	}

}
