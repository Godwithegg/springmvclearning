package cn.itcast.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆认证拦截器
 * @author danhuang
 *
 */
public class LoginInterceptor implements HandlerInterceptor
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
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception
	{
		//获取请求的url
		StringBuffer url = request.getRequestURL();
		//判断url是否是公开地址（实际使用时要把公开地址配置在配置文件中）
		//这里公开地址是登陆提交的地址
		if(url.indexOf("login.action") >= 0)
		{
			//如果要进行登陆提交，放行
			return true;
		}
		
		//判断session
		HttpSession session = request.getSession();
		//从session中取出用户的身份信息
		String username = (String) session.getAttribute("username");
		if(username != null)
		{
			//身份信息存在，放行
			return true;
		}
		
		//执行到这里表示前面都没有放行，表示用户身份需要认证，跳转到登陆页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
		//return false表示拦截住不执行
		//return true表示放行
		return false;
	}
	
}
