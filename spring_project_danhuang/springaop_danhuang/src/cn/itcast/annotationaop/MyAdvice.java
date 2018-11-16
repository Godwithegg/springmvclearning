package cn.itcast.annotationaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect 
public class MyAdvice
{
	@Pointcut("execution(* cn.itcast.service.*ServiceImpl.*(..))")
	public void pc() {}
	
	
	@Before("MyAdvice.pc()")
	public void before()
	{
		System.out.println("这是前置对象");
	}
	@AfterReturning("execution(* cn.itcast.service.*ServiceImpl.*(..))")
	public void afterReturning()
	{
		System.out.println("这是后置对象 前");
	}
	@Around("execution(* cn.itcast.service.*ServiceImpl.*(..))")
	public Object round(ProceedingJoinPoint pjp) throws Throwable
	{
		Object proceed = pjp.proceed();
		System.out.println("前");
		System.out.println("环绕对象");
		System.out.println("后");
		return proceed;
	}
	@AfterThrowing("execution(* cn.itcast.service.*ServiceImpl.*(..))")
	public void afterException() 
	{
		System.out.println("出事了");
	}
	@After("execution(* cn.itcast.service.*ServiceImpl.*(..))")
	public void after()
	{
		System.out.println("后置通知");
	}
}
