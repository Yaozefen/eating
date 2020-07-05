package cn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.model.Dish;
import cn.model.Orders;

public class OrderDao extends BaseDao{
			//��ѯ���ж���
			public Map<Integer, ArrayList<Orders>> queryAllOrders(){
				//����ֱ��ʵ������Ҫʵ�����ĳ���ӿ�hashMap;map = new Map()�Ǵ����
				Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
				ArrayList<Orders> list;
				boolean flag = false;
				String sql = "select * from orders";
				this.conn = this.getConn();
				try{
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs!=null&&rs.next()){
						list = new ArrayList<Orders>(); //�б�
						Orders orders = new Orders();	//һ������
						orders.setOrderNum(rs.getInt("orderNum"));
						orders.setDishName(rs.getString("dishName"));
						orders.setPrice(rs.getFloat("price"));
						orders.setWay(rs.getString("way"));
						orders.setState(rs.getString("state"));
						orders.setOrderTime(rs.getString("orderTime"));
						
						Iterator keys = map.keySet().iterator(); 	//map������key����
						while(keys.hasNext()){
						     int key = (int) keys.next();
						     if((orders.getOrderNum()).equals(key)){ 
						    	 flag = true;				//���ڸ�keyֵ��������Ϊtrue
						    	 break;
						     }
						}
						if(flag==true){				//true�ѵ�ǰ�˶���ӵ����ж��������б����
							map.get(rs.getInt("orderNum")).add(orders);
						}
						else{
							list.add(orders);		//�������һ���µ��б�����ڶ�������
							map.put(rs.getInt("orderNum"), list);
						}
						flag = false;
					}
					if(rs!=null){
						rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					this.closeConn();
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return map;
			}
	//�����û�ѡȡ�Ķ�����ѯ����ɶ���
			public Map<Integer, ArrayList<Orders>> queryCompleteOrders(String content){
				//����ֱ��ʵ������Ҫʵ�����ĳ���ӿ�hashMap;map = new Map()�Ǵ����
				Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
				ArrayList<Orders> list;
				boolean flag = false;
				String sql = "select * from orders where state ='"+content+"'";
				this.conn = this.getConn();
				try{
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs!=null&&rs.next()){
						list = new ArrayList<Orders>(); //�б�
						Orders orders = new Orders();	//һ������
						orders.setOrderNum(rs.getInt("orderNum"));
						orders.setDishName(rs.getString("dishName"));
						orders.setPrice(rs.getFloat("price"));
						orders.setWay(rs.getString("way"));
						orders.setState(rs.getString("state"));
						orders.setOrderTime(rs.getString("orderTime"));
						
						Iterator keys = map.keySet().iterator(); 	//map������key����
						while(keys.hasNext()){
						     int key = (int) keys.next();
						     if((orders.getOrderNum()).equals(key)){ 
						    	 flag = true;				//���ڸ�keyֵ��������Ϊtrue
						    	 break;
						     }
						}
						if(flag==true){				//true�ѵ�ǰ�˶���ӵ����ж��������б����
							map.get(rs.getInt("orderNum")).add(orders);
						}
						else{
							list.add(orders);		//�������һ���µ��б�����ڶ�������
							map.put(rs.getInt("orderNum"), list);
						}
						flag = false;
					}
					if(rs!=null){
						rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					this.closeConn();
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return map;
			}
			//���ݶ�������������
			public Map<Integer, ArrayList<Orders>> queryOrder(String content) {
				Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
				ArrayList<Orders> list;
				boolean flag = false;
				String sql = "select * from orders where orderNum like '%"+content+"%'";
				this.conn = this.getConn();
				try{
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs!=null&&rs.next()){
						list = new ArrayList<Orders>(); //�б�
						Orders orders = new Orders();	//һ������
						
						orders.setOrderNum(rs.getInt("orderNum"));
						orders.setDishName(rs.getString("dishName"));
						orders.setPrice(rs.getFloat("price"));
						orders.setWay(rs.getString("way"));
						orders.setState(rs.getString("state"));
						orders.setOrderTime(rs.getString("orderTime"));
						
						Iterator keys = map.keySet().iterator(); 	//map������key����
						while(keys.hasNext()){
						     int key = (int) keys.next();
						     if((orders.getOrderNum()).equals(key)){ 
						    	 flag = true;				//���ڸ�keyֵ��������Ϊtrue
						    	 break;
						     }
						}
						if(flag==true){				//true�ѵ�ǰ�˶���ӵ����ж��������б����
							map.get(rs.getInt("orderNum")).add(orders);
						}
						else{
							list.add(orders);		//�������һ���µ��б�����ڶ�������
							map.put(rs.getInt("orderNum"), list);
						}
						flag = false;
					}
					if(rs!=null){
						rs.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					this.closeConn();
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return map;
			}
			//ɾ������
			public boolean delete(Orders orders){
				boolean flag = false;
				this.conn = getConn();
				this.stmt = getStmt();
				String sql = "delete from orders where orderNum = "+orders.getOrderNum();
				try{
					int num = stmt.executeUpdate(sql);
					if(num==1){
						flag = true;
					}
				}
				catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return flag;
			}
}
