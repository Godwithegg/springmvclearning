package cn.itcast.service;

public class UserServiceImpl implements UserService
{

	@Override
	public void save()
	{
		System.out.println("保存事务");
	}

	@Override
	public void update()
	{
		System.out.println("修改事务");
	}

	@Override
	public void find()
	{
		System.out.println("查找事务");
	}

	@Override
	public void insert()
	{
		System.out.println("插入事务");
	}

}
