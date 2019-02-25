package com.danhuang.ssm.mapper;


import com.danhuang.ssm.po.User;

/**
 * mapper接口，用户管理，相当于dao接口
 * @author danhuang
 *
 */
public interface UserMapper
{
	//根据id查询用户
	User findUserById(int id) throws Exception;

}
