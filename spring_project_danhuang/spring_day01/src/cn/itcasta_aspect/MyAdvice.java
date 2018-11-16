package cn.itcasta_aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice
{
	public void before()
	{
		System.out.println("这是前置通知");
	}
	public void afterReturning()
	{
		System.out.println("这是后置通知 前面");
	}
	public Object round(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("环绕通知前");
		Object proceed = pjp.proceed();
		System.out.println("环绕通知后");
		return proceed;
	}
	public void afterException()
	{
		System.out.println("出事了");
	}
	public void after()
	{
		System.out.println("这是后置通知");
	}
}
