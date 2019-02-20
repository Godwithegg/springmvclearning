package cn.danhuang.test;

import java.sql.Connection;

import cn.danhuang.dataSource.MyDataSource;

/**
 * 如果使用mysql5.1.7会失败,要用5.0.8之类的老版本
 * 功能：使用动态代理实现数据库连接关闭之后仍然在池中
 * @author danhuang
 *
 */
public class DataSourceTest
{
	public static void main(String[] args) throws Exception
	{
		int size = MyDataSource.getPoolSize();
		System.out.println("使用连接之前:"+size);
		Connection conn = MyDataSource.getConnection();
		System.out.println(conn);
		conn.close();
		int size1 = MyDataSource.getPoolSize();
		System.out.println("使用连接之后:"+size1);           
	}
}
