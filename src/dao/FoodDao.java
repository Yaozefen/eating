package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DetailFood;
import model.Food;
import model.Shop;
import model.UserInfo;

public class FoodDao extends DbDao{										
	//鑿滅殑鍒嗙被鏌ヨ
	public ArrayList<model.Food> query(String type){
		ArrayList<Food> list = new ArrayList<Food>();
		String sql = "select * from dish where type=?";
		this.conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			ResultSet rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				Food dish= new Food();
				dish.setDishImg(rs.getString("dishImg"));
				dish.setDishName(rs.getString("dishName"));
				dish.setPrice(rs.getDouble("price"));
				dish.setType(rs.getString("type"));
				dish.setIntroduction(rs.getString("introduction"));
				dish.setSales(rs.getInt("sales"));
				list.add(dish);
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return list;
	}
	
	//鑿滅殑璇︽儏鏌ヨ
	public DetailFood queryAll(String id){
		/*ArrayList<DetailFood> list = new ArrayList<DetailFood>();*/
		DetailFood dish = null;
		String sql = "select * from de where dishName=?";
		System.out.println(id);
		this.conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				dish= new DetailFood();
				dish.setDishImg(rs.getString("dishImg"));
				dish.setDishName(rs.getString("dishName"));
				dish.setPrice(rs.getString("price"));
				dish.setType(rs.getString("type"));
				dish.setIntroduction(rs.getString("introduction"));
				dish.setSales(rs.getString("sales"));
				dish.setAppraiser(rs.getString("appraiser"));
				dish.setEvalWord(rs.getString("evalWord"));
				dish.setEvalTime(rs.getString("evalTime"));
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return dish;
	}
	
	//鍔犲叆璐墿杞�
	public boolean addShop(Shop shop) {
		boolean flag = false;
		String sql = "insert into cartTable(dishName,price,number,username) values('"+shop.getDishName()+"','"+shop.getPrice()+"','"+shop.getNumber()+"','"+shop.getUsername()+"')";
		this.conn = this.getConn();
		this.stmt = this.getStmt();
		try {
			int i = stmt.executeUpdate(sql);
			if(i==1) {
				flag = true;
			}else {
				flag = false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//璐墿杞︽煡璇�
	public ArrayList<model.Shop> queryShop(String username){
		ArrayList<model.Shop> list = new ArrayList<model.Shop>();
		String sql = "select * from cartTable where username = '"+username+"'";
		this.conn = this.getConn();
		this.stmt = this.getStmt();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs!=null && rs.next()) {
				Shop shop = new Shop();
				shop.setDishName(rs.getString("dishName"));
				shop.setNumber(rs.getInt("number"));
				shop.setPrice(rs.getFloat("price"));
				list.add(shop);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//鎼滅储妗嗘煡璇�
	public ArrayList<model.Food> search(String dishName){
		ArrayList<Food> list = new ArrayList<Food>();
		String sql = "select * from dish where dishName=?";
		this.conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dishName);
			ResultSet rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				Food dish= new Food();
				dish.setDishImg(rs.getString("dishImg"));
				dish.setDishName(rs.getString("dishName"));
				dish.setPrice(rs.getDouble("price"));
				dish.setType(rs.getString("type"));
				dish.setIntroduction(rs.getString("introduction"));
				dish.setSales(rs.getInt("sales"));
				list.add(dish);
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return list;
	}
	
	//鑿滅殑涓婃灦
	public boolean addFood(Food food,String address) {
		boolean flag = false;
		this.conn = getConn();
		this.stmt = getStmt();
		String sql = "insert into dish(dishImg,dishName,type,price,introduction,sales) values('"+address+"','"+food.getDishName()+"','"+food.getType()+"','"+food.getPrice()+"','"+food.getIntroduction()+"','"+food.getSales()+"')";
		try {
			int i = stmt.executeUpdate(sql);
			if(i==1) {
				flag = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;	
	}
	
	//鎵�鏈夎彍鏌ヨ
	public ArrayList<model.Food> allFood(){
		ArrayList<Food> list = new ArrayList<Food>();
		String sql = "select * from dish ";
		this.conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				Food dish= new Food();
				dish.setDishImg(rs.getString("dishImg"));
				dish.setDishName(rs.getString("dishName"));
				dish.setPrice(rs.getDouble("price"));
				dish.setType(rs.getString("type"));
				dish.setIntroduction(rs.getString("introduction"));
				dish.setSales(rs.getInt("sales"));
				list.add(dish);
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return list;
	}
	//鑿滃搧涓嬫灦
	public boolean delFood(String dishname) {
		boolean flag = false;
		String sql = "delete from dish where dishName='"+dishname+"'";
		this.conn = this.getConn();
		this.stmt = this.getStmt();
		try {
			int i = stmt.executeUpdate(sql);
			if(i==1) {
				flag=true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
