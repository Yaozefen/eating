package jl.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class BaseDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public void getConnection() {
        try{
            String url = "jdbc:mysql://localhost:3306/eating";
            String user = "root";
            String pass = "root";
            this.conn = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        if(conn==null) this.getConnection();
        return conn;
    }
    public Statement getStmt(){
        if(stmt!=null) return stmt;
        if(conn==null) this.getConnection();
        try{
            this.stmt = conn.createStatement();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return stmt;
    }
    public void closeConn(){
        try{
            if(conn!=null){
                conn.close();
            }
        }
        catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public void closeStmt() {
        if(stmt!=null){
            try{
                stmt.close();
            }
            catch (SQLException es) {
                // TODO: handle exception
            }
        }
    }
    public void closePstmt() {
        if(pstmt!=null){
            try{
                pstmt.close();
            }
            catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
    public void closeAll() {
        if(rs!=null){
            try{
                rs.close();
            }
            catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            this.closeConn();
            this.closeStmt();
            this.closePstmt();
        }
    }
}