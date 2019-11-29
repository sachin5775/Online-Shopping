package com.allianz.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DBUtilityConnection;
import com.allianz.shopping.utility.DateUtility;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int addOrder(Order o) {
		int orderID = 0;
		Connection con = DBUtilityConnection.getConnection();
		String sql;

		try {
			sql = "INSERT INTO orders(Order_Date,Status,Username,Total_Price) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, DateUtility.convertUtilDateToSQLDate(o.getDate()));
			ps.setString(2, o.getOredr_status());
			ps.setString(3, o.getUserName());
			ps.setFloat(4, o.getPrice());
			int no = ps.executeUpdate();
			if (no > 0)

			{
				try (ResultSet generateKeys = ps.getGeneratedKeys()) {
					if (generateKeys.next()) {
						orderID = generateKeys.getInt(1);
						System.out.println(orderID);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderID;
	}

	@Override
	public List<Order> getAllOrder() {
		AddToCartDAO addToCartDAO = new AddToCartDAOimpl();
		List<Order> orderList = new ArrayList<Order>();
		Connection con = DBUtilityConnection.getConnection();
		String sql;
		
		try {
			sql = "select * from orders"; 
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("list of orders");
			while(rs.next()) {
				Order order = new Order();
				order.setOrder_id(rs.getInt(1));
				order.setDate(rs.getDate(2));
				order.setOredr_status(rs.getString(3));
				order.setUserName(rs.getString(4));
				order.setPrice(rs.getFloat(5));
				order.setAddToCartsList(addToCartDAO.getAddToCartByOrderId(order.getOrder_id()));
				orderList.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public Order getOrderById(int order_id) {
		AddToCartDAO addToCartDAO = new AddToCartDAOimpl();
		Connection con = DBUtilityConnection.getConnection();
		String sql;

		try {
			sql = "select * from orders where Order_Id = ? ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, order_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setOrder_id(rs.getInt(1));
				order.setDate(rs.getDate(2));
				order.setOredr_status(rs.getString(3));
				order.setUserName(rs.getString(4));
				order.setPrice(rs.getFloat(5));
				order.setAddToCartsList(addToCartDAO.getAddToCartByOrderId(order.getOrder_id()));
				return order;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
