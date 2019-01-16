package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

public interface OrdersMapperCustom
{
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrdersUser() throws Exception;
	//查询订单关联查询用户使用Resultmap
	public List<Orders> findOrdersUserResultMap() throws Exception;
}
