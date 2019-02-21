package com.danhuang.dao;

import com.danhuang.domain.Test;

/**
 * Test表的持久层接口
 * @author danhuang
 *
 */
public interface TestDao
{
	/**
	 * 根据id查询账户信息
	 * @param testId
	 * @return
	 */
	Test findTestById(Integer testId);
	
	/**
	 * 根据名称查询账户信息
	 * @param name
	 * @return	要求：账户名称必须唯一，如果不唯一应该抛异常
	 */
	Test findTestByName(String name);
	
	/**
	 * 更新账户信息
	 * @param test
	 */
	void updateTest(Test test);
}
