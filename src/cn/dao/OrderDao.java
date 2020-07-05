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
			//查询所有订单
			public Map<Integer, ArrayList<Orders>> queryAllOrders(){
				//不能直接实例化，要实现它的抽象接口hashMap;map = new Map()是错误的
				Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
				ArrayList<Orders> list;
				boolean flag = false;
				String sql = "select * from orders";
				this.conn = this.getConn();
				try{
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs!=null&&rs.next()){
						list = new ArrayList<Orders>(); //列表
						Orders orders = new Orders();	//一个对象
						orders.setOrderNum(rs.getInt("orderNum"));
						orders.setDishName(rs.getString("dishName"));
						orders.setPrice(rs.getFloat("price"));
						orders.setWay(rs.getString("way"));
						orders.setState(rs.getString("state"));
						orders.setOrderTime(rs.getString("orderTime"));
						
						Iterator keys = map.keySet().iterator(); 	//map对象中key集合
						while(keys.hasNext()){
						     int key = (int) keys.next();
						     if((orders.getOrderNum()).equals(key)){ 
						    	 flag = true;				//存在该key值即变量置为true
						    	 break;
						     }
						}
						if(flag==true){				//true把当前菜对象加到已有订单（即列表项）中
							map.get(rs.getInt("orderNum")).add(orders);
						}
						else{
							list.add(orders);		//否则加入一个新的列表项，即第二个订单
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
	//根据用户选取的订单查询已完成订单
			public Map<Integer, ArrayList<Orders>> queryCompleteOrders(String content){
				//不能直接实例化，要实现它的抽象接口hashMap;map = new Map()是错误的
				Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
				ArrayList<Orders> list;
				boolean flag = false;
				String sql = "select * from orders where state ='"+content+"'";
				this.conn = this.getConn();
				try{
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while(rs!=null&&rs.next()){
						list = new ArrayList<Orders>(); //列表
						Orders orders = new Orders();	//一个对象
						orders.setOrderNum(rs.getInt("orderNum"));
						orders.setDishName(rs.getString("dishName"));
						orders.setPrice(rs.getFloat("price"));
						orders.setWay(rs.getString("way"));
						orders.setState(rs.getString("state"));
						orders.setOrderTime(rs.getString("orderTime"));
						
						Iterator keys = map.keySet().iterator(); 	//map对象中key集合
						while(keys.hasNext()){
						     int key = (int) keys.next();
						     if((orders.getOrderNum()).equals(key)){ 
						    	 flag = true;				//存在该key值即变量置为true
						    	 break;
						     }
						}
						if(flag==true){				//true把当前菜对象加到已有订单（即列表项）中
							map.get(rs.getInt("orderNum")).add(orders);
						}
						else{
							list.add(orders);		//否则加入一个新的列表项，即第二个订单
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
			//根据订单号搜索订单
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
						list = new ArrayList<Orders>(); //列表
						Orders orders = new Orders();	//一个对象
						
						orders.setOrderNum(rs.getInt("orderNum"));
						orders.setDishName(rs.getString("dishName"));
						orders.setPrice(rs.getFloat("price"));
						orders.setWay(rs.getString("way"));
						orders.setState(rs.getString("state"));
						orders.setOrderTime(rs.getString("orderTime"));
						
						Iterator keys = map.keySet().iterator(); 	//map对象中key集合
						while(keys.hasNext()){
						     int key = (int) keys.next();
						     if((orders.getOrderNum()).equals(key)){ 
						    	 flag = true;				//存在该key值即变量置为true
						    	 break;
						     }
						}
						if(flag==true){				//true把当前菜对象加到已有订单（即列表项）中
							map.get(rs.getInt("orderNum")).add(orders);
						}
						else{
							list.add(orders);		//否则加入一个新的列表项，即第二个订单
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
			//删除订单
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
