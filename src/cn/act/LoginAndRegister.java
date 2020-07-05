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
	//��¼����
	User user;
	Map<Integer, ArrayList<Orders>> orderMap;	//������ж�������
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	public String login(){
		if(user==null||user.getUsername()==null||user.getPassword()==null) return "error";
		UserDao userDao = new UserDao();
		User u1 = userDao.login(user.getUsername(),user.getPassword(),user.getRole());
		if(u1==null){
			request.setAttribute("message","�û������������");
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
			request.setAttribute("message","����δ��¼");
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
		if(flag){				//�漴Ϊ����ɹ�
			ServletActionContext.getRequest().setAttribute("message","ע��ɹ������¼!");
			return "index";
		}
		else{
			ServletActionContext.getRequest().setAttribute("message","���ֻ����ѱ�ע��!");
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

