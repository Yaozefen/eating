package cn.act;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.dao.UserDao;
import cn.model.User;

public class UserAction extends ActionSupport{
	//修改密码操作
	User user;		//存放当前用户数据
	public String updatePw(){
		UserDao dao = new UserDao();
		boolean flag = dao.update(user);
		if(flag){
			ServletActionContext.getRequest().setAttribute("message","修改成功，请重新登录");
			return "index";
		}
		else{
			ServletActionContext.getRequest().setAttribute("message","修改失败，请重新修改");
			return "changePw";
		}
	}
	
	//删除已选择的课程
	public String deleteClassInfo(){
		UserDao dao = new UserDao();
		boolean flag = dao.delete(user);
		if(flag){
			return "class";
		}
		else{
			return "error";
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

