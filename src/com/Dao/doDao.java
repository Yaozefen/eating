package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.struts2.ServletActionContext;

import com.model.Forum;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;

public class doDao {
	public Boolean fsearch() {
		Boolean a=false;
		DBAccess dba=new DBAccess();
		try {
			if(dba.getConn()!=null) {
            	
                String sSql = "select * from forum";
                Connection conn = dba.getConn();
				PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sSql);
				/*pstmt.setString(1, username);*/
               
                ResultSet rs = dba.query(pstmt);
                if (rs != null) {
                    java.sql.ResultSetMetaData rsmd =rs.getMetaData();/*  锟斤拷取锟斤拷慕峁� */
                    int iNumOfCol =rsmd.getColumnCount();/* 锟斤拷取锟叫碉拷锟斤拷锟斤拷 */
                    ArrayList<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String,Object>>();//锟斤拷锟斤拷一锟斤拷list
                    while(rs.next()){//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
                        LinkedHashMap<String, Object> rsMap=new LinkedHashMap<String, Object>(iNumOfCol);//锟斤拷锟斤拷一锟斤拷map锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
                        for(int i=1;i<=iNumOfCol;i++){//循锟斤拷锟斤拷锟矫恳伙拷泻投锟接︼拷锟街碉拷锟斤拷锟斤拷锟絤ap锟叫ｏ拷锟斤拷峁癸拷锟斤拷锟斤拷锟斤拷get()
                            rsMap.put(rsmd.getColumnName(i),rs.getObject(i));
                        }
                        list.add(rsMap);//锟斤拷map锟斤拷锟斤拷list
                        ServletActionContext.getServletContext().setAttribute("flist", list);//锟斤拷装list
                        a=true;
                    /*ValueStack stack = ActionContext.getContext().getValueStack();
                    stack.set("userList",list);*/
                    }ServletActionContext.getServletContext().getAttribute("flist");

                }
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return a;
	}
	//获取指定数据
	public Boolean fshow(Forum f) {
		Boolean a=false;
		DBAccess dba=new DBAccess();
		try {
			if(dba.getConn()!=null) {
            	
                String sSql = "select * from forum where headline=?";
                Connection conn = dba.getConn();
				PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sSql);
				pstmt.setString(1, f.getHeadline());
               
                ResultSet rs = dba.query(pstmt);
                if (rs != null) {
                    java.sql.ResultSetMetaData rsmd =rs.getMetaData();/*  锟斤拷取锟斤拷慕峁� */
                    int iNumOfCol =rsmd.getColumnCount();/* 锟斤拷取锟叫碉拷锟斤拷锟斤拷 */
                    ArrayList<LinkedHashMap<String, Object>> list = new ArrayList<LinkedHashMap<String,Object>>();//锟斤拷锟斤拷一锟斤拷list
                    while(rs.next()){//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
                        LinkedHashMap<String, Object> rsMap=new LinkedHashMap<String, Object>(iNumOfCol);//锟斤拷锟斤拷一锟斤拷map锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
                        for(int i=1;i<=iNumOfCol;i++){//循锟斤拷锟斤拷锟矫恳伙拷泻投锟接︼拷锟街碉拷锟斤拷锟斤拷锟絤ap锟叫ｏ拷锟斤拷峁癸拷锟斤拷锟斤拷锟斤拷get()
                            rsMap.put(rsmd.getColumnName(i),rs.getObject(i));
                        }
                        list.add(rsMap);//锟斤拷map锟斤拷锟斤拷list
                        ActionContext.getContext().put("fslist",list);//锟斤拷装list
                        a=true;
                    /*ValueStack stack = ActionContext.getContext().getValueStack();
                    stack.set("userList",list);*/
                    }ServletActionContext.getServletContext().getAttribute("fslist");

                }
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return a;
	}
	//添加
	/*public Boolean fadd(Forum f,String username) {
		
		Boolean a=false;
		DBAccess dba=new DBAccess();
		try {
			if(dba.getConn()!=null) {
				String sql="insert into forum(headline,username,count,img,text) values(?,?,?,?,?)";
				Connection conn=dba.getConn();
				
				PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, f.getHeadline());
				pstmt.setString(2, username);
				pstmt.setString(3, f.getCount());
				pstmt.setString(4, f.getImg());
				pstmt.setString(5, f.getText());
			
				int count=pstmt.executeUpdate();
				if(count!=0) {
					a=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return a;
	}*/
}
