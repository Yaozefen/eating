package cn.act;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.OrderDao;
import cn.dao.UserDao;
import cn.model.Orders;
import cn.model.User;

public class LoginAndRegister extends ActionSupport{
	//登录操作
	User user;
	Map<Integer, ArrayList<Orders>> orderMap;	//存放所有订单数据
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	public String login(){
		if(user==null||user.getUsername()==null||user.getPassword()==null) return "error";
		UserDao userDao = new UserDao();
		User u1 = userDao.login(user.getUsername(),user.getPassword(),user.getRole());
		if(u1==null){
			request.setAttribute("message","用户或者密码错误");
			return "index";
		}
		else{
			session.setAttribute("user", u1);
			session.setAttribute("username", user.getUsername());
			session.setAttribute("role", user.getRole());
			if("employer".equals(user.getRole())){
				OrderDao orderDao = new OrderDao();
				orderMap = orderDao.queryAllOrders();
				return "orderMap";
			}
			else if("user".equals(user.getRole())){
				return "query";
			}
			else{
				return "orderMap";
			}
		}
	}
	public String signOut() {
		if(session.getAttribute("user")==null){
			request.setAttribute("message","您还未登录");
			return "orderCenter";
		}
		else{
			session.removeAttribute("user");
			return "index";
		}
	}
	public String register(){
		if(user==null||user.getUsername()==null||user.getPassword()==null) return "test";
		UserDao userDao = new UserDao();
		boolean flag = userDao.register(user);
		if(flag){				//真即为插入成功
			ServletActionContext.getRequest().setAttribute("message","注册成功，请登录!");
			return "index";
		}
		else{
			ServletActionContext.getRequest().setAttribute("message","该手机号已被注册!");
			return "register";
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<Integer, ArrayList<Orders>> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(Map<Integer, ArrayList<Orders>> orderMap) {
		this.orderMap = orderMap;
	}
}

