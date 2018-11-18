package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;

public interface UserMapper
{
	//根据ID查找指定用户信息
	public User findUserById(int id) throws Exception;
	
	//根据名字查找指定用户信息
	public List<User> findUserByName(String name) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
	
	//删除用户信息
	public void deleteUser(int id) throws Exception;
}
