package com.danhuang.mybatis.po;

/**
 * 用户包装类型
 * @author danhuang
 *
 */
public class UserQueryVo
{
	//在这里包装所需要的查询条件
	
	//用户查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom()
	{
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom)
	{
		this.userCustom = userCustom;
	}
	
	//可以包装其他查询条件，订单，商品...
}
