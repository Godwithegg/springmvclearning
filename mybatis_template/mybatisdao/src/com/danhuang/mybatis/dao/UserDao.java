package com.danhuang.mybatis.dao;

import java.util.List;

import com.danhuang.mybatis.po.User;

/**
 * dao接口，用户管理
 * @author danhuang
 *
 */
public interface UserDao
{
	//根据id查询用户信息
	User findUserById(int id) throws Exception;
	//根据用户名查询用户列表
	List<User> findUserByName(String name) throws Exception;
	//添加用户信息
	void insertUser(User user) throws Exception;
	//删除用户信息
	void deleteUser(int id) throws Exception;
}
