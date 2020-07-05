package cn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.model.Dish;
import cn.model.User;



public class DishDao extends BaseDao{
	//上架一道菜品
	public boolean addDish(Dish dish){
		boolean flag = false;
		this.conn = getConn();
		this.stmt = getStmt();
		String sql = "insert into dish value('"+dish.getDishImg()+"','"+dish.getDishName()+"',"+dish.getPrice()+",'"+dish.getType()+"','"+dish.getIntroduction()+"','"+dish.getSales()+"')";
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
	//根据账号查询菜品信息
		public Dish queryDish(String content) {
			Dish dish=null;
			boolean flag = false;
			this.conn = getConn();
			this.stmt = getStmt();
			String sql = "select * from dish where dishName like '%"+content+"%' or type like '%"+content+"%'";
			try {
				ResultSet rs = stmt.executeQuery(sql);
				if (rs!=null &&rs.next()){
					dish=new Dish();
					
					dish.setDishName(rs.getString("dishName"));
					dish.setType(rs.getString("type"));
					dish.setPrice(rs.getFloat("price"));
					dish.setDishImg(rs.getString("dishImg"));
					dish.setIntroduction(rs.getString("introduction"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dish;
		}
				
				//下架一个菜品
				public boolean delete(Dish dish){
					boolean flag = false;
					this.conn = getConn();
					this.stmt = getStmt();
					String sql = "delete from dish where dishName = '"+dish.getDishName()+"'";
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
