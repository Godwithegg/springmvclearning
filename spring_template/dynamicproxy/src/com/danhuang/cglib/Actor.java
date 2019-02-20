package com.danhuang.cglib;
/**
 * 一个演员
 * @author danhuang
 *
 */
public class Actor
{
	/**
	 * 基本的演出
	 * @param money
	 */
	public void basicAct(float money)
	{
		System.out.println("Cglib拿到钱，开始基本表演："+money);
	}
	/**
	 * 危险的表演
	 * @param money
	 */
	public void dangerAct(float money)
	{
		System.out.println("Cglib拿到钱，开始危险表演"+money);
	}
}
