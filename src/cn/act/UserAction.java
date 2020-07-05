package cn.act;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.dao.UserDao;
import cn.model.User;

public class UserAction extends ActionSupport{
	//�޸��������
	User user;		//��ŵ�ǰ�û�����
	public String updatePw(){
		UserDao dao = new UserDao();
		boolean flag = dao.update(user);
		if(flag){
			ServletActionContext.getRequest().setAttribute("message","�޸ĳɹ��������µ�¼");
			return "index";
		}
		else{
			ServletActionContext.getRequest().setAttribute("message","�޸�ʧ�ܣ��������޸�");
			return "changePw";
		}
	}
	
	//ɾ����ѡ��Ŀγ�
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

