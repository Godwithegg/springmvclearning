package com.danhuang.mybatis.mapper;

import java.util.List;

import com.danhuang.mybatis.po.Orders;
import com.danhuang.mybatis.po.OrdersCustom;

public interface OrdersMapperCustom
{
	//查询订单关联查询用户
	List<OrdersCustom> findOrdersUser() throws Exception;
	//查询订单关联查询用户使用resultmap
	List<Orders> findOrdersUserResultMap() throws Exception;
}
