package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.Dao.AllactiveDao;
import com.model.Addr;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class Allaction extends ActionSupport{
	private Addr ad;
	private User user;
	
	public Addr getAd() {
		return ad;
	}

	public void setAd(Addr ad) {
		this.ad = ad;
	}
	
	 public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	HttpServletRequest request=ServletActionContext.getRequest();
	 HttpSession session=request.getSession();
	AllactiveDao db=new AllactiveDao();
	
	public String addaddr() {
		Boolean a=false;
		Boolean b=false;
		String username=(String)session.getAttribute("username");
		b=db.AddAddr(ad,username);
		a=db.search(ad,username);
		if(a=true) {
			return "success";
		}else return "error";
		
		
	}
	
	//��ȡ��������
	public String search() {
		Boolean a=false;
		String username=(String)session.getAttribute("username");
		a=db.search(ad,username);
		System.out.println("1111111111111111111111111111111111111111");
		if(a=true) {
			return "success";
		}else {return "error";}
	
		
	}
	public String login() {
		session.setAttribute("user", user);
		session.setAttribute("username", user.getUsername());
		return SUCCESS;
	}
	
	//ɾ��
	public String delete() {
		String username=(String)session.getAttribute("username");
		Boolean a=false;
		db.deleteAddr(ad);
		a=db.search(ad,username);
		if(a=true) {
			return "success";
		}else {return "error";}
	}
	//ģ����ѯ 
	public String likesearch() {
		String username=(String)session.getAttribute("username");
		Boolean a=false;
		/*System.out.println(ad.getKeyword()+"      likesearch");*/
		a=db.likesearch(ad,username);
		if(a=true) {
			return "success";
		}else return "error";
	}
	
	public String modify() {
		Boolean a=false;
		System.out.println(ad.getCellphone()+"   modifyaction");
		ad=db.Modify2(ad);
		session.setAttribute("ad", ad);
		return SUCCESS;
	}
	
	public String update() {
		Boolean a=false;
		String username=(String)session.getAttribute("username");
		a=db.modify(ad, username);
		db.search(ad,username);
		if(a=true) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	
}
