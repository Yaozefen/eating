package com.Dao;
import com.model.Addr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.struts2.ServletActionContext;




public class AllactiveDao extends DBAccess {
	//ģ������
	private Addr ad;
	public Addr getAd() {
		return ad;
	}

	public void setAd(Addr ad) {
		this.ad = ad;
	}
	
	//��������
	ArrayList<LinkedHashMap<String,Object>> list=null;
	LinkedHashMap<String, Object> map=null;
	
	

		//��ȡ��ѯ���ݣ�ȫ����ѯ
		public Boolean search(Addr ad,String username) {
			Boolean a=false;
			DBAccess dba=new DBAccess();
			try {
				if(dba.getConn()!=null) {
	            	
	                String sSql = "select * from address where username=?";
	                Connection conn = dba.getConn();
					PreparedStatement pstmt=conn.prepareStatement(sSql);
					pstmt.setString(1, username);
	               
	                ResultSet rs = dba.query(pstmt);
	                if (rs != null) {
	                    java.sql.ResultSetMetaData rsmd =rs.getMetaData();/*  ��ȡ��Ľṹ */
	                    int iNumOfCol =rsmd.getColumnCount();/* ��ȡ�е����� */
	                    list=new ArrayList<LinkedHashMap<String,Object>>();//����һ��list
	                    while(rs.next()){//�������������
	                        LinkedHashMap<String, Object> rsMap=new LinkedHashMap<String, Object>(iNumOfCol);//����һ��map������������
	                        for(int i=1;i<=iNumOfCol;i++){//ѭ�����ÿһ�кͶ�Ӧ��ֵ������map�У���ṹ�������get()
	                            rsMap.put(rsmd.getColumnName(i),rs.getObject(i));
	                        }
	                        list.add(rsMap);//��map����list
	                        ServletActionContext.getServletContext().setAttribute("addrlist", list);//��װlist
	                    /*ValueStack stack = ActionContext.getContext().getValueStack();
	                    stack.set("userList",list);*/
	                    }ServletActionContext.getServletContext().setAttribute("addrlist", list);

	                }
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return a;
		}
		
		//�������
		public Boolean AddAddr(Addr ad,String username) {
			Boolean a=false;
			DBAccess dba=new DBAccess();
			try {
				if(dba.getConn()!=null) {
					String sql="insert into address(name,absolutephone,address,cellphone,province,username) values(?,?,?,?,?,?)";
					Connection conn=dba.getConn();
					
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, ad.getName());
					pstmt.setString(2, ad.getAbsolutephone());
					pstmt.setString(3, ad.getAddress());
					pstmt.setString(4, ad.getCellphone());
					pstmt.setString(5, ad.getProvince());
				    pstmt.setString(6, username);
					int count=pstmt.executeUpdate();
					if(count!=0) {
						a=true;
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return a;
		}
	//�޸�	
public Boolean modify(Addr ad,String username) {
			boolean a=false;
			int count=1;
			DBAccess dba=new DBAccess();
			try {
				if(dba.getConn()!=null) {
					Connection conn=dba.getConn();
					String sql="update address set name=?,address=?,province=?,cellphone=? where username=? and absolutephone=?";
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, ad.getName());
					pstmt.setString(2, ad.getAddress());
					pstmt.setString(3, ad.getProvince());
					pstmt.setString(4, ad.getCellphone());
					pstmt.setString(5, username);
					pstmt.setString(6, ad.getAbsolutephone());
					count=pstmt.executeUpdate();
					if(count!=0) {
					a=true;}
					
				}
			}catch(SQLException e) {e.printStackTrace();}
			return a;
		}
//ɾ��
public int deleteAddr(Addr ad) {
	int count=1;
	DBAccess dba=new DBAccess();
	try {
		if(dba.getConn()!=null) {
			Connection conn=dba.getConn();
			String sql="delete from address where address=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ad.getAddress());	
			count=pstmt.executeUpdate();
			
		}
	}catch(SQLException e) {e.printStackTrace();}
	return count;
}

//ģ����ѯ
public Boolean likesearch(Addr ad,String username) {
	int count=1;
	Boolean a=false;
	DBAccess dba=new DBAccess();
	try {
		if(dba.getConn()!=null) {
			String sql="select * from address where cellphone like ? and username=?";//ģ����ѯ
			Connection conn=dba.getConn();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ad.getKeyword()+"%");//ģ����ѯ
			pstmt.setString(2, username);
			ResultSet rs = dba.query(pstmt);
            if (rs != null) {
                java.sql.ResultSetMetaData rsmd =rs.getMetaData();/*  ��ȡ��Ľṹ */
                int iNumOfCol =rsmd.getColumnCount();/* ��ȡ�е����� */
                list=new ArrayList<LinkedHashMap<String,Object>>();//����һ��list
                while(rs.next()){//�������������
                    LinkedHashMap<String, Object> rsMap=new LinkedHashMap<String, Object>(iNumOfCol);//����һ��map������������
                    for(int i=1;i<=iNumOfCol;i++){//ѭ�����ÿһ�кͶ�Ӧ��ֵ������map�У���ṹ�������get()
                        rsMap.put(rsmd.getColumnName(i),rs.getObject(i));
                    }
                    list.add(rsMap);//��map����list
                    ServletActionContext.getServletContext().setAttribute("addrlist", list);//��װlist
               
                }ServletActionContext.getServletContext().setAttribute("addrlist", list);

		}
	}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return a;
}
//�޸�֮��ȡָ������
public Addr Modify2(Addr ad) {//��ѯ���ǻ�ȡ����
	Boolean a=false;
	int count;
	java.sql.ResultSetMetaData rsmd;
	ArrayList<LinkedHashMap<String,Object>> list=null;
	LinkedHashMap<String, Object> map=null;
	
	DBAccess dba=new DBAccess();
	
	try {
		if(dba.getConn()!=null){
			String sql="select * from address where cellphone=?";
			
			Connection conn=dba.getConn();
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,ad.getCellphone());
			ResultSet rs=dba.query(pstmt);
			while (rs.next()) {
                ad.setName(rs.getString("name"));
                ad.setAbsolutephone(rs.getString("absolutephone"));
                ad.setAddress(rs.getString("address"));
                ad.setCellphone(rs.getString("cellphone"));
                ad.setProvince(rs.getString("province"));
            }
		}
	}catch (SQLException e) {
        e.printStackTrace();
    } finally {
        dba.closeConnection();
    
}
	return ad;
}}
//��½��֤
/*public boolean submit(User user){
    DBAccess dba=new DBAccess();
    Boolean a=false;
    try {
        if (dba.getConn()!=null){
            String sSql="select * from  register where username=? and password=?";
                Connection conn=dba.getConn();
                PreparedStatement pstmt=conn.prepareStatement(sSql);
                pstmt.setString(1,user.getUsername());
                pstmt.setString(2,user.getPassword());
                ResultSet rs= dba.query(pstmt);
                if(rs!=null&&rs.next()){
                    a=true;
                }
        }

    }catch (Exception e){e.printStackTrace();}

    finally {
        dba.closeConnection();
    }
    return a;*/

		




