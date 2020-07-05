package jl.dao;

import jl.model.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OrderDao extends BaseDao {
    //查询所有订单
    public Map<Integer, ArrayList<Orders>> queryAllOrders() {
        //不能直接实例化，要实现它的抽象接口hashMap;map = new Map()是错误的
        Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
        ArrayList<Orders> list;
        boolean flag = false;
        String sql = "select * from myorder";
        this.conn = this.getConn();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs != null && rs.next()) {
                list = new ArrayList<Orders>(); //列表
                Orders orders = new Orders();    //一个对象

                orders.setOrderNum(rs.getInt("orderNum"));
                orders.setUsername(rs.getString("username"));
                orders.setDishName(rs.getString("dishName"));
                orders.setPrice(rs.getFloat("price"));
                orders.setWay(rs.getString("way"));
                orders.setState(rs.getString("state"));
                orders.setOrderTime(rs.getDate("orderTime"));

                Iterator keys = map.keySet().iterator();    //map对象中key集合
                while (keys.hasNext()) {
                    int key = (int) keys.next();
                    if ((orders.getOrderNum()) == (key)) {
                        flag = true;                //存在该key值即变量置为true
                    }
                }
                if (flag == true) {                //true把当前菜对象加到已有订单（即列表项）中
                    map.get(rs.getInt("orderNum")).add(orders);
                } else {
                    list.add(orders);        //否则加入一个新的列表项，即第二个订单
                    map.put(rs.getInt("orderNum"), list);
                }
                flag = false;
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            this.closeConn();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return map;
    }

    //搜索订单
    public Map<Integer, ArrayList<Orders>> queryNumOrders(int orderNum) {
        //不能直接实例化，要实现它的抽象接口hashMap;map = new Map()是错误的
        Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
        ArrayList<Orders> list;
        boolean flag = false;
        System.out.println(orderNum);
        String sql = "select * from myorder where orderNum='" + orderNum + "'";
        this.conn = this.getConn();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs != null && rs.next()) {
                list = new ArrayList<Orders>(); //列表
                Orders orders = new Orders();    //一个对象

                orders.setOrderNum(rs.getInt("orderNum"));
                orders.setUsername(rs.getString("username"));
                orders.setDishName(rs.getString("dishName"));
                orders.setPrice(rs.getFloat("price"));
                orders.setWay(rs.getString("way"));
                orders.setState(rs.getString("state"));
                orders.setOrderTime(rs.getDate("orderTime"));

                Iterator keys = map.keySet().iterator();    //map对象中key集合
                while (keys.hasNext()) {
                    int key = (int) keys.next();
                    if ((orders.getOrderNum()) == (key)) {
                        flag = true;                //存在该key值即变量置为true
                    }
                }
                if (flag == true) {                //true把当前菜对象加到已有订单（即列表项）中
                    map.get(rs.getInt("orderNum")).add(orders);
                } else {
                    list.add(orders);        //否则加入一个新的列表项，即第二个订单
                    map.put(rs.getInt("orderNum"), list);
                }
                flag = false;
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            this.closeConn();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return map;
    }

    //删除订单
    public boolean delete(int OrderNum) {
        boolean flag = false;
        this.conn = this.getConn();
        String sql = "delete from myorder where orderNum =?";

        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1, OrderNum);
            int num = this.pstmt.executeUpdate();
            if (num == 1) {
                flag = true;
            }

            if (this.pstmt != null) {
                this.pstmt.close();
            }

            if (this.conn != null) {
                this.conn.close();
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        return flag;
    }

    //再来一单
    public boolean insert(Orders orders) {
        boolean flag = false;
        this.conn = getConn();
        this.stmt = getStmt();
        String sql = "insert into myorder(dishName,price,way,state) values('" + orders.getDishName() + "','" + orders.getPrice() + "','" + orders.getWay() + "','" + orders.getState() + "')";
        try {
            int i = stmt.executeUpdate(sql);
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    //订单状态
    public Map<Integer, ArrayList<Orders>> queryStateOrders(String content) {
        //不能直接实例化，要实现它的抽象接口hashMap;map = new Map()是错误的
        Map<Integer, ArrayList<Orders>> map = new HashMap<Integer, ArrayList<Orders>>();
        ArrayList<Orders> list;
        boolean flag = false;
        System.out.println(content);
        String sql = "select * from myorder where state='" + content + "'";
        this.conn = this.getConn();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs != null && rs.next()) {
                list = new ArrayList<Orders>(); //列表
                Orders orders = new Orders();    //一个对象

                orders.setOrderNum(rs.getInt("orderNum"));
                orders.setUsername(rs.getString("username"));
                orders.setDishName(rs.getString("dishName"));
                orders.setPrice(rs.getFloat("price"));
                orders.setWay(rs.getString("way"));
                orders.setState(rs.getString("state"));
                orders.setOrderTime(rs.getDate("orderTime"));

                Iterator keys = map.keySet().iterator();    //map对象中key集合
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    if ((orders.getState()) == (key)) {
                        flag = true;                //存在该key值即变量置为true
                    }
                }
                if (flag == true) {                //true把当前菜对象加到已有订单（即列表项）中
                    map.get(rs.getString("state")).add(orders);
                } else {
                    list.add(orders);        //否则加入一个新的列表项，即第二个订单
                    map.put(rs.getInt("state"), list);
                }
                flag = false;
            }
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            this.closeConn();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return map;
    }

}
