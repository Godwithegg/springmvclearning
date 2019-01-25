package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试拦截器1
 * @author danhuang
 *
 */
public class HandlerInterceptor1 implements HandlerInterceptor
{
	//执行handler之后完成此方法
	//应用场景：统一的异常处理，统一的日志处理
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		System.out.println("Handlerinterceptor1 aftercompletion");
	}

	//进入handler方法之后，返回modelandview之前执行
	//应用场景从modelandview出发：将公用的模型数据（比如菜单的导航），在这里传到视图，也可以这里指定统一视图
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		System.out.println("Handlerinterceptor1 posthandle");
	}

	//进入handler方法之前进行
	//用于身份认证、身份授权
	//比如身份认证，如果认证不通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception
	{
		System.out.println("Handlerinterceptor1 prehandle");
		//return false表示拦截住不执行
		//return true表示放行
		return true;
	}
	
}
