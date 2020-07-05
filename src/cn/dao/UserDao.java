package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import cn.model.User;

public class UserDao extends BaseDao{
	//查询用户信息,登录查询
	public User login(String username,String password,String role){
		User userinfo = null;
		String sql = "select * from user where username = ? and password = ? and role = ?";
		Connection conn = this.getConn();			//继承父类的getconn()方法
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, role);
			ResultSet rs = pstmt.executeQuery();		//结果集
			if(rs!=null&&rs.next()){
				userinfo = new User();
				userinfo.setUsername(rs.getString("username"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setRole(rs.getString("role"));
			}
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			this.closeConn();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userinfo;
	}
	
	//查询是否有该用户,用于注册和登录的ajax验证
	public boolean search(String username){
		boolean flag = false;
		String sql = "select username from user where username = ?";
		this.conn = getConn();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();	
			if(rs!=null&&rs.next()){
				flag = true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	
	//注册信息,注册查询
	public boolean register(User user){
		boolean flag = false;
		this.conn = getConn();
		this.stmt = getStmt();
		String sql = "insert into user value('"+user.getUsername()+"','"+user.getPassword()+"','user')";
		
		try{
			int num = stmt.executeUpdate(sql);
			if(num==1){		//等于1时插入成功
				flag = true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	//修改用户密码
	public boolean update(User user){
		boolean flag = false;
		this.conn = getConn();
		this.stmt = getStmt();
		String sql = "update user set password = "+user.getPassword()+" where username = '"+user.getUsername()+"' and role = 'user'";
		try{
			int num = stmt.executeUpdate(sql);
			if(num==1){
				flag = true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag ;
	}
	
	//删除课程信息,暂时不用
	public boolean delete(User user){
		boolean flag = false;
		this.conn = getConn();
		this.stmt = getStmt();
		String sql = "delete from classes where className = ''";
		try{
			int num = stmt.executeUpdate(sql);
			if(num==1){
				flag = true;
			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
}
