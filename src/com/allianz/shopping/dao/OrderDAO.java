package com.allianz.shopping.dao;

import java.util.List;

import com.allianz.shopping.model.Order;

public interface OrderDAO 
{
	public int addOrder(Order o);
	public List<Order> getAllOrder();
	Order getOrderById(int order_id);
}
