package cn.act;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.DishDao;
import cn.dao.OrderDao;
import cn.model.Orders;

public class OrderAction{
	
	//action类不能有参数
	Orders orders;		//存放单个订单数据
	private String content;
	Map<Integer, ArrayList<Orders>> orderMap;	//存放所有订单数据

	//查询所有订单信息
	public String orderQueryAll() {
		OrderDao orderDao = new OrderDao();
		orderMap = orderDao.queryAllOrders();
		return "orderMap";
	}
	//查询已完成或者待完成订单
	
	public String queryCompleted(){
		OrderDao orderDao = new OrderDao();
		orderMap = orderDao.queryCompleteOrders(content);
		return "orderMap";
	}
	//根据订单号显示订单搜索内容
	public String queryByOrder() {
		OrderDao orderDao = new OrderDao();
		orderMap = orderDao.queryOrder(content);
		
		return "orderMap";
	}
	//删除订单
	public String deleteOrder(){
		OrderDao orderDao = new OrderDao();
		boolean flag = orderDao.delete(orders);
		if(flag){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Map<Integer, ArrayList<Orders>> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(Map<Integer, ArrayList<Orders>> orderMap) {
		this.orderMap = orderMap;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
