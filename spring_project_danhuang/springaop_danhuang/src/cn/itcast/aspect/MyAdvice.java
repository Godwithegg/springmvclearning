package cn.itcast.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice
{
	public void before()
	{
		System.out.println("这是前置对象");
	}
	public void afterReturning()
	{
		System.out.println("这是后置对象 前");
	}
	public Object round(ProceedingJoinPoint pjp) throws Throwable
	{
		Object proceed = pjp.proceed();
		System.out.println("前");
		System.out.println("环绕对象");
		System.out.println("后");
		return proceed;
	}
	public void afterException() 
	{
		System.out.println("出事了");
	}
	public void after()
	{
		System.out.println("后置通知");
	}
}
