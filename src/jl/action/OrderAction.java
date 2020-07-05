package jl.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import jl.dao.OrderDao;
import jl.model.Orders;
import org.apache.struts2.ServletActionContext;

public class OrderAction extends ActionSupport {
    Orders orders;        //存放单个订单数据
    String content;
    Map<Integer, ArrayList<Orders>> orderMap;    //存放所有订单数据

    //查询所有订单
    public String orderQueryAll() {
        OrderDao orderDao = new OrderDao();
        orderMap = orderDao.queryAllOrders();
        return "orderMap";
    }

    //搜索订单
    public String orderQueryNum() {
        OrderDao orderDao = new OrderDao();
        orderMap = orderDao.queryNumOrders(orders.getOrderNum());
        return "orderMap";
    }

    //删除订单
    public String orderDelete() {
        boolean flag;
        OrderDao orderDao = new OrderDao();
        int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
        flag = orderDao.delete(id);
        if (flag) {
            orderQueryAll();
            return "success";
        } else {
            return "false";
        }

    }

    //再来一单
    public String orderAdd() {
        OrderDao dao = new OrderDao();
        boolean flag = dao.insert(orders);
        if (flag) {
            return "addsuccess";
        } else {
            return "addfail";
        }
    }

    //订单状态
    public String orderQueryState(String content) {
        OrderDao orderDao = new OrderDao();
        orderMap = orderDao.queryStateOrders(content);
        System.out.println(content);
        return "orderMap";
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<Integer, ArrayList<Orders>> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Integer, ArrayList<Orders>> orderMap) {
        this.orderMap = orderMap;
    }
}
