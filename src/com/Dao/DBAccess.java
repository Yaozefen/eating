package com.Dao;

import java.sql.*;

public class DBAccess {
    private Connection conn=null;
    private Statement stmt=null;
    private ResultSet rs=null;
    private PreparedStatement pstmt=null;

    public DBAccess(){ }
    public Connection getConn(){
        if(conn==null){getConnection();}
        return conn;
    }
    public void getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://localhost:3306/eating?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
            this.conn= DriverManager.getConnection(url,"root","root");
            this.stmt=this.conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public ResultSet query(String strSql){
        ResultSet rs=null;
        try{
            rs=stmt.executeQuery(strSql);
        }catch (SQLException e){e.printStackTrace();}
        return  rs;
    }
    public ResultSet query(PreparedStatement pstmt){
        this.pstmt=pstmt;
        ResultSet rs=null;
        try {
            rs=this.pstmt.executeQuery();
        }catch (SQLException e){e.printStackTrace();}
        return  rs;
    }

    public void closeConnection(){
        try {if(rs!=null){rs.close();rs=null;}
        if (stmt!=null){stmt.close();stmt=null;}
        if (conn != null) {conn.close();conn=null;}
        if (pstmt!=null){pstmt.close();pstmt=null; }
        }catch (SQLException e){e.printStackTrace();}
    }




}

