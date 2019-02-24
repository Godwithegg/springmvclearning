package com.danhuang.mybatis.mapper;

import java.util.List;

import com.danhuang.mybatis.po.User;
import com.danhuang.mybatis.po.UserCustom;
import com.danhuang.mybatis.po.UserQueryVo;

/**
 * mapper接口，用户管理，相当于dao接口
 * @author danhuang
 *
 */
public interface UserMapper
{
	//用户信息综合查询
	List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	//用户信息综合查询总数
	int findUserCount(UserQueryVo userQueryVo) throws Exception;
	//根据id查询用户
	User findUserById(int id) throws Exception;
	//根据id查询用户信息，使用resultmap
	User findUserByIdResultMap(int id) throws Exception;
	//根据用户名查询用户列表
	List<User> findUserByName(String name) throws Exception;
	//添加用户信息
	void insertUser(User user) throws Exception;
	//删除用户信息
	void deleteUser(int id) throws Exception;
}
