package com.danhuang.mybatis.mapper;

import java.util.List;

import com.danhuang.mybatis.po.Orders;
import com.danhuang.mybatis.po.OrdersCustom;
import com.danhuang.mybatis.po.User;

public interface OrdersMapperCustom
{
	//查询订单关联查询用户
	List<OrdersCustom> findOrdersUser() throws Exception;
	//查询订单关联查询用户使用resultmap
	List<Orders> findOrdersUserResultMap() throws Exception;
	//查询订单关联查询用户及订单明细，使用resultmap
	List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
	//查询用户及购买的商品信息，使用resultmap
	List<User> findUserAndItemsResultMap() throws Exception;
	//查询订单关联查询用户,用户信息是延迟加载
	List<Orders> findOrdersUserLazyLoading() throws Exception;
}
