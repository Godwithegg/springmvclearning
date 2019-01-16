package cn.itcast.mybatis.po;

/**
 * order订单的扩展类
 * @author danhuang
 *
 */
public class OrdersCustom extends Orders
{
	private String username;
	private String sex;
	private String address;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{  
		this.address = address;
	}
	
}
