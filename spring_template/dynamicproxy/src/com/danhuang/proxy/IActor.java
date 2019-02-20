package com.danhuang.proxy;

/**
 * 经济公司对签约艺人的标准
 * @author danhuang
 *
 */
public interface IActor
{
	/**
	 * 基本的演出
	 */
	public void basicAct(float money);
	/**
	 * 危险的演出
	 */
	public void dangerAct(float money);
}
