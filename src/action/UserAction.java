package action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserinfoDao;
import model.UserInfo;

public class UserAction extends ActionSupport{
	UserInfo user;
	private File doc;
	private String docFileName;
    private String docContentType;
    private String address;
    
	public File getDoc() {
		return doc;
	}
	public void setDoc(File doc) {
		this.doc = doc;
	}
	public String getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}
	public String getDocContentType() {
		return docContentType;
	}
	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	
	//个人信息查询
	public String queryUser() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession sess= request.getSession();
		String userId = (String) sess.getAttribute("username");
		UserinfoDao dao = new UserinfoDao();
		/*String id = ServletActionContext.getRequest().getParameter("id");*/
		UserInfo user = dao.queryUser(userId);
		if(user == null) {
			return "qufail";
		}else {
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("user", user);
			return "success";
		}
	}

	//个人信息修改
	public String updateUser() {
		UserinfoDao dao = new UserinfoDao();
		String id = ServletActionContext.getRequest().getParameter("id");
		boolean flag = dao.updateUser(id, user);
		if(flag) {
			return "update";
		}else {
			return "upfail";
		}	
	}
	
	//修改头像
	public String updateImg() throws IOException {
		String contextPath = ServletActionContext.getServletContext().getRealPath("/img");
	    File destFile = new File(contextPath, docFileName);
	    String destFilePath = destFile.getPath();
	    String realPath = ServletActionContext.getServletContext().getRealPath("/img");
	    address = destFilePath.substring(realPath.length());
	    FileUtils.copyFile(doc, destFile);
	    UserinfoDao dao = new UserinfoDao();
		boolean flag = dao.updateImg(address, user.getUserImg());
		if(flag) {
			return "update";
		}else {
			return "upfail";
		}	
	}
	
}
