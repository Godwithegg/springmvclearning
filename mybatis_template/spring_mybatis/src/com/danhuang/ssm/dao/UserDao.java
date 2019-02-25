package com.danhuang.ssm.dao;

import java.util.List;
import com.danhuang.ssm.po.User;



/**
 * dao接口，用户管�?
 * @author danhuang
 *
 */
public interface UserDao
{
	//根据id查询用户信息
	User findUserById(int id) throws Exception;
}
