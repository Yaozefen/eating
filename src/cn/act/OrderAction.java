package cn.act;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.DishDao;
import cn.dao.OrderDao;
import cn.model.Orders;

public class OrderAction{
	
	//action�಻���в���
	Orders orders;		//��ŵ�����������
	private String content;
	Map<Integer, ArrayList<Orders>> orderMap;	//������ж�������

	//��ѯ���ж�����Ϣ
	public String orderQueryAll() {
		OrderDao orderDao = new OrderDao();
		orderMap = orderDao.queryAllOrders();
		return "orderMap";
	}
	//��ѯ����ɻ��ߴ���ɶ���
	
	public String queryCompleted(){
		OrderDao orderDao = new OrderDao();
		orderMap = orderDao.queryCompleteOrders(content);
		return "orderMap";
	}
	//���ݶ�������ʾ������������
	public String queryByOrder() {
		OrderDao orderDao = new OrderDao();
		orderMap = orderDao.queryOrder(content);
		
		return "orderMap";
	}
	//ɾ������
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
