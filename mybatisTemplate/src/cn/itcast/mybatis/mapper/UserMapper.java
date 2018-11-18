package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;
/**
 * 	mapper.java中的方法名和mapper.xml中的statement的id一致
	mapper.java中接口的参数类型和mapper.xml中parameterType的类型一致
	mapper.java中接口的返回类型和mapper.xml中resultType的类型一致
 * @author danhuang
 *
 */
public interface UserMapper
{
	
	//使用resultmapper查询
	public User findUserByIdResultMap(int id);
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo);
	
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	//根据用户名称查找用户列表
	public List<User> findUserByName(String name) throws Exception;
	//添加用户信息
	public void insertUser(User user) throws Exception;
	//删除用户信息
	public void deleteUser(int id) throws Exception;
	

	
/*
 * 以下是普通的DAO开发模式	
 */
//	//根据id查询用户信息
//	public User findUserById(int id) throws Exception;
//	//根据用户名称查找用户列表
//	public List<User> findUserByNmae(String name) throws Exception;
//	//添加用户信息
//	public void insertUser(User user) throws Exception;
//	//删除用户信息
//	public void deleteUser(int id) throws Exception; 
}
