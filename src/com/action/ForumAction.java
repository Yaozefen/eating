package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.Dao.doDao;
import com.model.Forum;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class ForumAction extends ActionSupport{
	private Forum f;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Forum getF() {
		return f;
	}

	public void setF(Forum f) {
		this.f = f;
	}
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	//查询所有
	public String fsearch() {
		String username=(String)session.getAttribute("username");
		doDao dd = new doDao();
		Boolean a=false;
		a=dd.fsearch();
		if(a=true) {
			return "success";
		}else return "error";
	}
	//指定查询
	public String fshow() {
		String username=(String)session.getAttribute("username");
		doDao dd=new doDao();
		Boolean a=false;
		a=dd.fshow(f);
		if(a=true) {
			return "success";
		}else return "error";
	}
	//登陆
	public String login() {
		session.setAttribute("user", user);
		session.setAttribute("username",user.getUsername());
		return "success";
		
	}
	
	//添加
	/*public String fadd() {
		Boolean a=false;
		Boolean b=false;
		String username=(String)session.getAttribute("username");
		doDao dd=new doDao();
		b=dd.fadd(f, username);
		a=dd.fshow(f);
		if(a=true&&b==true) {
		return "success";
	}else return "error";
	}*/
}
