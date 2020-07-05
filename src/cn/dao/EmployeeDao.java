package cn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import cn.model.Dish;
import cn.model.Employee;
import cn.model.User;

public class EmployeeDao extends BaseDao{
	//查询最新可取工号
	public String search(){
		String number = null;
		String sql = "select max(username) from user where role = 'employee'";
		this.conn = getConn();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs!=null&&rs.next()){
				number = rs.getString(1);
			}
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			this.closeConn();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return number;
	}
	
	//根据账号查询员工信息
	public Employee queryEmployee(String content) {
		Employee employee = null;
		boolean flag = false;
		this.conn = getConn();
		this.stmt = getStmt();
		String sql = "select * from employeeinfo where username like '%"+content+"%' or name like '%"+content+"%'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs!=null &&rs.next()){
				employee = new Employee();
				employee.setUsername(rs.getString("username"));
				employee.setName(rs.getString("name"));
				employee.setSex(rs.getString("sex"));
				employee.setComingDate(rs.getString("comingDate"));
				employee.setEmployeeImg(rs.getString("employeeImg"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employee;
	}
	
	//插入一条员工信息
		public boolean addEmployee(Employee employee){
			boolean flag = false;
			this.conn = getConn();
			this.stmt = getStmt();
			String sql1 = "insert into user value('"+employee.getUsername()+"','"+employee.getPassword()+"','employee')";
			String sql2 = "insert into employeeinfo value('"+employee.getUsername()+"','"+employee.getName()+"','"+employee.getSex()+"','"+employee.getComingDate()+"','"+employee.getEmployeeImg()+"')";
			try{
				int num1 = stmt.executeUpdate(sql1);
				int num2 = stmt.executeUpdate(sql2);
				if(num1==1&&num2==1){		//等于1时插入成功
					flag = true;
				}
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return flag;
		}
		//删除一个员工
		public boolean delete(Employee employee){
			boolean flag = false;
			this.conn = getConn();
			this.stmt = getStmt();
			String sql1 = "delete from user where username = '"+employee.getUsername()+"'";
			String sql2 = "delete from employeeinfo where username = '"+employee.getUsername()+"'";
			try{
				int num1 = stmt.executeUpdate(sql1);
				int num2 = stmt.executeUpdate(sql2);
				if(num1==1&&num2==1){
					flag = true;
				}
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return flag;
		}
		
		
		//查询所有员工
		public  ArrayList<Employee> queryAll() {
			Employee employee = null;
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			this.conn = getConn();
			this.stmt = getStmt();
			String sql = "select * from employeeinfo";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				while(rs!=null &&rs.next()){
					employee = new Employee();
					employee.setUsername(rs.getString("username"));
					employee.setName(rs.getString("name"));
					employee.setSex(rs.getString("sex"));
					employee.setComingDate(rs.getString("comingDate"));
					employee.setEmployeeImg(rs.getString("employeeImg"));
					employeeList.add(employee);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return employeeList;
		}
}
