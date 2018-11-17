package cn.itcast.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest
{
	public static void main(String[] args) throws Exception
	{
		PreparedStatement ps = null;
		Connection conn = null;
		
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///mybtis";
		try
		{
			conn = DriverManager.getConnection(url, "root","123456");
			ps = conn.prepareStatement("SELECT * FROM USER WHERE id=?");
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
