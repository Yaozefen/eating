package cn.act;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.enterprise.inject.New;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.DishDao;
import cn.dao.EmployeeDao;
import cn.model.Employee;

public class EmployeeAction extends ActionSupport{
	Employee employee;
	ArrayList<Employee> employeeList;
	private static final int BUFFER_SIZE = 16 * 1024;
	private String title;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String savePath;
	//根据员工号顺序自动获取可取工号,员工号可进行登录
	public String autoFind(){
		EmployeeDao dao = new EmployeeDao();
		String number = dao.search();
		int num = Integer.parseInt(number)+1;   //强转+1，获得最新可取工号
		if(number!=null){
			ServletActionContext.getRequest().setAttribute("number", num);		//向客户端发送数据
		}
		else{
			return autoFind();		//递归调用
		}
		return "addStaff";
	}
	
	//增加一条员工信息
	public String addInfo() throws Exception{
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"/"+this.getUploadFileName();
		File dstFile = new File(dstPath);
		copy(this.upload, dstFile);
		employee.setEmployeeImg(this.getUploadFileName());
		if(employee==null||employee.getUsername()==null||employee.getPassword()==null||employee.getName()==null||employee.getSex()==null||employee.getComingDate()==null||employee.getEmployeeImg()==null){
			return "error";
		}
		//找不到数据返回error一般是因为没有对象的get方法
		EmployeeDao dao = new EmployeeDao();
		boolean flag = dao.addEmployee(employee);
		if(flag){				//真即为插入成功
			ServletActionContext.getRequest().setAttribute("message","入职成功!");
			return "addStaff";
		}
		else{
			ServletActionContext.getRequest().setAttribute("message","入职失败!");
			return "addStaff";
		}
	}
	
	//删除一个员工
	public String deleteEmployee(){
		EmployeeDao dao = new EmployeeDao();
		boolean flag = dao.delete(employee);
		if(flag){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String Allemp() {
		EmployeeDao dao = new EmployeeDao();
		employeeList = dao.queryAll();
		return "employeeList";
	}
	
	//复制文件
			private void copy(File src,File dst){
				InputStream in = null;
				OutputStream out = null;
				try{
					in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
					out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
					byte[] buffer = new byte[BUFFER_SIZE];
					int len = 0;
					while((len = in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally {
					if(in!=null){
						try{
							in.close();
						}
						catch (IOException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					if(out!=null){
						try{
							out.close();
						}
						catch (IOException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				}
			}
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
}
