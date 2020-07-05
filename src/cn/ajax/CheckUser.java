package cn.ajax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.dao.DishDao;
import cn.dao.EmployeeDao;
import cn.dao.OrderDao;
import cn.dao.UserDao;
import cn.model.Dish;
import cn.model.Employee;
import cn.model.Orders;
import cn.model.User;

public class CheckUser extends ActionSupport{
	User user = new User();
	Dish dish = null;
	Employee employee = null;		//须有get（）、set（）方法，否则无法获得

	UserDao dao = new UserDao();
	DishDao dishDao = new DishDao();
	EmployeeDao employeeDao = new EmployeeDao();
	OrderDao orderDao = new OrderDao();
	private String content;			//须有get（）、set（）方法，否则无法获得
	private String tip;
	
	//注册验证
	public String registerAjax(){
		boolean flag;
		try {
			flag = dao.search(user.getUsername());
			if(flag){
				tip = "此手机号已被注册";
			}
			else{
				tip = "";
			}
		}
		catch (Exception e){
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//登录验证
	public String loginAjax(){
		boolean flag;
		try {
			flag = dao.search(user.getUsername());
			if(flag){
				tip = "";
			}
			else{
				tip = "无该用户";
			}
		}
		catch (Exception e){
			// TODO: handle exception
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	//ajax异步显示搜索内容
	public String queryByDish() {
		try{
			dish = dishDao.queryDish(content);
			if(dish!=null){
				ServletActionContext.getRequest().setAttribute("dish", dish);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}
	
	//异步查看员工信息
	public String queryByUsername() {
		try{
			employee = employeeDao.queryEmployee(content);
			if(dish!=null){
				ServletActionContext.getRequest().setAttribute("employee",employee);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}
	
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
