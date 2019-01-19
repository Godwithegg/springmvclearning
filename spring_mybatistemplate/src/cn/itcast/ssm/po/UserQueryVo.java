package cn.itcast.ssm.po;

import java.util.List;

public class UserQueryVo
{
	//传入多个ID
	private List<Integer> ids;
		

	//包装所需要查询条件
	
	public List<Integer> getIds()
	{
		return ids;
	}

	public void setIds(List<Integer> ids)
	{
		this.ids = ids;
	}

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

	
	
}
