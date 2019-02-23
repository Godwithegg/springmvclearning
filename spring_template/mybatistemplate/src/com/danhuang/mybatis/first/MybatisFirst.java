package com.danhuang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.danhuang.mybatis.po.User;

/**
 * 入门程序
 * @author danhuang
 *
 */
public class MybatisFirst
{
	//根据id查询用户的信息，得到一条记录的结果
	@Test
	public void findUserByIdTest() throws IOException
	{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过工厂得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlsession操作数据库
		//第一个参数：映射文件中statement的id，等于命名空间+statement的id
		//第二个参数：指定和映射文件中所匹配的pa'ra'men'ter'type类型的参数
		//sqlsession.selectone结果是配置resulttype中的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
		
	}
}
